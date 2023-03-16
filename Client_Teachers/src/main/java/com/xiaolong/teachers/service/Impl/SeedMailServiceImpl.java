package com.xiaolong.teachers.service.Impl;
import com.xiaolong.teachers.Utils.CodeUtils;
import com.xiaolong.teachers.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SeedMailServiceImpl implements SendMailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    //发送人
    private String from="2636822826@qq.com";
    //接收人
//    private String to="L2636822826@126.com";
    private String to;

    public void setTo(String to) {
        this.to = to;
    }
    //标题
    private String title="启梦平台";
    //验证码
    private String code;

    public void setCode(String code) {
        this.code = code;
    }
    @Autowired
    private CodeUtils codeUtils;
    //正文
    private String context;
    @Override
    public void seedMessage() throws MessagingException {
        this.context="欢迎"+this.to+"注册启梦平台！您的验证码是："+this.code;
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(title);
        helper.setText(context);
//        File file=new File("D:\\javaProjects\\Springboot_Project\\project7_mail\\src\\main\\resources\\IMG_0392(20210927-143732).JPG");
//        helper.addAttachment("picture.png",file);
        javaMailSender.send(mimeMessage);
//        System.out.println(to+"发送成功！");
    }

    @Override
    public Boolean checkCode(String mail,String code) {
        String code1 = codeUtils.getCode(mail);
        return code.equals(code1);
    }
}
