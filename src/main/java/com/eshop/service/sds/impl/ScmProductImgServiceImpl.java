package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ScmProductImg;
import com.eshop.mapper.sds.ScmProductImgMapper;
import com.eshop.service.sds.IScmProductImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 供应链商品图 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class ScmProductImgServiceImpl extends ServiceImpl<ScmProductImgMapper, ScmProductImg> implements IScmProductImgService {

}
