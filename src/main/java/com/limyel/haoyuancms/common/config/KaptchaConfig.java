package com.limyel.haoyuancms.common.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

import static com.google.code.kaptcha.Constants.*;

@Configuration
public class KaptchaConfig {

    @Bean
    public DefaultKaptcha defaultKaptcha() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty(KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");
        properties.setProperty(KAPTCHA_IMAGE_HEIGHT, "40");
        properties.setProperty(KAPTCHA_IMAGE_WIDTH, "120");
        properties.setProperty(KAPTCHA_TEXTPRODUCER_FONT_SIZE, "30");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

}
