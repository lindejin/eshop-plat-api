package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbClip;
import com.eshop.mapper.sds.TbClipMapper;
import com.eshop.service.sds.ITbClipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 定位 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TbClipServiceImpl extends ServiceImpl<TbClipMapper, TbClip> implements ITbClipService {

}
