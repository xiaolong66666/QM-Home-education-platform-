package com.xiaolong.teachers.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaolong.teachers.pojo.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper extends BaseMapper<Member> {
}
