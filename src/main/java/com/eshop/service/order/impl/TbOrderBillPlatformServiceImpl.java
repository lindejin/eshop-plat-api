package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderBillPlatform;
import com.eshop.mapper.order.TbOrderBillPlatformMapper;
import com.eshop.service.order.ITbOrderBillPlatformService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 平台订单费用明细 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-05-23
 * @since 2025-05-23
 */
@DS("eshop_order")
@Service
public class TbOrderBillPlatformServiceImpl extends ServiceImpl<TbOrderBillPlatformMapper, TbOrderBillPlatform> implements ITbOrderBillPlatformService {

}
