package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeProductAttr;
import com.eshop.mapper.sds.AeProductAttrMapper;
import com.eshop.service.sds.IAeProductAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商品属性信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class AeProductAttrServiceImpl extends ServiceImpl<AeProductAttrMapper, AeProductAttr> implements IAeProductAttrService {

}
