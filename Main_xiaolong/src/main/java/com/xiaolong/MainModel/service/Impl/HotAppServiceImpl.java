package com.xiaolong.MainModel.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaolong.MainModel.mapper.HotAppMapper;
import com.xiaolong.MainModel.pojo.HotApp;
import com.xiaolong.MainModel.service.HotAppService;
import org.springframework.stereotype.Service;

@Service
public class HotAppServiceImpl extends ServiceImpl<HotAppMapper, HotApp> implements HotAppService {
}
