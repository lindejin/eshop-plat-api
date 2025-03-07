package com.eshop.service.job.impl;

import com.eshop.entity.job.XxlJobLock;
import com.eshop.mapper.job.XxlJobLockMapper;
import com.eshop.service.job.IXxlJobLockService;
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
public class XxlJobLockServiceImpl extends ServiceImpl<XxlJobLockMapper, XxlJobLock> implements IXxlJobLockService {

}
