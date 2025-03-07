package com.eshop.service.supply.impl;

import com.eshop.entity.supply.TbPurchasesWaybillTrace;
import com.eshop.mapper.supply.TbPurchasesWaybillTraceMapper;
import com.eshop.service.supply.ITbPurchasesWaybillTraceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 采购单物流轨迹 服务实现类
 * </p>
 *
 * @author supply
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_supply")
@Service
public class TbPurchasesWaybillTraceServiceImpl extends ServiceImpl<TbPurchasesWaybillTraceMapper, TbPurchasesWaybillTrace> implements ITbPurchasesWaybillTraceService {

}
