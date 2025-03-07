package com.eshop.service.config.impl;

import com.eshop.entity.config.TbMerchant;
import com.eshop.mapper.config.TbMerchantMapper;
import com.eshop.service.config.ITbMerchantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商户信息 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_config")
@Service
public class TbMerchantServiceImpl extends ServiceImpl<TbMerchantMapper, TbMerchant> implements ITbMerchantService {

}
