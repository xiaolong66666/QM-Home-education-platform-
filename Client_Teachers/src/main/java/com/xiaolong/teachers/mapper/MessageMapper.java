package com.xiaolong.teachers.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaolong.teachers.pojo.Message;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper extends BaseMapper<Message> {
}
