package com.eshop.service.job.impl;

import com.eshop.entity.job.XxlJobLogglue;
import com.eshop.mapper.job.XxlJobLogglueMapper;
import com.eshop.service.job.IXxlJobLogglueService;
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
public class XxlJobLogglueServiceImpl extends ServiceImpl<XxlJobLogglueMapper, XxlJobLogglue> implements IXxlJobLogglueService {

}
