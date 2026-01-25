package com.hungnguyen.flight;


import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.hungnguyen.flight"}, annotationClass = Mapper.class)
@EntityScan(basePackages = {"com.hungnguyen.flight"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}