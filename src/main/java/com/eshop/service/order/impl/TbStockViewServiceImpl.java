package com.eshop.service.order.impl;

import com.eshop.entity.order.TbStockView;
import com.eshop.mapper.order.TbStockViewMapper;
import com.eshop.service.order.ITbStockViewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_order")
@Service
public class TbStockViewServiceImpl extends ServiceImpl<TbStockViewMapper, TbStockView> implements ITbStockViewService {

}
