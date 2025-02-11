package com.eshop.util.platform.api.service.media.shopee;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import org.springframework.util.MultiValueMap;

import java.util.Map;

/**
 * @author ldj
 * @date 2023/3/24 14:56
 * @Description: 虾皮视频 调用服务
 * @Version 1.0
 */
public interface ShopeeVideoCall {

    /**
     * 虾皮 开启一个视频上传会话。 视频时长应在 10 秒到 60 秒（含）之间。
     * 初始化上传任务
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String initVideoUpload(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 虾皮 分片上传
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String uploadVideoPart(ShopeeAppClientDTO publicDto, MultiValueMap<String, Object> businessDto) throws Exception;

    /**
     * 虾皮 分片合成
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String completeVideoUpload(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 虾皮 获取视频上传结果
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getVideoUploadResult(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception;
}
