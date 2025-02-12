package com.eshop.service.file.impl;

import com.eshop.entity.file.TbFile;
import com.eshop.mapper.file.TbFileMapper;
import com.eshop.service.file.ITbFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 文件 服务实现类
 * </p>
 *
 * @author file
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_file")
@Service
public class TbFileServiceImpl extends ServiceImpl<TbFileMapper, TbFile> implements ITbFileService {

}
