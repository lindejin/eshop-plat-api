package com.eshop.service.order.impl;

import com.eshop.entity.order.TbWaybillResendVoucher;
import com.eshop.mapper.order.TbWaybillResendVoucherMapper;
import com.eshop.service.order.ITbWaybillResendVoucherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 包裹重发凭证 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_order")
@Service
public class TbWaybillResendVoucherServiceImpl extends ServiceImpl<TbWaybillResendVoucherMapper, TbWaybillResendVoucher> implements ITbWaybillResendVoucherService {

}
