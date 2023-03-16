package com.xiaolong.teachers.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Message {
    private String id         ;
    private String memberId  ;
    private String text       ;
    private Integer status     ;
    private Integer sort;
    private LocalDateTime createTime;
}
