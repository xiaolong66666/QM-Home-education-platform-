package com.xiaolong.teachers.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.xiaolong.teachers.conment.R;
import com.xiaolong.teachers.pojo.Message;
import com.xiaolong.teachers.pojo.Ord;
import com.xiaolong.teachers.pojo.OrdDto;
import com.xiaolong.teachers.service.MessageService;
import com.xiaolong.teachers.service.OrdService;
import com.xiaolong.teachers.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/ord")
public class OrdController {
    @Autowired
    private OrdService ordService;
    @Autowired
    private MessageService messageService;
    //添加订单
    @PostMapping
    public R<String> addOrder(@RequestBody Ord ord, HttpServletRequest req){
        //判断是否登录
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null){
            return R.error("尚未登录");
        }
        //判断是否订单已近存在
        LambdaUpdateWrapper<Ord> lqw = new LambdaUpdateWrapper<>();
        lqw.eq(Ord::getUsername,username).eq(Ord::getMessageId,ord.getMessageId());
        Ord one = ordService.getOne(lqw);
        if (one != null){
            return R.error("该订单已存在");
        }
        ord.setCreateTime(LocalDateTime.now());
        ord.setUsername(username);
        boolean save = ordService.save(ord);
        if (save){
            return R.success("");
        }
        return R.error("系统未知错误");
    }
    //返回该用户最新订单
    @GetMapping("/latest")
    public R<OrdDto> getLatest(HttpServletRequest req){
        //判断用户是否登录
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null){
            return R.error("尚未登录");
        }
        //根据username查询所有订单
        LambdaQueryWrapper<Ord> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Ord::getUsername,username);
        lqw.orderByDesc(Ord::getCreateTime);
        List<Ord> list = ordService.list(lqw);
        if (list == null){
            return R.error("该用户无订单");
        }
        //根据messageid查找家教详情
        Ord ord=list.get(0);
        OrdDto ordDto = new OrdDto();
        BeanUtils.copyProperties(ord,ordDto);
        Message message = messageService.getById(ord.getMessageId());
        ordDto.setText(message.getText());
        ordDto.setMemberId(message.getMemberId());
        return R.success(ordDto);
    }
    @GetMapping("/list")
    public R<List<OrdDto>> getAll(HttpServletRequest req){
        //判断用户是否登录
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null){
            return R.error("尚未登录");
        }
        //根据username查询所有订单
        LambdaQueryWrapper<Ord> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Ord::getUsername,username);
        lqw.orderByDesc(Ord::getCreateTime);
        List<Ord> ords = ordService.list(lqw);
        List<OrdDto> ordDtos=new ArrayList<>();
        for (Ord ord : ords) {
            OrdDto ordDto = new OrdDto();
            BeanUtils.copyProperties(ord,ordDto);
            String messageId = ord.getMessageId();
            Message message = messageService.getById(messageId);
            ordDto.setText(message.getText());
            ordDtos.add(ordDto);
        }
        return R.success(ordDtos);
    }
}
