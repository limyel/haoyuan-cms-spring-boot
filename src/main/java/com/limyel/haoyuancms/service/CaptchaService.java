package com.limyel.haoyuancms.service;

import cn.hutool.core.codec.Base64;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.limyel.haoyuancms.common.exception.HttpException;
import com.limyel.haoyuancms.common.util.RedisKey;
import com.limyel.haoyuancms.common.util.RedisUtil;
import com.limyel.haoyuancms.vo.CaptchaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class CaptchaService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private DefaultKaptcha kaptcha;

    @Value("${blog.captcha.expired:300}")
    private long expired;

    public static final String IMG_PREFIX = "data:image/png;base64,";

    public CaptchaVO generateCaptcha() {
        String text = kaptcha.createText();
        BufferedImage image = kaptcha.createImage(text);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String base64 = Base64.encode(stream.toByteArray());

        String tag = this.bindCaptcha(text);
        CaptchaVO vo = new CaptchaVO();
        vo.setTag(tag);
        vo.setCaptcha(this.base64Img(base64));

        return vo;
    }

    public boolean verifyCaptcha(String tag, String captcha) {
        String text = redisUtil.get(RedisKey.getCaptchaKey(tag));
        if (ObjectUtils.isEmpty(text)) {
            throw new HttpException(10001);
        }
        return false;
    }

    private String bindCaptcha(String captcha) {
        String tag = UUID.randomUUID().toString().replace("-", "");
        redisUtil.set(RedisKey.getCaptchaKey(tag), captcha, expired);
        return tag;
    }

    private String base64Img(String base64) {
        return IMG_PREFIX + base64;
    }
}
