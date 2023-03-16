package com.xiaolong.teachers.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaolong.teachers.mapper.MessageMapper;
import com.xiaolong.teachers.pojo.Message;
import com.xiaolong.teachers.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {
}
