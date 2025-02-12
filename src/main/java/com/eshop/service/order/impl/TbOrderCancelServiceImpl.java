package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderCancel;
import com.eshop.mapper.order.TbOrderCancelMapper;
import com.eshop.service.order.ITbOrderCancelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 平台订单取消信息 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_order")
@Service
public class TbOrderCancelServiceImpl extends ServiceImpl<TbOrderCancelMapper, TbOrderCancel> implements ITbOrderCancelService {

}
