package com.limyel.haoyuancms.controller.cms;

import cn.hutool.core.codec.Base64;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.limyel.haoyuancms.common.exception.HttpException;
import com.limyel.haoyuancms.core.token.Token;
import com.limyel.haoyuancms.dto.LoginDTO;
import com.limyel.haoyuancms.entity.CmsUser;
import com.limyel.haoyuancms.service.CaptchaService;
import com.limyel.haoyuancms.service.CmsUserIdentityService;
import com.limyel.haoyuancms.service.CmsUserService;
import com.limyel.haoyuancms.vo.CaptchaVO;
import com.limyel.haoyuancms.vo.CaptchaVO;
import com.limyel.haoyuancms.vo.TokenVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Slf4j
@Api(tags = "cms用户相关接口")
@RestController
@RequestMapping("/cms/user")
public class UserController {

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private CmsUserService cmsUserService;

    @Autowired
    private CmsUserIdentityService cmsUserIdentityService;

    @ApiOperation("生成验证码")
    @GetMapping("/captcha")
    public CaptchaVO getCaptcha() {
        return captchaService.generateCaptcha();
    }

    @ApiOperation("登录")
    @PostMapping("/login")
    public TokenVO login(
            @RequestBody @Validated LoginDTO loginDTO,
            @RequestHeader(value = "tag") String tag) {
        captchaService.verifyCaptcha(tag, loginDTO.getCaptcha());

        CmsUser user = cmsUserService.getCmsUserByUsername(loginDTO.getUsername());
        if (ObjectUtils.isEmpty(user)) {
            throw new HttpException(10003);
        }
        boolean valid = cmsUserIdentityService.verifyUsernamePassword(user.getId(), user.getUsername(), loginDTO.getPassword());
        if (!valid) {
            throw new HttpException(10004);
        }
        return null;
    }
}
