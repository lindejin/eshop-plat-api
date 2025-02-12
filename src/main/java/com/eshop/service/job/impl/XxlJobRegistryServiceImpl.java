package com.eshop.service.job.impl;

import com.eshop.entity.job.XxlJobRegistry;
import com.eshop.mapper.job.XxlJobRegistryMapper;
import com.eshop.service.job.IXxlJobRegistryService;
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
public class XxlJobRegistryServiceImpl extends ServiceImpl<XxlJobRegistryMapper, XxlJobRegistry> implements IXxlJobRegistryService {

}
