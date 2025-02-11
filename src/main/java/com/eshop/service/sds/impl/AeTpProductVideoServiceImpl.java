package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeTpProductVideo;
import com.eshop.mapper.sds.AeTpProductVideoMapper;
import com.eshop.service.sds.IAeTpProductVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 速卖通商品多媒体 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class AeTpProductVideoServiceImpl extends ServiceImpl<AeTpProductVideoMapper, AeTpProductVideo> implements IAeTpProductVideoService {

}
