package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductProcessImg;
import com.eshop.mapper.product.TbProductProcessImgMapper;
import com.eshop.service.product.ITbProductProcessImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 加工多面图 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_product")
@Service
public class TbProductProcessImgServiceImpl extends ServiceImpl<TbProductProcessImgMapper, TbProductProcessImg> implements ITbProductProcessImgService {

}
