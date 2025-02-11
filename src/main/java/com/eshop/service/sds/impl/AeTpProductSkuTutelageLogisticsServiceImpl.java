package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeTpProductSkuTutelageLogistics;
import com.eshop.mapper.sds.AeTpProductSkuTutelageLogisticsMapper;
import com.eshop.service.sds.IAeTpProductSkuTutelageLogisticsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 速卖通产品物流信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class AeTpProductSkuTutelageLogisticsServiceImpl extends ServiceImpl<AeTpProductSkuTutelageLogisticsMapper, AeTpProductSkuTutelageLogistics> implements IAeTpProductSkuTutelageLogisticsService {

}
