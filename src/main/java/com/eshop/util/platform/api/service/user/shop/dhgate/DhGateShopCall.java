package com.eshop.util.platform.api.service.user.shop.dhgate;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;

/**
 * @author ldj
 * @date 2023/6/26 9:45
 * @Description: ...
 * @Version 1.0
 */
public interface DhGateShopCall {

    /**
     * 查询账号基本信息接口
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getUserBase(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;
}
