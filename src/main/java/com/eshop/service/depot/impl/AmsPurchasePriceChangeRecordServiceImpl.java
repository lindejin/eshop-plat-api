package com.eshop.service.depot.impl;

import com.eshop.entity.depot.AmsPurchasePriceChangeRecord;
import com.eshop.mapper.depot.AmsPurchasePriceChangeRecordMapper;
import com.eshop.service.depot.IAmsPurchasePriceChangeRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * AMS采购价 变更记录 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_depot")
@Service
public class AmsPurchasePriceChangeRecordServiceImpl extends ServiceImpl<AmsPurchasePriceChangeRecordMapper, AmsPurchasePriceChangeRecord> implements IAmsPurchasePriceChangeRecordService {

}
