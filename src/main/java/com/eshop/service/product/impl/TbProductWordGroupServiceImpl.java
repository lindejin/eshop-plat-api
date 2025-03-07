package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductWordGroup;
import com.eshop.mapper.product.TbProductWordGroupMapper;
import com.eshop.service.product.ITbProductWordGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商品关键词组 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_product")
@Service
public class TbProductWordGroupServiceImpl extends ServiceImpl<TbProductWordGroupMapper, TbProductWordGroup> implements ITbProductWordGroupService {

}
