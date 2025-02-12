package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeProductSku;
import com.eshop.mapper.sds.AeProductSkuMapper;
import com.eshop.service.sds.IAeProductSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 虾皮商品 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class AeProductSkuServiceImpl extends ServiceImpl<AeProductSkuMapper, AeProductSku> implements IAeProductSkuService {

}
