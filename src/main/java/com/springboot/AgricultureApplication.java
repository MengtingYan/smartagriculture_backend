package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.springboot.mapper.po")
@EnableJpaRepositories(value = {"com.springboot.dao"}, basePackages = "com.springboot.mapper")
public class AgricultureApplication {
    public static void main(String[] args) {
        SpringApplication.run(AgricultureApplication.class,args);
    }
}
