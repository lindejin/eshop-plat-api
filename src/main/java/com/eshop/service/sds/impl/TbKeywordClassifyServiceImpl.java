package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbKeywordClassify;
import com.eshop.mapper.sds.TbKeywordClassifyMapper;
import com.eshop.service.sds.ITbKeywordClassifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 关键词分类 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TbKeywordClassifyServiceImpl extends ServiceImpl<TbKeywordClassifyMapper, TbKeywordClassify> implements ITbKeywordClassifyService {

}
