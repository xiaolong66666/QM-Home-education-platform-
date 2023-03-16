package com.xiaolong.teachers.controller;
import com.xiaolong.teachers.Utils.CodeUtils;
import com.xiaolong.teachers.conment.R;
import com.xiaolong.teachers.service.Impl.SeedMailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/mail")
public class SendMessageController {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private CodeUtils codeUtils;
    //生成验证码
    @GetMapping
    public R<String> sendMessage(String mail) throws MessagingException {
//        System.out.println("-----------"+mail);
        SeedMailServiceImpl seedMailService = new SeedMailServiceImpl();
        seedMailService.setJavaMailSender(javaMailSender);
        seedMailService.setCode(codeUtils.generator(mail));
        seedMailService.setTo(mail);
        seedMailService.seedMessage();
        return R.success("Success!");
    }
}
