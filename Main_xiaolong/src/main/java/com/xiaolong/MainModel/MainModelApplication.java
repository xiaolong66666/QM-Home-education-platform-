package com.xiaolong.MainModel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@Slf4j
@EnableFeignClients
public class MainModelApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainModelApplication.class,args);
    }
}
