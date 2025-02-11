package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbDepotAreas;
import com.eshop.mapper.depot.TbDepotAreasMapper;
import com.eshop.service.depot.ITbDepotAreasService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 仓库区域 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class TbDepotAreasServiceImpl extends ServiceImpl<TbDepotAreasMapper, TbDepotAreas> implements ITbDepotAreasService {

}
