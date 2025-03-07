package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TkTpVideo;
import com.eshop.mapper.sds.TkTpVideoMapper;
import com.eshop.service.sds.ITkTpVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 模版视频列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class TkTpVideoServiceImpl extends ServiceImpl<TkTpVideoMapper, TkTpVideo> implements ITkTpVideoService {

}
