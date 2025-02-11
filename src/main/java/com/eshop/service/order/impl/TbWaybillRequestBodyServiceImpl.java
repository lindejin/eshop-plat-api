package com.eshop.service.order.impl;

import com.eshop.entity.order.TbWaybillRequestBody;
import com.eshop.mapper.order.TbWaybillRequestBodyMapper;
import com.eshop.service.order.ITbWaybillRequestBodyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单请求数据存储 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_order")
@Service
public class TbWaybillRequestBodyServiceImpl extends ServiceImpl<TbWaybillRequestBodyMapper, TbWaybillRequestBody> implements ITbWaybillRequestBodyService {

}
