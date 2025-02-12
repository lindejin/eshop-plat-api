package com.eshop.service.sds.impl;

import com.eshop.entity.sds.DhTpProductAttr;
import com.eshop.mapper.sds.DhTpProductAttrMapper;
import com.eshop.service.sds.IDhTpProductAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品属性列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class DhTpProductAttrServiceImpl extends ServiceImpl<DhTpProductAttrMapper, DhTpProductAttr> implements IDhTpProductAttrService {

}
