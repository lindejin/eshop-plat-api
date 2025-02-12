package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbDepotAuth;
import com.eshop.mapper.depot.TbDepotAuthMapper;
import com.eshop.service.depot.ITbDepotAuthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 仓库权限 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_depot")
@Service
public class TbDepotAuthServiceImpl extends ServiceImpl<TbDepotAuthMapper, TbDepotAuth> implements ITbDepotAuthService {

}
