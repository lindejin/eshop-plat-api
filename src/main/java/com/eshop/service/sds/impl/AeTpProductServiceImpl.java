package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeTpProduct;
import com.eshop.mapper.sds.AeTpProductMapper;
import com.eshop.service.sds.IAeTpProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 速卖通商品 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class AeTpProductServiceImpl extends ServiceImpl<AeTpProductMapper, AeTpProduct> implements IAeTpProductService {

}
