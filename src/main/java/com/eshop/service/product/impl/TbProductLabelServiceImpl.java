package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductLabel;
import com.eshop.mapper.product.TbProductLabelMapper;
import com.eshop.service.product.ITbProductLabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品-标签 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_product")
@Service
public class TbProductLabelServiceImpl extends ServiceImpl<TbProductLabelMapper, TbProductLabel> implements ITbProductLabelService {

}
