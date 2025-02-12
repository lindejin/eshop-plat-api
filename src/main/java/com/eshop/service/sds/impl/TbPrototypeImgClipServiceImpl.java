package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbPrototypeImgClip;
import com.eshop.mapper.sds.TbPrototypeImgClipMapper;
import com.eshop.service.sds.ITbPrototypeImgClipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 样机图片定位 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TbPrototypeImgClipServiceImpl extends ServiceImpl<TbPrototypeImgClipMapper, TbPrototypeImgClip> implements ITbPrototypeImgClipService {

}
