package com.eshop.service.product.impl;

import com.eshop.entity.product.DhProductImg;
import com.eshop.mapper.product.DhProductImgMapper;
import com.eshop.service.product.IDhProductImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品图片列表 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_product")
@Service
public class DhProductImgServiceImpl extends ServiceImpl<DhProductImgMapper, DhProductImg> implements IDhProductImgService {

}
