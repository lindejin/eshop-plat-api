package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbPrototypeMerchant;
import com.eshop.mapper.sds.TbPrototypeMerchantMapper;
import com.eshop.service.sds.ITbPrototypeMerchantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 样机_商户关联 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TbPrototypeMerchantServiceImpl extends ServiceImpl<TbPrototypeMerchantMapper, TbPrototypeMerchant> implements ITbPrototypeMerchantService {

}
