package com.eshop.service.collect.impl;

import com.eshop.entity.collect.ClProductImg;
import com.eshop.mapper.collect.ClProductImgMapper;
import com.eshop.service.collect.IClProductImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 采集产品图片信息 服务实现类
 * </p>
 *
 * @author collect
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_collect")
@Service
public class ClProductImgServiceImpl extends ServiceImpl<ClProductImgMapper, ClProductImg> implements IClProductImgService {

}
