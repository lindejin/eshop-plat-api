package com.eshop.service.sds.impl;

import com.eshop.entity.sds.DhTpProductAttrVal;
import com.eshop.mapper.sds.DhTpProductAttrValMapper;
import com.eshop.service.sds.IDhTpProductAttrValService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品属性值 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class DhTpProductAttrValServiceImpl extends ServiceImpl<DhTpProductAttrValMapper, DhTpProductAttrVal> implements IDhTpProductAttrValService {

}
