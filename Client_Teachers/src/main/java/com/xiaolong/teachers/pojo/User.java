package com.xiaolong.teachers.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private String id         ;
    private String username   ;
    private String password   ;
    private Integer status    ;
    private LocalDateTime createTime;
}
