package com.xiaolong.teachers.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Ord {
    private String id          ;
    private String username     ;
    private String messageId  ;
    private LocalDateTime createTime ;
}
