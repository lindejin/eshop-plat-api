package com.eshop.service.order.impl;

import com.eshop.entity.order.TbWaybillSynErr;
import com.eshop.mapper.order.TbWaybillSynErrMapper;
import com.eshop.service.order.ITbWaybillSynErrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单_运单同步表 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_order")
@Service
public class TbWaybillSynErrServiceImpl extends ServiceImpl<TbWaybillSynErrMapper, TbWaybillSynErr> implements ITbWaybillSynErrService {

}
