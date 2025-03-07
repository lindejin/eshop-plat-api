package com.eshop.service.config.impl;

import com.eshop.entity.config.TbPlatform;
import com.eshop.mapper.config.TbPlatformMapper;
import com.eshop.service.config.ITbPlatformService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 平台 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_config")
@Service
public class TbPlatformServiceImpl extends ServiceImpl<TbPlatformMapper, TbPlatform> implements ITbPlatformService {

}
