package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TkProductAttrVal;
import com.eshop.mapper.sds.TkProductAttrValMapper;
import com.eshop.service.sds.ITkProductAttrValService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * TK产品属性值 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TkProductAttrValServiceImpl extends ServiceImpl<TkProductAttrValMapper, TkProductAttrVal> implements ITkProductAttrValService {

}
