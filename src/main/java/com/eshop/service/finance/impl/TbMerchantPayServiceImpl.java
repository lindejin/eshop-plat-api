package com.eshop.service.finance.impl;

import com.eshop.entity.finance.TbMerchantPay;
import com.eshop.mapper.finance.TbMerchantPayMapper;
import com.eshop.service.finance.ITbMerchantPayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商户充值 服务实现类
 * </p>
 *
 * @author finance
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_finance")
@Service
public class TbMerchantPayServiceImpl extends ServiceImpl<TbMerchantPayMapper, TbMerchantPay> implements ITbMerchantPayService {

}
