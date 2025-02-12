package com.eshop.service.config.impl;

import com.eshop.entity.config.TbShopConfig;
import com.eshop.mapper.config.TbShopConfigMapper;
import com.eshop.service.config.ITbShopConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 店铺配置表 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_config")
@Service
public class TbShopConfigServiceImpl extends ServiceImpl<TbShopConfigMapper, TbShopConfig> implements ITbShopConfigService {

}
