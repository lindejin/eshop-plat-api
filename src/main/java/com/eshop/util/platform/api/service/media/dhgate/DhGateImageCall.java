package com.eshop.util.platform.api.service.media.dhgate;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;

/**
 * @author ldj
 * @date 2023/7/8 16:06
 * @Description: ...
 * @Version 1.0
 */
public interface DhGateImageCall {

    /**
     * 敦煌 图片上传
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String imgUpload(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;
}
