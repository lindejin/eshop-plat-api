package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbBackgroundClassify;
import com.eshop.mapper.sds.TbBackgroundClassifyMapper;
import com.eshop.service.sds.ITbBackgroundClassifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 背景分类 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TbBackgroundClassifyServiceImpl extends ServiceImpl<TbBackgroundClassifyMapper, TbBackgroundClassify> implements ITbBackgroundClassifyService {

}
