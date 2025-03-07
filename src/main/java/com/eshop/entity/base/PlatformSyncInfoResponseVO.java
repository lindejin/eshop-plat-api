package com.eshop.entity.base;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;


@Data
@Slf4j
public class PlatformSyncInfoResponseVO<T> {

    /**
     * 返回的json数据
     */
    private JSONObject jsonObj;

    /**
     * 第三方平台返回的列表数据
     */
    private T info;
}
