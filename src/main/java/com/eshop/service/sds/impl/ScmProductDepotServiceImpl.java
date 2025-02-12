package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ScmProductDepot;
import com.eshop.mapper.sds.ScmProductDepotMapper;
import com.eshop.service.sds.IScmProductDepotService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 供应链商品所支持仓库 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class ScmProductDepotServiceImpl extends ServiceImpl<ScmProductDepotMapper, ScmProductDepot> implements IScmProductDepotService {

}
