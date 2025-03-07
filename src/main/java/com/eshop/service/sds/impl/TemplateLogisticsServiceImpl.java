package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemplateLogistics;
import com.eshop.mapper.sds.TemplateLogisticsMapper;
import com.eshop.service.sds.ITemplateLogisticsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 模版物流通道 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TemplateLogisticsServiceImpl extends ServiceImpl<TemplateLogisticsMapper, TemplateLogistics> implements ITemplateLogisticsService {

}
