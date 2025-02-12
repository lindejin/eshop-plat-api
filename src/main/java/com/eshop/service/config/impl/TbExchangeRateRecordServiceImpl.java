package com.eshop.service.config.impl;

import com.eshop.entity.config.TbExchangeRateRecord;
import com.eshop.mapper.config.TbExchangeRateRecordMapper;
import com.eshop.service.config.ITbExchangeRateRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 汇率记录 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_config")
@Service
public class TbExchangeRateRecordServiceImpl extends ServiceImpl<TbExchangeRateRecordMapper, TbExchangeRateRecord> implements ITbExchangeRateRecordService {

}
