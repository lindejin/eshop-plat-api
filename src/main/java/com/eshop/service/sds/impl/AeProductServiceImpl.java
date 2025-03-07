package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeProduct;
import com.eshop.mapper.sds.AeProductMapper;
import com.eshop.service.sds.IAeProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 速卖通商品 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class AeProductServiceImpl extends ServiceImpl<AeProductMapper, AeProduct> implements IAeProductService {

}
