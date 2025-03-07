package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemplateDimension;
import com.eshop.mapper.sds.TemplateDimensionMapper;
import com.eshop.service.sds.ITemplateDimensionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 模版包装尺码 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class TemplateDimensionServiceImpl extends ServiceImpl<TemplateDimensionMapper, TemplateDimension> implements ITemplateDimensionService {

}
