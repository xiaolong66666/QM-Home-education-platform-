package com.xiaolong.ClientStudent.controller;

import com.xiaolong.ClientStudent.conment.R;
import com.xiaolong.ClientStudent.pojo.Feedback;
import com.xiaolong.ClientStudent.service.FeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Slf4j
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @PostMapping
    public R<String> save(@RequestBody Feedback feedback){
//        log.info(feedback.toString());
        feedback.setCreateTime(LocalDateTime.now());
        boolean save = feedbackService.save(feedback);
        if (save){
            return R.success("发送成功！");
        }
        return R.error("服务器未知异常！");
    }
}
