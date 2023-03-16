package com.xiaolong.MainModel.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiaolong.MainModel.conment.R;
import com.xiaolong.MainModel.pojo.HotApp;
import com.xiaolong.MainModel.service.HotAppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/hotApp")
public class HotAppController {
    @Autowired
    private HotAppService hotAppService;
    @GetMapping("/list")
    public R<List<HotApp>> getAll(){
        LambdaQueryWrapper<HotApp> lqw = new LambdaQueryWrapper<>();
        lqw.orderByDesc(HotApp::getCreateTime);
        List<HotApp> list = hotAppService.list(lqw);
        return R.success(list);
    }
}
