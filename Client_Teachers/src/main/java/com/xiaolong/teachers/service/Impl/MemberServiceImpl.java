package com.xiaolong.teachers.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaolong.teachers.mapper.MemberMapper;
import com.xiaolong.teachers.pojo.Member;
import com.xiaolong.teachers.service.MemberService;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {
}
