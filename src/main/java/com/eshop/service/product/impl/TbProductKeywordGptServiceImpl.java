package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductKeywordGpt;
import com.eshop.mapper.product.TbProductKeywordGptMapper;
import com.eshop.service.product.ITbProductKeywordGptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 关键词_gpt 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class TbProductKeywordGptServiceImpl extends ServiceImpl<TbProductKeywordGptMapper, TbProductKeywordGpt> implements ITbProductKeywordGptService {

}
