package com.eshop.service.supply.impl;

import com.eshop.entity.supply.TbSupplierSku;
import com.eshop.mapper.supply.TbSupplierSkuMapper;
import com.eshop.service.supply.ITbSupplierSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 供应商_sku信息 服务实现类
 * </p>
 *
 * @author supply
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_supply")
@Service
public class TbSupplierSkuServiceImpl extends ServiceImpl<TbSupplierSkuMapper, TbSupplierSku> implements ITbSupplierSkuService {

}
