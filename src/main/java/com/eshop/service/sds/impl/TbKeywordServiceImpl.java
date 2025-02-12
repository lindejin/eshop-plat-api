package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbKeyword;
import com.eshop.mapper.sds.TbKeywordMapper;
import com.eshop.service.sds.ITbKeywordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 关键词 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TbKeywordServiceImpl extends ServiceImpl<TbKeywordMapper, TbKeyword> implements ITbKeywordService {

}
