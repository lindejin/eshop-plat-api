package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbStockDailys;
import com.eshop.mapper.depot.TbStockDailysMapper;
import com.eshop.service.depot.ITbStockDailysService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 每日SKU入库统计 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_depot")
@Service
public class TbStockDailysServiceImpl extends ServiceImpl<TbStockDailysMapper, TbStockDailys> implements ITbStockDailysService {

}
