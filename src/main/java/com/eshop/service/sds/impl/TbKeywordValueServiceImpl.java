package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbKeywordValue;
import com.eshop.mapper.sds.TbKeywordValueMapper;
import com.eshop.service.sds.ITbKeywordValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 关键词值 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TbKeywordValueServiceImpl extends ServiceImpl<TbKeywordValueMapper, TbKeywordValue> implements ITbKeywordValueService {

}
