package com.eshop.service.finance.impl;

import com.eshop.entity.finance.TbMerchantFlowingWater;
import com.eshop.mapper.finance.TbMerchantFlowingWaterMapper;
import com.eshop.service.finance.ITbMerchantFlowingWaterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商户流水 服务实现类
 * </p>
 *
 * @author finance
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_finance")
@Service
public class TbMerchantFlowingWaterServiceImpl extends ServiceImpl<TbMerchantFlowingWaterMapper, TbMerchantFlowingWater> implements ITbMerchantFlowingWaterService {

}
