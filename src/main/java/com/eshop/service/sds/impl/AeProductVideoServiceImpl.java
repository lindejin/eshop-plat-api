package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeProductVideo;
import com.eshop.mapper.sds.AeProductVideoMapper;
import com.eshop.service.sds.IAeProductVideoService;
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
public class AeProductVideoServiceImpl extends ServiceImpl<AeProductVideoMapper, AeProductVideo> implements IAeProductVideoService {

}
