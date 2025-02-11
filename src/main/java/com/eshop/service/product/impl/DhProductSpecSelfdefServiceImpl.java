package com.eshop.service.product.impl;

import com.eshop.entity.product.DhProductSpecSelfdef;
import com.eshop.mapper.product.DhProductSpecSelfdefMapper;
import com.eshop.service.product.IDhProductSpecSelfdefService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 自定义规格列表 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_product")
@Service
public class DhProductSpecSelfdefServiceImpl extends ServiceImpl<DhProductSpecSelfdefMapper, DhProductSpecSelfdef> implements IDhProductSpecSelfdefService {

}
