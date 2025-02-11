package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeProductSkuTutelagePrice;
import com.eshop.mapper.sds.AeProductSkuTutelagePriceMapper;
import com.eshop.service.sds.IAeProductSkuTutelagePriceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 速卖通产品sku分国家的日常促销价 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class AeProductSkuTutelagePriceServiceImpl extends ServiceImpl<AeProductSkuTutelagePriceMapper, AeProductSkuTutelagePrice> implements IAeProductSkuTutelagePriceService {

}
