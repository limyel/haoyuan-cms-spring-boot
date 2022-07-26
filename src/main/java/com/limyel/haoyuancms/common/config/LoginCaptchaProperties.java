package com.limyel.haoyuancms.common.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Slf4j
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "login-captcha")
public class LoginCaptchaProperties {

    // aes 密钥
    private String secret;

    // aes 偏移量
    private String iv;

    // 启用验证码
    private Boolean enabled = Boolean.FALSE;
}
