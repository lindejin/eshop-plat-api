package com.eshop.service.supply.impl;

import com.eshop.entity.supply.TbSupplierSpu;
import com.eshop.mapper.supply.TbSupplierSpuMapper;
import com.eshop.service.supply.ITbSupplierSpuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 供应商_spu信息 服务实现类
 * </p>
 *
 * @author supply
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_supply")
@Service
public class TbSupplierSpuServiceImpl extends ServiceImpl<TbSupplierSpuMapper, TbSupplierSpu> implements ITbSupplierSpuService {

}
