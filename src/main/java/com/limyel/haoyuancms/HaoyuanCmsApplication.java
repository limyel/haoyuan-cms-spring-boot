package com.limyel.haoyuancms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.limyel.haoyuancms.mapper"})
@SpringBootApplication
public class HaoyuanCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HaoyuanCmsApplication.class, args);
    }

}
