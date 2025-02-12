package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbMergeProductView;
import com.eshop.mapper.sds.TbMergeProductViewMapper;
import com.eshop.service.sds.ITbMergeProductViewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TbMergeProductViewServiceImpl extends ServiceImpl<TbMergeProductViewMapper, TbMergeProductView> implements ITbMergeProductViewService {

}
