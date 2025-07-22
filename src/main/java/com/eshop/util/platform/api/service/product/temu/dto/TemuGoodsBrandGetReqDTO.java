package com.eshop.util.platform.api.service.product.temu.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsBrandGetReqDTO {

    //    参数接口	参数类型	是否必填	说明
    //    vid	INTEGER	否	搜索的属性值id
    private Long vid;
    //    brandName	STRING	否	搜索的品牌名称
    private String brandName;
    //    supplierId	INTEGER	是	供应商id
    private Long supplierId;
    //    pageSize	INTEGER	是	页面大小
    private Integer pageSize;
    //    page	INTEGER	是	页码
    private Integer page;


}
