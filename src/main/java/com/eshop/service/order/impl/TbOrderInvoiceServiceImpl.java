package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderInvoice;
import com.eshop.mapper.order.TbOrderInvoiceMapper;
import com.eshop.service.order.ITbOrderInvoiceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单发票 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_order")
@Service
public class TbOrderInvoiceServiceImpl extends ServiceImpl<TbOrderInvoiceMapper, TbOrderInvoice> implements ITbOrderInvoiceService {

}
