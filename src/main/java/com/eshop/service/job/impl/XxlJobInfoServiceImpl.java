package com.eshop.service.job.impl;

import com.eshop.entity.job.XxlJobInfo;
import com.eshop.mapper.job.XxlJobInfoMapper;
import com.eshop.service.job.IXxlJobInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author job
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_job")
@Service
public class XxlJobInfoServiceImpl extends ServiceImpl<XxlJobInfoMapper, XxlJobInfo> implements IXxlJobInfoService {

}
