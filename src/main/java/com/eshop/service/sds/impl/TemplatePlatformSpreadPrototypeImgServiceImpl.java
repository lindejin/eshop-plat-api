package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemplatePlatformSpreadPrototypeImg;
import com.eshop.mapper.sds.TemplatePlatformSpreadPrototypeImgMapper;
import com.eshop.service.sds.ITemplatePlatformSpreadPrototypeImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 模板-铺货拓展信息-模特图片信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TemplatePlatformSpreadPrototypeImgServiceImpl extends ServiceImpl<TemplatePlatformSpreadPrototypeImgMapper, TemplatePlatformSpreadPrototypeImg> implements ITemplatePlatformSpreadPrototypeImgService {

}
