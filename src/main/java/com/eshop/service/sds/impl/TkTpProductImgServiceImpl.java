package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TkTpProductImg;
import com.eshop.mapper.sds.TkTpProductImgMapper;
import com.eshop.service.sds.ITkTpProductImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * TK产品图片列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TkTpProductImgServiceImpl extends ServiceImpl<TkTpProductImgMapper, TkTpProductImg> implements ITkTpProductImgService {

}
