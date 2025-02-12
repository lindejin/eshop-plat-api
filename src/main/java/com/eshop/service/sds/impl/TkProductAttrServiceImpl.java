package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TkProductAttr;
import com.eshop.mapper.sds.TkProductAttrMapper;
import com.eshop.service.sds.ITkProductAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * TK产品属性列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TkProductAttrServiceImpl extends ServiceImpl<TkProductAttrMapper, TkProductAttr> implements ITkProductAttrService {

}
