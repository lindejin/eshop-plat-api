package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderInvoiceDetail;
import com.eshop.mapper.order.TbOrderInvoiceDetailMapper;
import com.eshop.service.order.ITbOrderInvoiceDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 发票明细 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_order")
@Service
public class TbOrderInvoiceDetailServiceImpl extends ServiceImpl<TbOrderInvoiceDetailMapper, TbOrderInvoiceDetail> implements ITbOrderInvoiceDetailService {

}
