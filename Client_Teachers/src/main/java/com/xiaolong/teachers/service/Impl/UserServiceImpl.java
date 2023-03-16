package com.xiaolong.teachers.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaolong.teachers.mapper.UserMapper;
import com.xiaolong.teachers.pojo.User;
import com.xiaolong.teachers.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
