package com.eshop.service.supply.impl;

import com.eshop.entity.supply.TbRefundDetail;
import com.eshop.mapper.supply.TbRefundDetailMapper;
import com.eshop.service.supply.ITbRefundDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 退货单明细 服务实现类
 * </p>
 *
 * @author supply
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_supply")
@Service
public class TbRefundDetailServiceImpl extends ServiceImpl<TbRefundDetailMapper, TbRefundDetail> implements ITbRefundDetailService {

}
