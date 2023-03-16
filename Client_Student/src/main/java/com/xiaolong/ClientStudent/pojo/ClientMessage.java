package com.xiaolong.ClientStudent.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClientMessage {
    private String id        ;
    private String name      ;
    private String phone     ;
    private String message   ;
    private LocalDateTime createTime;
}
