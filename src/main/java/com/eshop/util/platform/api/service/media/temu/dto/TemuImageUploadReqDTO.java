package com.eshop.util.platform.api.service.media.temu.dto;

import com.eshop.util.platform.api.structure.BaseResponseVO;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuImageUploadReqDTO extends BaseResponseVO {

    //参数接口	参数类型	是否必填	说明
    //image	STRING	是	支持格式有：jpg/jpeg、png等图片格式，注意入参图片必须转码为base64编码
    private String image;
    //imageBizType	INTEGER	否	枚举值：0、1，入参1返回的url用以货品发布时的外包装使用
    private Integer imageBizType;
    //options	OBJECT	否	-
    private TemuImageUploadOptionsDTO options;
    //cateId	INTEGER	是	叶子类目ID，按不同类型进行裁剪，当doIntelligenceCrop=true生效
    //doIntelligenceCrop	BOOLEAN	是	是否AI智能裁剪，true-根据sizeMode返回一组智能裁剪图（1张原图+3张裁剪图）
    //boost	BOOLEAN	是	是否AI清晰度提升
    //sizeMode	INTEGER	是	返回尺寸大小，0-原图大小，1-800*800（1:1），2-1350*1800（3:4）
}
