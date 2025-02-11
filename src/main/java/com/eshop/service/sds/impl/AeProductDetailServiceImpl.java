package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeProductDetail;
import com.eshop.mapper.sds.AeProductDetailMapper;
import com.eshop.service.sds.IAeProductDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 速卖通商品详描 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class AeProductDetailServiceImpl extends ServiceImpl<AeProductDetailMapper, AeProductDetail> implements IAeProductDetailService {

}
