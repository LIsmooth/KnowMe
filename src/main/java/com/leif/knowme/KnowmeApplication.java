package com.leif.knowme;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.leif.knowme.dao")
public class KnowmeApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnowmeApplication.class, args);
    }

}
