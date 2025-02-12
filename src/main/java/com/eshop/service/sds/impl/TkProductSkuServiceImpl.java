package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TkProductSku;
import com.eshop.mapper.sds.TkProductSkuMapper;
import com.eshop.service.sds.ITkProductSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * TK产品SKU列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TkProductSkuServiceImpl extends ServiceImpl<TkProductSkuMapper, TkProductSku> implements ITkProductSkuService {

}
