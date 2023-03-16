package com.xiaolong.MainModel.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HotApp {
    private Long id         ;
    private String name       ;
    private String url        ;
    private LocalDateTime createTime;
}
