package com.eshop.douyin.print;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Content {
    private String params;
    private String signature;
    private String encryptedData;
    private String templateURL;

    private AddData addData;
    private Config config;

    // 自定义区模板相关字段
    private Map<String, String> data;
}
