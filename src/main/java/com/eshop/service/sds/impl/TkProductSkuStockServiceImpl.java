package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TkProductSkuStock;
import com.eshop.mapper.sds.TkProductSkuStockMapper;
import com.eshop.service.sds.ITkProductSkuStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * TK产品SKU仓库库存信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class TkProductSkuStockServiceImpl extends ServiceImpl<TkProductSkuStockMapper, TkProductSkuStock> implements ITkProductSkuStockService {

}
