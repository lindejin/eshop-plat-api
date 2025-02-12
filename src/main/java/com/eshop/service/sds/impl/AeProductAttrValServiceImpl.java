package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeProductAttrVal;
import com.eshop.mapper.sds.AeProductAttrValMapper;
import com.eshop.service.sds.IAeProductAttrValService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商品属性值 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class AeProductAttrValServiceImpl extends ServiceImpl<AeProductAttrValMapper, AeProductAttrVal> implements IAeProductAttrValService {

}
