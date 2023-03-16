package com.xiaolong.ClientStudent.controller;
import com.xiaolong.ClientStudent.conment.R;
import com.xiaolong.ClientStudent.pojo.ClientMessage;
import com.xiaolong.ClientStudent.service.ClientMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
@RestController
@Slf4j
@RequestMapping("/clientMessage")
public class ClientMessageController {
    @Autowired
    private ClientMessageService clientMessageService;
    @PostMapping
    public R<String> addNew(@RequestBody ClientMessage clientMessage){
        clientMessage.setCreateTime(LocalDateTime.now());
        boolean save = clientMessageService.save(clientMessage);
        if (!save){
            R.error("系统未知异常，请稍后再试...");
        }
        return R.success("发送成功！");
    }
}
