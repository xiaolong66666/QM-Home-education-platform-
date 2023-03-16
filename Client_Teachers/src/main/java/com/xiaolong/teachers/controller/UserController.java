package com.xiaolong.teachers.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.xiaolong.teachers.conment.R;
import com.xiaolong.teachers.pojo.User;
import com.xiaolong.teachers.pojo.UserDto;
import com.xiaolong.teachers.service.SendMailService;
import com.xiaolong.teachers.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SendMailService sendMailService;
    //登录实现
    @PostMapping("/login")
    public R<String> login(@RequestBody User user,HttpServletRequest req){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getUsername,user.getUsername());
        User user1 = userService.getOne(lqw);
        //监测用户名
        if (user1 == null){
            return R.error("该用户不存在");
        }
        //监测密码
        String password = user1.getPassword();
        if (!password.equals(user.getPassword())){
            return R.error("密码错误");
        }
        //监测账号是否禁用
        if (user1.getStatus()==0){
            return R.error("该账号已禁用");
        }
        //添加session
        HttpSession session = req.getSession();
        session.setAttribute("username",user.getUsername());
        log.info(user.getUsername()+"登录teacher端");
        return R.success("登陆成功");
    }
    //注册实现
    @PostMapping("/register")
    public R<String> register(@RequestBody UserDto userDto){
        userDto.setCreateTime(LocalDateTime.now());
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getUsername,userDto.getUsername());
        User user = userService.getOne(lqw);
        //检查验证码是否正确
        if (!sendMailService.checkCode(userDto.getUsername(),userDto.getCode())){
            return R.error("验证码错误");
        }
        //查询用户是否已经注册
        if (user != null){
            return R.error("该用户已存在！");
        }
        //判断sql是否异常
        boolean save = userService.save(userDto);
        if (!save){
            return R.error("未知系统异常,请稍再试...");
        }
        log.info(userDto.getUsername()+"注册teacher端");
        return R.success("注册成功！");
    }
    //更新密码
    @PutMapping("/update")
    public R<String> update(@RequestBody UserDto userDto){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getUsername,userDto.getUsername());
        User user = userService.getOne(lqw);
        //检查验证码是否正确
        if (!sendMailService.checkCode(userDto.getUsername(),userDto.getCode())){
            return R.error("验证码错误");
        }
        //查询用户是否已经注册
        if (user == null){
            return R.error("该用户不存在！请先注册....");
        }
        //检查sql异常
        LambdaUpdateWrapper<User> luw = new LambdaUpdateWrapper<>();
        luw.eq(User::getUsername,userDto.getUsername());
        boolean update = userService.update(userDto, luw);
        if (!update){
            return R.error("系统未知异常！");
        }
        return R.success("密码修改成功！");
    }
    //返回用户信息
    @GetMapping("/userBaseMessage")
    public R<User> getMessage(HttpServletRequest req){
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null){
            return R.error("用户尚未登录！");
        }
        User user = new User();
        user.setUsername(username);
        return R.success(user);
    }
    //用户点击退出登录（删除session）
    @GetMapping("/loginOut")
    public void loginOut(HttpServletRequest req){
        HttpSession session = req.getSession();
        log.info((String) session.getAttribute("username")+"退出teacher端");
        session.removeAttribute("username");
    }
}
