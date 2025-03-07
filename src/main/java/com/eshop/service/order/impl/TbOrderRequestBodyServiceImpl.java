package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderRequestBody;
import com.eshop.mapper.order.TbOrderRequestBodyMapper;
import com.eshop.service.order.ITbOrderRequestBodyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单请求数据存储 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_order")
@Service
public class TbOrderRequestBodyServiceImpl extends ServiceImpl<TbOrderRequestBodyMapper, TbOrderRequestBody> implements ITbOrderRequestBodyService {

}
