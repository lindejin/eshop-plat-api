package com.eshop.service.sds.impl;

import com.eshop.entity.sds.DhTpProductSaleSetting;
import com.eshop.mapper.sds.DhTpProductSaleSettingMapper;
import com.eshop.service.sds.IDhTpProductSaleSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品销售属性设置 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class DhTpProductSaleSettingServiceImpl extends ServiceImpl<DhTpProductSaleSettingMapper, DhTpProductSaleSetting> implements IDhTpProductSaleSettingService {

}
