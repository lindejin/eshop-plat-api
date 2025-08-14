package com.eshop.util.platform.api.service.product.temu.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuSizeChartGetReqDTO {

    //请求参数说明
    //参数接口	参数类型	是否必填	说明
    //catId	INTEGER	否	类目ID
    private Long catId;
    //offset	INTEGER	是	锚点（第一页传0）
    private Long offset;
    //pageSize	INTEGER	否	页面大小
    private Long pageSize;
}
