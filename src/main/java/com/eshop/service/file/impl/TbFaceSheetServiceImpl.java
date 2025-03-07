package com.eshop.service.file.impl;

import com.eshop.entity.file.TbFaceSheet;
import com.eshop.mapper.file.TbFaceSheetMapper;
import com.eshop.service.file.ITbFaceSheetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 面单信息 服务实现类
 * </p>
 *
 * @author file
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_file")
@Service
public class TbFaceSheetServiceImpl extends ServiceImpl<TbFaceSheetMapper, TbFaceSheet> implements ITbFaceSheetService {

}
