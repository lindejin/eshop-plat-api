package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TkProductSkuAttr;
import com.eshop.mapper.sds.TkProductSkuAttrMapper;
import com.eshop.service.sds.ITkProductSkuAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * TK产品SKU属性列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TkProductSkuAttrServiceImpl extends ServiceImpl<TkProductSkuAttrMapper, TkProductSkuAttr> implements ITkProductSkuAttrService {

}
