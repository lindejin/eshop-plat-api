package com.eshop.service.order.impl;

import com.eshop.entity.order.TbWaybillShipmentErrDetail;
import com.eshop.mapper.order.TbWaybillShipmentErrDetailMapper;
import com.eshop.service.order.ITbWaybillShipmentErrDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 运单号获取异常 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_order")
@Service
public class TbWaybillShipmentErrDetailServiceImpl extends ServiceImpl<TbWaybillShipmentErrDetailMapper, TbWaybillShipmentErrDetail> implements ITbWaybillShipmentErrDetailService {

}
