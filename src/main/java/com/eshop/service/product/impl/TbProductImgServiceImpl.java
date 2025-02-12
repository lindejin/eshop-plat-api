package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductImg;
import com.eshop.mapper.product.TbProductImgMapper;
import com.eshop.service.product.ITbProductImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品图片信息 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class TbProductImgServiceImpl extends ServiceImpl<TbProductImgMapper, TbProductImg> implements ITbProductImgService {

}
