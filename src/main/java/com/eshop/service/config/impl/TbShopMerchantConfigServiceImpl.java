package com.eshop.service.config.impl;

import com.eshop.entity.config.TbShopMerchantConfig;
import com.eshop.mapper.config.TbShopMerchantConfigMapper;
import com.eshop.service.config.ITbShopMerchantConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 店铺商户配置表 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_config")
@Service
public class TbShopMerchantConfigServiceImpl extends ServiceImpl<TbShopMerchantConfigMapper, TbShopMerchantConfig> implements ITbShopMerchantConfigService {

}
