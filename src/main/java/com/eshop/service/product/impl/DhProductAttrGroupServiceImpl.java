package com.eshop.service.product.impl;

import com.eshop.entity.product.DhProductAttrGroup;
import com.eshop.mapper.product.DhProductAttrGroupMapper;
import com.eshop.service.product.IDhProductAttrGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 兼容属性列表 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class DhProductAttrGroupServiceImpl extends ServiceImpl<DhProductAttrGroupMapper, DhProductAttrGroup> implements IDhProductAttrGroupService {

}
