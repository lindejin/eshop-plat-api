package com.eshop.service.order.impl;

import com.eshop.entity.order.TbShipmentTask;
import com.eshop.mapper.order.TbShipmentTaskMapper;
import com.eshop.service.order.ITbShipmentTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 发货单批次列表 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_order")
@Service
public class TbShipmentTaskServiceImpl extends ServiceImpl<TbShipmentTaskMapper, TbShipmentTask> implements ITbShipmentTaskService {

}
