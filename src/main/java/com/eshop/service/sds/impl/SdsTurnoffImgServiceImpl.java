package com.eshop.service.sds.impl;

import com.eshop.entity.sds.SdsTurnoffImg;
import com.eshop.mapper.sds.SdsTurnoffImgMapper;
import com.eshop.service.sds.ISdsTurnoffImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * sds-成品图片信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class SdsTurnoffImgServiceImpl extends ServiceImpl<SdsTurnoffImgMapper, SdsTurnoffImg> implements ISdsTurnoffImgService {

}
