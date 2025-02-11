package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ScmProductAttrVal;
import com.eshop.mapper.sds.ScmProductAttrValMapper;
import com.eshop.service.sds.IScmProductAttrValService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 供应链商品属性值 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class ScmProductAttrValServiceImpl extends ServiceImpl<ScmProductAttrValMapper, ScmProductAttrVal> implements IScmProductAttrValService {

}
