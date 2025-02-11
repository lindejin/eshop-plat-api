package com.eshop.service.order.impl;

import com.eshop.entity.order.TbWaybill;
import com.eshop.mapper.order.TbWaybillMapper;
import com.eshop.service.order.ITbWaybillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 运单表 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_order")
@Service
public class TbWaybillServiceImpl extends ServiceImpl<TbWaybillMapper, TbWaybill> implements ITbWaybillService {

}
