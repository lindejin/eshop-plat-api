package com.eshop.service.config.impl;

import com.eshop.entity.config.TbExchangeRate;
import com.eshop.mapper.config.TbExchangeRateMapper;
import com.eshop.service.config.ITbExchangeRateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 汇率 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_config")
@Service
public class TbExchangeRateServiceImpl extends ServiceImpl<TbExchangeRateMapper, TbExchangeRate> implements ITbExchangeRateService {

}
