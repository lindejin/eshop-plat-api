package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbStockDetail;
import com.eshop.mapper.depot.TbStockDetailMapper;
import com.eshop.service.depot.ITbStockDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 库存明细 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_depot")
@Service
public class TbStockDetailServiceImpl extends ServiceImpl<TbStockDetailMapper, TbStockDetail> implements ITbStockDetailService {

}
