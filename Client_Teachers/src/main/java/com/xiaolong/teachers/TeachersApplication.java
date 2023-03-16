package com.xiaolong.teachers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
@SpringBootApplication
@EnableCaching
@ServletComponentScan
@Slf4j
public class TeachersApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeachersApplication.class,args);
    }
}