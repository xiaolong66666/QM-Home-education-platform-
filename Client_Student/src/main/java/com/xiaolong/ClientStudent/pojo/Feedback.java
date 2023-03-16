package com.xiaolong.ClientStudent.pojo;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Feedback {
    private String id        ;
    private String text      ;
    private LocalDateTime createTime;
}
