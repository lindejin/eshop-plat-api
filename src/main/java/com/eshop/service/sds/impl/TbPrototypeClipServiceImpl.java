package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbPrototypeClip;
import com.eshop.mapper.sds.TbPrototypeClipMapper;
import com.eshop.service.sds.ITbPrototypeClipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 样机定位组 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TbPrototypeClipServiceImpl extends ServiceImpl<TbPrototypeClipMapper, TbPrototypeClip> implements ITbPrototypeClipService {

}
