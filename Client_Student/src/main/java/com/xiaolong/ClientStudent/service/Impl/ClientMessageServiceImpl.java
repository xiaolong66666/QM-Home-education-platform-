package com.xiaolong.ClientStudent.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaolong.ClientStudent.mapper.ClientMessageMapper;
import com.xiaolong.ClientStudent.pojo.ClientMessage;
import com.xiaolong.ClientStudent.service.ClientMessageService;
import org.springframework.stereotype.Service;

@Service
public class ClientMessageServiceImpl extends ServiceImpl<ClientMessageMapper, ClientMessage> implements ClientMessageService {
}
