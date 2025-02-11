package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeTpProductAttr;
import com.eshop.mapper.sds.AeTpProductAttrMapper;
import com.eshop.service.sds.IAeTpProductAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商品属性信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class AeTpProductAttrServiceImpl extends ServiceImpl<AeTpProductAttrMapper, AeTpProductAttr> implements IAeTpProductAttrService {

}
