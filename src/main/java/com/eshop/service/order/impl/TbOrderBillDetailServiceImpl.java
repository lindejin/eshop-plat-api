package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderBillDetail;
import com.eshop.mapper.order.TbOrderBillDetailMapper;
import com.eshop.service.order.ITbOrderBillDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单账单明细 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-05-23
 * @since 2025-05-23
 */
@DS("eshop_order")
@Service
public class TbOrderBillDetailServiceImpl extends ServiceImpl<TbOrderBillDetailMapper, TbOrderBillDetail> implements ITbOrderBillDetailService {

}
