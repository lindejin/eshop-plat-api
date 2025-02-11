package com.eshop.service.order.impl;

import com.eshop.entity.order.TbWaybillLock;
import com.eshop.mapper.order.TbWaybillLockMapper;
import com.eshop.service.order.ITbWaybillLockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 包裹运单获取状态 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_order")
@Service
public class TbWaybillLockServiceImpl extends ServiceImpl<TbWaybillLockMapper, TbWaybillLock> implements ITbWaybillLockService {

}
