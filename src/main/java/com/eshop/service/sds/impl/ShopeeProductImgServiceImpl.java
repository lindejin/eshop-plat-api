package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ShopeeProductImg;
import com.eshop.mapper.sds.ShopeeProductImgMapper;
import com.eshop.service.sds.IShopeeProductImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 虾皮产品图片列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class ShopeeProductImgServiceImpl extends ServiceImpl<ShopeeProductImgMapper, ShopeeProductImg> implements IShopeeProductImgService {

}
