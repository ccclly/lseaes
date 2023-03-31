package com.cly.lseaes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class LseaesApplication {

    public static void main(String[] args) {
        SpringApplication.run(LseaesApplication.class, args);
    }

}
