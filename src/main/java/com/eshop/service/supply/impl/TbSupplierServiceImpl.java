package com.eshop.service.supply.impl;

import com.eshop.entity.supply.TbSupplier;
import com.eshop.mapper.supply.TbSupplierMapper;
import com.eshop.service.supply.ITbSupplierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 供应商 服务实现类
 * </p>
 *
 * @author supply
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_supply")
@Service
public class TbSupplierServiceImpl extends ServiceImpl<TbSupplierMapper, TbSupplier> implements ITbSupplierService {

}
