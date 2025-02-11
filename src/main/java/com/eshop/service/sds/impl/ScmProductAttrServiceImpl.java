package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ScmProductAttr;
import com.eshop.mapper.sds.ScmProductAttrMapper;
import com.eshop.service.sds.IScmProductAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 供应链商品属性 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class ScmProductAttrServiceImpl extends ServiceImpl<ScmProductAttrMapper, ScmProductAttr> implements IScmProductAttrService {

}
