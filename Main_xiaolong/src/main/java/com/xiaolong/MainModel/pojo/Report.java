package com.xiaolong.MainModel.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Report {
    private Long id ;
    private String title;
    private String text;
    private LocalDateTime createTime;
}
