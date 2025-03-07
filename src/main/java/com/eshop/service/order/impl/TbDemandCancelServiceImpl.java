package com.eshop.service.order.impl;

import com.eshop.entity.order.TbDemandCancel;
import com.eshop.mapper.order.TbDemandCancelMapper;
import com.eshop.service.order.ITbDemandCancelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * sku取消需求记录 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_order")
@Service
public class TbDemandCancelServiceImpl extends ServiceImpl<TbDemandCancelMapper, TbDemandCancel> implements ITbDemandCancelService {

}
