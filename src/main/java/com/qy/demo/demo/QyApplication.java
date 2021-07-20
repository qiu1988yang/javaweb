package com.qy.demo.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.qy.demo.demo.mapper","com.qy.demo.demo.one.mapper"})
public class QyApplication {

    public static void main(String[] args) {
        SpringApplication.run(QyApplication.class, args);
    }

}
