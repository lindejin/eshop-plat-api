package com.eshop.service.collect.impl;

import com.eshop.entity.collect.ClProductSku;
import com.eshop.mapper.collect.ClProductSkuMapper;
import com.eshop.service.collect.IClProductSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 采集商品sku信息 服务实现类
 * </p>
 *
 * @author collect
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_collect")
@Service
public class ClProductSkuServiceImpl extends ServiceImpl<ClProductSkuMapper, ClProductSku> implements IClProductSkuService {

}
