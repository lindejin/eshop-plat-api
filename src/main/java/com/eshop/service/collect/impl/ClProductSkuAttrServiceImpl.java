package com.eshop.service.collect.impl;

import com.eshop.entity.collect.ClProductSkuAttr;
import com.eshop.mapper.collect.ClProductSkuAttrMapper;
import com.eshop.service.collect.IClProductSkuAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 采集sku属性信息 服务实现类
 * </p>
 *
 * @author collect
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_collect")
@Service
public class ClProductSkuAttrServiceImpl extends ServiceImpl<ClProductSkuAttrMapper, ClProductSkuAttr> implements IClProductSkuAttrService {

}
