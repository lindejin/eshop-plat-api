package com.eshop.service.ai.impl;

import com.eshop.entity.ai.SdComposeImg;
import com.eshop.mapper.ai.SdComposeImgMapper;
import com.eshop.service.ai.ISdComposeImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * ai  sd局部修改生成图片信息表 服务实现类
 * </p>
 *
 * @author ai
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_ai")
@Service
public class SdComposeImgServiceImpl extends ServiceImpl<SdComposeImgMapper, SdComposeImg> implements ISdComposeImgService {

}
