package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/2 16:34
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopQualificationStructDTO {
    //key	String	否	资质信息key, 每个类目下的key都不一样，请先调用资质信息查询接口：aliexpress.category.qualifications.list，查询对应的key和type
    private String key;
    //type	String	否	资质信息类型 ："image","text"
    private String type;
    //value	String	否	具体的资质信息：图片链接或文本。图片格式只允许jpg、png、jpeg这3种格式
    private String value;
}
