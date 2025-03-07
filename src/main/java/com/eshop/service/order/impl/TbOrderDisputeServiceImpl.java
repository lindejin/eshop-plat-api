package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderDispute;
import com.eshop.mapper.order.TbOrderDisputeMapper;
import com.eshop.service.order.ITbOrderDisputeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 纠纷订单 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_order")
@Service
public class TbOrderDisputeServiceImpl extends ServiceImpl<TbOrderDisputeMapper, TbOrderDispute> implements ITbOrderDisputeService {

}
