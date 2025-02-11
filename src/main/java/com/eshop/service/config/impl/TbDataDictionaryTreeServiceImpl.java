package com.eshop.service.config.impl;

import com.eshop.entity.config.TbDataDictionaryTree;
import com.eshop.mapper.config.TbDataDictionaryTreeMapper;
import com.eshop.service.config.ITbDataDictionaryTreeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 数据词典树 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_config")
@Service
public class TbDataDictionaryTreeServiceImpl extends ServiceImpl<TbDataDictionaryTreeMapper, TbDataDictionaryTree> implements ITbDataDictionaryTreeService {

}
