package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemplatePlatform;
import com.eshop.mapper.sds.TemplatePlatformMapper;
import com.eshop.service.sds.ITemplatePlatformService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 模版表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TemplatePlatformServiceImpl extends ServiceImpl<TemplatePlatformMapper, TemplatePlatform> implements ITemplatePlatformService {

}
