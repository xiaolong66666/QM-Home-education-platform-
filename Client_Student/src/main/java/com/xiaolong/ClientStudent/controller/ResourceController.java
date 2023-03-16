package com.xiaolong.ClientStudent.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiaolong.ClientStudent.conment.R;
import com.xiaolong.ClientStudent.pojo.Resource;
import com.xiaolong.ClientStudent.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;
    //默认加载返回所有信息
    @GetMapping("/list")
    public R<List<Resource>> getAll(){
        LambdaQueryWrapper<Resource> lqw = new LambdaQueryWrapper<>();
        lqw.orderByDesc(Resource::getCreateTime);
        List<Resource> list = resourceService.list(lqw);
        log.info("student端被访问");
        return R.success(list);
    }
    //模糊查询获得筛选资源
    @GetMapping("/list/like")
    public R<List<Resource>> getByLike(String msg1,String msg2){
        LambdaQueryWrapper<Resource> lqw = new LambdaQueryWrapper<>();
        lqw.like(StringUtils.isNotEmpty(msg1),Resource::getTitle,msg1).like(StringUtils.isNotEmpty(msg2),Resource::getTitle,msg2);
        lqw.orderByDesc(Resource::getCreateTime);
        List<Resource> list = resourceService.list(lqw);
        return R.success(list);
    }
    //添加资源信息
    @PostMapping
    public R<String> addNew(@RequestBody Resource resource){
        resource.setCreateTime(LocalDateTime.now());
        boolean save = resourceService.save(resource);
        if (save){
            return R.success("添加成功！");
        }
        return R.error("服务器故障，请稍后再试...");
    }
}
