package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderType;
import com.eshop.mapper.order.TbOrderTypeMapper;
import com.eshop.service.order.ITbOrderTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单类型 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_order")
@Service
public class TbOrderTypeServiceImpl extends ServiceImpl<TbOrderTypeMapper, TbOrderType> implements ITbOrderTypeService {

}
