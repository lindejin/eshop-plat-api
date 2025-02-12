package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeTpProductImg;
import com.eshop.mapper.sds.AeTpProductImgMapper;
import com.eshop.service.sds.IAeTpProductImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 速卖通产品的主图URL列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class AeTpProductImgServiceImpl extends ServiceImpl<AeTpProductImgMapper, AeTpProductImg> implements IAeTpProductImgService {

}
