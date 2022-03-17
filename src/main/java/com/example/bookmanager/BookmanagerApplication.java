package com.example.bookmanager;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.bookmanager.mapper")
public class BookmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookmanagerApplication.class, args);
    }

}
