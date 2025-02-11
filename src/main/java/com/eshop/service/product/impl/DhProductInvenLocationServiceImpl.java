package com.eshop.service.product.impl;

import com.eshop.entity.product.DhProductInvenLocation;
import com.eshop.mapper.product.DhProductInvenLocationMapper;
import com.eshop.service.product.IDhProductInvenLocationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品备货地址信息列表 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_product")
@Service
public class DhProductInvenLocationServiceImpl extends ServiceImpl<DhProductInvenLocationMapper, DhProductInvenLocation> implements IDhProductInvenLocationService {

}
