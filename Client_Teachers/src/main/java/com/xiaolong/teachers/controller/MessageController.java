package com.xiaolong.teachers.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiaolong.teachers.conment.R;
import com.xiaolong.teachers.pojo.Message;
import com.xiaolong.teachers.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
@Slf4j
public class MessageController {
    @Autowired
    private MessageService messageService;
    //初始化数据
    @GetMapping("/list")
    public R<List<Message>> getMessage(){
        log.info("teacher端被访问");
        LambdaQueryWrapper<Message> lqw = new LambdaQueryWrapper<>();
        lqw.orderByAsc(Message::getSort);
        lqw.orderByDesc(Message::getCreateTime);
        List<Message> list = messageService.list(lqw);
        return R.success(list);
    }
    //查找数据
    @GetMapping("/select")
    public R<List<Message>> getSelect(String id,String addr,String content){
        LambdaQueryWrapper<Message> lqw = new LambdaQueryWrapper<>();
        lqw.eq(StringUtils.isNotEmpty(id),Message::getMemberId,id)
                        .like(StringUtils.isNotEmpty(addr),Message::getText,addr)
                        .like(StringUtils.isNotEmpty(content),Message::getText,content);
        lqw.orderByAsc(Message::getSort);
        lqw.orderByDesc(Message::getCreateTime);
        List<Message> list = messageService.list(lqw);
        return R.success(list);
    }
}
