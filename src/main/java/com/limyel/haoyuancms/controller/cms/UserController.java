package com.limyel.haoyuancms.controller.cms;

import com.limyel.haoyuancms.common.annotation.CosmoController;
import com.limyel.haoyuancms.common.exception.HttpException;
import com.limyel.haoyuancms.common.util.JwtUtil;
import com.limyel.haoyuancms.dto.LoginDTO;
import com.limyel.haoyuancms.entity.CmsUser;
import com.limyel.haoyuancms.service.CaptchaService;
import com.limyel.haoyuancms.service.CmsUserIdentityService;
import com.limyel.haoyuancms.service.CmsUserService;
import com.limyel.haoyuancms.vo.CaptchaVO;
import com.limyel.haoyuancms.vo.UserPermissionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "cms用户相关接口")
@CosmoController
@RestController
@RequestMapping("/cms/user")
public class UserController {

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private CmsUserService cmsUserService;

    @Autowired
    private CmsUserIdentityService cmsUserIdentityService;

    @Autowired
    private JwtUtil jwtUtil;

    @ApiOperation("生成验证码")
    @GetMapping("/captcha")
    public CaptchaVO getCaptcha() {
        return captchaService.generateCaptcha();
    }

    @ApiOperation("登录")
    @PostMapping("/login")
    public String login(
            @RequestBody @Validated LoginDTO loginDTO,
            @RequestHeader(value = "tag") String tag) {
        captchaService.verifyCaptcha(tag, loginDTO.getCaptcha());

        CmsUser user = cmsUserService.getByUsername(loginDTO.getUsername());
        if (ObjectUtils.isEmpty(user)) {
            throw new HttpException(10003);
        }
        boolean valid = cmsUserIdentityService.verifyUsernamePassword(user.getId(), user.getUsername(), loginDTO.getPassword());
        if (!valid) {
            throw new HttpException(10004);
        }
        return jwtUtil.generateToken(user);
    }

    @ApiOperation("当前用户权限")
    @GetMapping("/permission")
    public UserPermissionVO getPermission() {

    }
}
