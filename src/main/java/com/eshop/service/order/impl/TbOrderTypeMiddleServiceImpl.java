package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderTypeMiddle;
import com.eshop.mapper.order.TbOrderTypeMiddleMapper;
import com.eshop.service.order.ITbOrderTypeMiddleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单_订单类型(中间表) 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_order")
@Service
public class TbOrderTypeMiddleServiceImpl extends ServiceImpl<TbOrderTypeMiddleMapper, TbOrderTypeMiddle> implements ITbOrderTypeMiddleService {

}
