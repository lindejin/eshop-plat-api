package com.eshop.util.platform.api.service.category.dhgate;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;

/**
 * @author ldj
 * @date 2023/7/11 17:00
 * @Description: ...
 * @Version 1.0
 */
public interface DhGateCategoryCall {


    /**
     * 获取类目列表接口
     */
    String getCategoryList(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception;

    /**
     * 获取类目详细信息接口
     */
    String getCategoryDetail(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 获取佣金率列表
     */
    String getCategoriesCommissions(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;
}
