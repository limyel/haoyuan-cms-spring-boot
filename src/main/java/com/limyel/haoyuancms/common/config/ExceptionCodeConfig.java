package com.limyel.haoyuancms.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "haoyuan")
@PropertySource("classpath:config/exception-code.properties")
public class ExceptionCodeConfig {

    private Map<Integer, String> code = new HashMap<>();

    public Map<Integer, String> getCode() {
        return this.code;
    }

    public void setCode(Map<Integer, String> code) {
        this.code = code;
    }

    public String getMessage(int code) {
        return this.code.get(code);
    }

}
