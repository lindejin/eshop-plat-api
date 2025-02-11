package com.eshop.service.supply.impl;

import com.eshop.entity.supply.TbPurchasesOrder;
import com.eshop.mapper.supply.TbPurchasesOrderMapper;
import com.eshop.service.supply.ITbPurchasesOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 采购单 服务实现类
 * </p>
 *
 * @author supply
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_supply")
@Service
public class TbPurchasesOrderServiceImpl extends ServiceImpl<TbPurchasesOrderMapper, TbPurchasesOrder> implements ITbPurchasesOrderService {

}
