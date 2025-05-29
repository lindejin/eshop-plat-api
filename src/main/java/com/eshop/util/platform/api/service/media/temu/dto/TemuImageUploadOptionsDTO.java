package com.eshop.util.platform.api.service.media.temu.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuImageUploadOptionsDTO {
    //cateId	INTEGER	是	叶子类目ID，按不同类型进行裁剪，当doIntelligenceCrop=true生效
    private String cateId;
    //doIntelligenceCrop	BOOLEAN	是	是否AI智能裁剪，true-根据sizeMode返回一组智能裁剪图（1张原图+3张裁剪图）
    private Boolean doIntelligenceCrop;
    //boost	BOOLEAN	是	是否AI清晰度提升
    private Boolean boost;
    //sizeMode	INTEGER	是	返回尺寸大小，0-原图大小，1-800*800（1:1），2-1350*1800（3:4）
    private Integer sizeMode;
}
