package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderRemarks;
import com.eshop.mapper.order.TbOrderRemarksMapper;
import com.eshop.service.order.ITbOrderRemarksService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单备注信息 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_order")
@Service
public class TbOrderRemarksServiceImpl extends ServiceImpl<TbOrderRemarksMapper, TbOrderRemarks> implements ITbOrderRemarksService {

}
