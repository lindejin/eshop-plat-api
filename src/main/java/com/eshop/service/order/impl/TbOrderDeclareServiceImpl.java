package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderDeclare;
import com.eshop.mapper.order.TbOrderDeclareMapper;
import com.eshop.service.order.ITbOrderDeclareService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单申报信息 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_order")
@Service
public class TbOrderDeclareServiceImpl extends ServiceImpl<TbOrderDeclareMapper, TbOrderDeclare> implements ITbOrderDeclareService {

}
