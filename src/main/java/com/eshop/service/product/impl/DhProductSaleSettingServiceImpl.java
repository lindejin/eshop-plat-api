package com.eshop.service.product.impl;

import com.eshop.entity.product.DhProductSaleSetting;
import com.eshop.mapper.product.DhProductSaleSettingMapper;
import com.eshop.service.product.IDhProductSaleSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品销售属性设置 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class DhProductSaleSettingServiceImpl extends ServiceImpl<DhProductSaleSettingMapper, DhProductSaleSetting> implements IDhProductSaleSettingService {

}
