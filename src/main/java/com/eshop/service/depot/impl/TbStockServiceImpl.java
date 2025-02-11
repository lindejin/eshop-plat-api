package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbStock;
import com.eshop.mapper.depot.TbStockMapper;
import com.eshop.service.depot.ITbStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 库存 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class TbStockServiceImpl extends ServiceImpl<TbStockMapper, TbStock> implements ITbStockService {

}
