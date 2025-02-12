package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ProductKeyword;
import com.eshop.mapper.sds.ProductKeywordMapper;
import com.eshop.service.sds.IProductKeywordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 关键词 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class ProductKeywordServiceImpl extends ServiceImpl<ProductKeywordMapper, ProductKeyword> implements IProductKeywordService {

}
