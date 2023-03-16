package com.xiaolong.MainModel.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiaolong.MainModel.conment.R;
import com.xiaolong.MainModel.pojo.Report;
import com.xiaolong.MainModel.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;
    @GetMapping("/list")
    public R<List<Report>> getAll(String title){
        log.info("官网被访问");
        LambdaQueryWrapper<Report> lqw = new LambdaQueryWrapper<>();
        lqw.like(StringUtils.isNotEmpty(title),Report::getTitle,title);
        lqw.orderByDesc(Report::getCreateTime);
        List<Report> list = reportService.list(lqw);
        return R.success(list);
    }
}
