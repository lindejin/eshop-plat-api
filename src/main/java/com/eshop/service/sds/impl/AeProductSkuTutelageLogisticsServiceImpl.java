package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeProductSkuTutelageLogistics;
import com.eshop.mapper.sds.AeProductSkuTutelageLogisticsMapper;
import com.eshop.service.sds.IAeProductSkuTutelageLogisticsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 速卖通产品物流信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class AeProductSkuTutelageLogisticsServiceImpl extends ServiceImpl<AeProductSkuTutelageLogisticsMapper, AeProductSkuTutelageLogistics> implements IAeProductSkuTutelageLogisticsService {

}
