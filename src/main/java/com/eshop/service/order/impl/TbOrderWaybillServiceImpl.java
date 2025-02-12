package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderWaybill;
import com.eshop.mapper.order.TbOrderWaybillMapper;
import com.eshop.service.order.ITbOrderWaybillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单_运单(中间表) 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_order")
@Service
public class TbOrderWaybillServiceImpl extends ServiceImpl<TbOrderWaybillMapper, TbOrderWaybill> implements ITbOrderWaybillService {

}
