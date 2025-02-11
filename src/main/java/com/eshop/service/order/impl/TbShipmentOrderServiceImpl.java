package com.eshop.service.order.impl;

import com.eshop.entity.order.TbShipmentOrder;
import com.eshop.mapper.order.TbShipmentOrderMapper;
import com.eshop.service.order.ITbShipmentOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 发货单列表（箱唛） 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_order")
@Service
public class TbShipmentOrderServiceImpl extends ServiceImpl<TbShipmentOrderMapper, TbShipmentOrder> implements ITbShipmentOrderService {

}
