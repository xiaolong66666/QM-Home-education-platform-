package com.xiaolong.ClientStudent.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaolong.ClientStudent.mapper.FeedbackMapper;
import com.xiaolong.ClientStudent.pojo.Feedback;
import com.xiaolong.ClientStudent.service.FeedbackService;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {
}
