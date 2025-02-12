package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuProductAttr;
import com.eshop.mapper.sds.TemuProductAttrMapper;
import com.eshop.service.sds.ITemuProductAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * temu产品属性列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TemuProductAttrServiceImpl extends ServiceImpl<TemuProductAttrMapper, TemuProductAttr> implements ITemuProductAttrService {

}
