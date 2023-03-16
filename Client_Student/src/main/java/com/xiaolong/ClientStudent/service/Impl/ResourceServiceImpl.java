package com.xiaolong.ClientStudent.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaolong.ClientStudent.mapper.ResourceMapper;
import com.xiaolong.ClientStudent.pojo.Resource;
import com.xiaolong.ClientStudent.service.ResourceService;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {
}
