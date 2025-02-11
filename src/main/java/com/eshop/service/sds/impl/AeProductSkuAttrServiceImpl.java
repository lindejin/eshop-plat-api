package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeProductSkuAttr;
import com.eshop.mapper.sds.AeProductSkuAttrMapper;
import com.eshop.service.sds.IAeProductSkuAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 速卖通产品sku属性列表  服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class AeProductSkuAttrServiceImpl extends ServiceImpl<AeProductSkuAttrMapper, AeProductSkuAttr> implements IAeProductSkuAttrService {

}
