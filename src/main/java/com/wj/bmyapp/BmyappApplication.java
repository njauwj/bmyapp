package com.wj.bmyapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.wj.bmyapp.mapper")
public class BmyappApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmyappApplication.class, args);
    }

}
