package com.xiaolong.MainModel.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaolong.MainModel.mapper.ReportMapper;
import com.xiaolong.MainModel.pojo.Report;
import com.xiaolong.MainModel.service.ReportService;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Report> implements ReportService {
}
