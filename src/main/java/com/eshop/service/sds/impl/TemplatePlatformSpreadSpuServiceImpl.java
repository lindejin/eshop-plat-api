package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemplatePlatformSpreadSpu;
import com.eshop.mapper.sds.TemplatePlatformSpreadSpuMapper;
import com.eshop.service.sds.ITemplatePlatformSpreadSpuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 模板-铺货拓展信息-样机合并认领spu信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TemplatePlatformSpreadSpuServiceImpl extends ServiceImpl<TemplatePlatformSpreadSpuMapper, TemplatePlatformSpreadSpu> implements ITemplatePlatformSpreadSpuService {

}
