package com.pj.littlepig.testmain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.pj.littlepig")
@MapperScan("com.pj.littlepig.dao")
public class LittlepigApplication {
    public static void main(String[] args) {
        SpringApplication.run(LittlepigApplication.class, args);
    }


}
