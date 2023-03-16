package com.xiaolong.ClientStudent.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Resource {
    private String id  ;
    private String title ;
    private String url  ;
    private String password  ;
    private LocalDateTime createTime ;
}
