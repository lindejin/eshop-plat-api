package com.eshop.service.job.impl;

import com.eshop.entity.job.XxlJobLog;
import com.eshop.mapper.job.XxlJobLogMapper;
import com.eshop.service.job.IXxlJobLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author job
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_job")
@Service
public class XxlJobLogServiceImpl extends ServiceImpl<XxlJobLogMapper, XxlJobLog> implements IXxlJobLogService {

}
