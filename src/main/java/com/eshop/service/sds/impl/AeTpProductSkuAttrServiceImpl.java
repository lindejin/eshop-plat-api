package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeTpProductSkuAttr;
import com.eshop.mapper.sds.AeTpProductSkuAttrMapper;
import com.eshop.service.sds.IAeTpProductSkuAttrService;
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
public class AeTpProductSkuAttrServiceImpl extends ServiceImpl<AeTpProductSkuAttrMapper, AeTpProductSkuAttr> implements IAeTpProductSkuAttrService {

}
