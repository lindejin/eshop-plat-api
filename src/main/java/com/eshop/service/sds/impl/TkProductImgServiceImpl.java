package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TkProductImg;
import com.eshop.mapper.sds.TkProductImgMapper;
import com.eshop.service.sds.ITkProductImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * TK产品图片列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class TkProductImgServiceImpl extends ServiceImpl<TkProductImgMapper, TkProductImg> implements ITkProductImgService {

}
