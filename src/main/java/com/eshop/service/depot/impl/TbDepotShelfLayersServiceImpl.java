package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbDepotShelfLayers;
import com.eshop.mapper.depot.TbDepotShelfLayersMapper;
import com.eshop.service.depot.ITbDepotShelfLayersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 仓库货架层 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class TbDepotShelfLayersServiceImpl extends ServiceImpl<TbDepotShelfLayersMapper, TbDepotShelfLayers> implements ITbDepotShelfLayersService {

}
