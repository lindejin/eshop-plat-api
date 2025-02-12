package com.eshop.service.supply.impl;

import com.eshop.entity.supply.TbPurchasesWaybill;
import com.eshop.mapper.supply.TbPurchasesWaybillMapper;
import com.eshop.service.supply.ITbPurchasesWaybillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 采购 运单信息 服务实现类
 * </p>
 *
 * @author supply
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_supply")
@Service
public class TbPurchasesWaybillServiceImpl extends ServiceImpl<TbPurchasesWaybillMapper, TbPurchasesWaybill> implements ITbPurchasesWaybillService {

}
