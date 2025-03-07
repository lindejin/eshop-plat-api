package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ShopeeLogistics;
import com.eshop.mapper.sds.ShopeeLogisticsMapper;
import com.eshop.service.sds.IShopeeLogisticsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 虾皮物流通道 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class ShopeeLogisticsServiceImpl extends ServiceImpl<ShopeeLogisticsMapper, ShopeeLogistics> implements IShopeeLogisticsService {

}
