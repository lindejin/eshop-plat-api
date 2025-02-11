package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbOutboundBill;
import com.eshop.mapper.depot.TbOutboundBillMapper;
import com.eshop.service.depot.ITbOutboundBillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 出库单 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class TbOutboundBillServiceImpl extends ServiceImpl<TbOutboundBillMapper, TbOutboundBill> implements ITbOutboundBillService {

}
