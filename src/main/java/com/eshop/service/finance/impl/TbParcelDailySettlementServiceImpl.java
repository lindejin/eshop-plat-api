package com.eshop.service.finance.impl;

import com.eshop.entity.finance.TbParcelDailySettlement;
import com.eshop.mapper.finance.TbParcelDailySettlementMapper;
import com.eshop.service.finance.ITbParcelDailySettlementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 包裹每日结算 服务实现类
 * </p>
 *
 * @author finance
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_finance")
@Service
public class TbParcelDailySettlementServiceImpl extends ServiceImpl<TbParcelDailySettlementMapper, TbParcelDailySettlement> implements ITbParcelDailySettlementService {

}
