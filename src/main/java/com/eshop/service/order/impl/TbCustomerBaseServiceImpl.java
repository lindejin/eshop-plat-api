package com.eshop.service.order.impl;

import com.eshop.entity.order.TbCustomerBase;
import com.eshop.mapper.order.TbCustomerBaseMapper;
import com.eshop.service.order.ITbCustomerBaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 客户基础信息 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_order")
@Service
public class TbCustomerBaseServiceImpl extends ServiceImpl<TbCustomerBaseMapper, TbCustomerBase> implements ITbCustomerBaseService {

}
