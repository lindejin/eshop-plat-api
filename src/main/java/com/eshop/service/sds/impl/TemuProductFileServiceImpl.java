package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuProductFile;
import com.eshop.mapper.sds.TemuProductFileMapper;
import com.eshop.service.sds.ITemuProductFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * Temu产品文件相关信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TemuProductFileServiceImpl extends ServiceImpl<TemuProductFileMapper, TemuProductFile> implements ITemuProductFileService {

}
