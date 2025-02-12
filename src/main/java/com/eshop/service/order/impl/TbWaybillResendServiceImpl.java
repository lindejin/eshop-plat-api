package com.eshop.service.order.impl;

import com.eshop.entity.order.TbWaybillResend;
import com.eshop.mapper.order.TbWaybillResendMapper;
import com.eshop.service.order.ITbWaybillResendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 包裹重发 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_order")
@Service
public class TbWaybillResendServiceImpl extends ServiceImpl<TbWaybillResendMapper, TbWaybillResend> implements ITbWaybillResendService {

}
