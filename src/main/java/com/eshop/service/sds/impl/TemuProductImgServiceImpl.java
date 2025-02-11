package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuProductImg;
import com.eshop.mapper.sds.TemuProductImgMapper;
import com.eshop.service.sds.ITemuProductImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * Temu产品图片列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TemuProductImgServiceImpl extends ServiceImpl<TemuProductImgMapper, TemuProductImg> implements ITemuProductImgService {

}
