package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbDiyWaitComposeMaterial;
import com.eshop.mapper.depot.TbDiyWaitComposeMaterialMapper;
import com.eshop.service.depot.ITbDiyWaitComposeMaterialService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * diy商品待合成列表每个item 需要的图案列表 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_depot")
@Service
public class TbDiyWaitComposeMaterialServiceImpl extends ServiceImpl<TbDiyWaitComposeMaterialMapper, TbDiyWaitComposeMaterial> implements ITbDiyWaitComposeMaterialService {

}
