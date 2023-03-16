package com.xiaolong.teachers.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaolong.teachers.mapper.OrdMapper;
import com.xiaolong.teachers.pojo.Ord;
import com.xiaolong.teachers.service.OrdService;
import org.springframework.stereotype.Service;

@Service
public class OrdServiceImpl extends ServiceImpl<OrdMapper,Ord> implements OrdService {
}
