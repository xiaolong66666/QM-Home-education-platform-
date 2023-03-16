package com.xiaolong.teachers.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiaolong.teachers.conment.R;
import com.xiaolong.teachers.pojo.Member;
import com.xiaolong.teachers.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @GetMapping("/list")
    public R<List<Member>> getAll(){
        LambdaQueryWrapper<Member> lqw = new LambdaQueryWrapper<>();
        lqw.orderByAsc(Member::getSort);
        List<Member> list = memberService.list(lqw);
        return R.success(list);
    }

}
