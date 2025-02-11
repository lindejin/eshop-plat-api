package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductKeyword;
import com.eshop.mapper.product.TbProductKeywordMapper;
import com.eshop.service.product.ITbProductKeywordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 关键词 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_product")
@Service
public class TbProductKeywordServiceImpl extends ServiceImpl<TbProductKeywordMapper, TbProductKeyword> implements ITbProductKeywordService {

}
