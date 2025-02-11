package com.eshop.service.order.impl;

import com.eshop.entity.order.TbWaybillShipmentErr;
import com.eshop.mapper.order.TbWaybillShipmentErrMapper;
import com.eshop.service.order.ITbWaybillShipmentErrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 运单号获取异常 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_order")
@Service
public class TbWaybillShipmentErrServiceImpl extends ServiceImpl<TbWaybillShipmentErrMapper, TbWaybillShipmentErr> implements ITbWaybillShipmentErrService {

}
