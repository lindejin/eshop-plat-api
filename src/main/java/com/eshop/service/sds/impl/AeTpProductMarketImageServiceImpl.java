package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeTpProductMarketImage;
import com.eshop.mapper.sds.AeTpProductMarketImageMapper;
import com.eshop.service.sds.IAeTpProductMarketImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 速卖通商品营销图 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class AeTpProductMarketImageServiceImpl extends ServiceImpl<AeTpProductMarketImageMapper, AeTpProductMarketImage> implements IAeTpProductMarketImageService {

}
