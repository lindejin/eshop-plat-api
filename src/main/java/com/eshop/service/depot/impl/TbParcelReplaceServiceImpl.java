package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbParcelReplace;
import com.eshop.mapper.depot.TbParcelReplaceMapper;
import com.eshop.service.depot.ITbParcelReplaceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 包裹变更信息 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_depot")
@Service
public class TbParcelReplaceServiceImpl extends ServiceImpl<TbParcelReplaceMapper, TbParcelReplace> implements ITbParcelReplaceService {

}
