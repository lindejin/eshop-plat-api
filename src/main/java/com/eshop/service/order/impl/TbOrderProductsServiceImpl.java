package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderProducts;
import com.eshop.mapper.order.TbOrderProductsMapper;
import com.eshop.service.order.ITbOrderProductsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单商品明细 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_order")
@Service
public class TbOrderProductsServiceImpl extends ServiceImpl<TbOrderProductsMapper, TbOrderProducts> implements ITbOrderProductsService {

}
