package com.eshop.service.depot.impl;

import com.eshop.entity.depot.WmsStock;
import com.eshop.mapper.depot.WmsStockMapper;
import com.eshop.service.depot.IWmsStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class WmsStockServiceImpl extends ServiceImpl<WmsStockMapper, WmsStock> implements IWmsStockService {

}
