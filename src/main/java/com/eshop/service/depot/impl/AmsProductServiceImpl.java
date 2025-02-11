package com.eshop.service.depot.impl;

import com.eshop.entity.depot.AmsProduct;
import com.eshop.mapper.depot.AmsProductMapper;
import com.eshop.service.depot.IAmsProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * AMS商品信息 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class AmsProductServiceImpl extends ServiceImpl<AmsProductMapper, AmsProduct> implements IAmsProductService {

}
