package com.eshop.service.job.impl;

import com.eshop.entity.job.XxlJobGroup;
import com.eshop.mapper.job.XxlJobGroupMapper;
import com.eshop.service.job.IXxlJobGroupService;
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
public class XxlJobGroupServiceImpl extends ServiceImpl<XxlJobGroupMapper, XxlJobGroup> implements IXxlJobGroupService {

}
