package com.eshop.service.collect.impl;

import com.eshop.entity.collect.ClProductAttr;
import com.eshop.mapper.collect.ClProductAttrMapper;
import com.eshop.service.collect.IClProductAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 采集商品属性信息 服务实现类
 * </p>
 *
 * @author collect
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_collect")
@Service
public class ClProductAttrServiceImpl extends ServiceImpl<ClProductAttrMapper, ClProductAttr> implements IClProductAttrService {

}
