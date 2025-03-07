package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductKeywordGroup;
import com.eshop.mapper.product.TbProductKeywordGroupMapper;
import com.eshop.service.product.ITbProductKeywordGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 关键词组 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_product")
@Service
public class TbProductKeywordGroupServiceImpl extends ServiceImpl<TbProductKeywordGroupMapper, TbProductKeywordGroup> implements ITbProductKeywordGroupService {

}
