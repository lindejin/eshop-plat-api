package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbPrototypeImg;
import com.eshop.mapper.sds.TbPrototypeImgMapper;
import com.eshop.service.sds.ITbPrototypeImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 成品图片 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class TbPrototypeImgServiceImpl extends ServiceImpl<TbPrototypeImgMapper, TbPrototypeImg> implements ITbPrototypeImgService {

}
