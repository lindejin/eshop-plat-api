package com.eshop.service.depot.impl;

import com.eshop.entity.depot.AmsPurchaseOrder;
import com.eshop.mapper.depot.AmsPurchaseOrderMapper;
import com.eshop.service.depot.IAmsPurchaseOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * AMS采购单 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class AmsPurchaseOrderServiceImpl extends ServiceImpl<AmsPurchaseOrderMapper, AmsPurchaseOrder> implements IAmsPurchaseOrderService {

}
