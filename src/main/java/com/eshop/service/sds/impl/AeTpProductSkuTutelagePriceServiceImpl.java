package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeTpProductSkuTutelagePrice;
import com.eshop.mapper.sds.AeTpProductSkuTutelagePriceMapper;
import com.eshop.service.sds.IAeTpProductSkuTutelagePriceService;
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
public class AeTpProductSkuTutelagePriceServiceImpl extends ServiceImpl<AeTpProductSkuTutelagePriceMapper, AeTpProductSkuTutelagePrice> implements IAeTpProductSkuTutelagePriceService {

}
