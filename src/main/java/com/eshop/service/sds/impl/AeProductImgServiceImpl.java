package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeProductImg;
import com.eshop.mapper.sds.AeProductImgMapper;
import com.eshop.service.sds.IAeProductImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 速卖通产品的主图URL列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class AeProductImgServiceImpl extends ServiceImpl<AeProductImgMapper, AeProductImg> implements IAeProductImgService {

}
