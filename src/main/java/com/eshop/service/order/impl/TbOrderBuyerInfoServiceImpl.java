package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderBuyerInfo;
import com.eshop.mapper.order.TbOrderBuyerInfoMapper;
import com.eshop.service.order.ITbOrderBuyerInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单买家信息 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_order")
@Service
public class TbOrderBuyerInfoServiceImpl extends ServiceImpl<TbOrderBuyerInfoMapper, TbOrderBuyerInfo> implements ITbOrderBuyerInfoService {

}
