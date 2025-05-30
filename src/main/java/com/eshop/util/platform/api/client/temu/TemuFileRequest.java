package com.eshop.util.platform.api.client.temu;

import com.alibaba.fastjson.JSONObject;

import java.io.InputStream;

@lombok.extern.slf4j.Slf4j
@lombok.Getter
@lombok.Setter
public class TemuFileRequest {

    /**
     * 文件上传
     */
    private byte[] byteFile;

    /**
     * 文件参数
     */
    private String fileParam;

    /**
     * 文件名称
     */
    private String fileName;


    /**
     * 请求地址
     */
    private String url;

    /**
     * 请求参数
     */
    private JSONObject jsonParams;
}
