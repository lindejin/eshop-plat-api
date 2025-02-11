package com.eshop.service.supply.impl;

import com.eshop.entity.supply.TbPurchasesDetail;
import com.eshop.mapper.supply.TbPurchasesDetailMapper;
import com.eshop.service.supply.ITbPurchasesDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 采购单明细 服务实现类
 * </p>
 *
 * @author supply
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_supply")
@Service
public class TbPurchasesDetailServiceImpl extends ServiceImpl<TbPurchasesDetailMapper, TbPurchasesDetail> implements ITbPurchasesDetailService {

}
