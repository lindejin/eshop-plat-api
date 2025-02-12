package com.eshop.service.config.impl;

import com.eshop.entity.config.TbShopMerchant;
import com.eshop.mapper.config.TbShopMerchantMapper;
import com.eshop.service.config.ITbShopMerchantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 平台商户信息表 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_config")
@Service
public class TbShopMerchantServiceImpl extends ServiceImpl<TbShopMerchantMapper, TbShopMerchant> implements ITbShopMerchantService {

}
