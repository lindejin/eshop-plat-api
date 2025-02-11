package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuProductAttrVal;
import com.eshop.mapper.sds.TemuProductAttrValMapper;
import com.eshop.service.sds.ITemuProductAttrValService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * Temu产品属性值 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TemuProductAttrValServiceImpl extends ServiceImpl<TemuProductAttrValMapper, TemuProductAttrVal> implements ITemuProductAttrValService {

}
