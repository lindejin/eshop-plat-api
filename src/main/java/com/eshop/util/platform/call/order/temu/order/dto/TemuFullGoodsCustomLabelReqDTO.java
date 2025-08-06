package com.eshop.util.platform.call.order.temu.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuFullGoodsCustomLabelReqDTO {
    //参数名称 	类型 	是否必须 	说明
    //page	integer(int64)	是 	页码
    private Long page;
    //pageSize	integer(int64)	是 	页面大小
    private Long pageSize;
    //productSkuIdList	list	否	货品sku id列表
    private List<Long> productSkuIdList;
    //skcExtCode	string	否	skc货号
    private String skcExtCode;
    //productSkcIdList	list	否	货品skc id列表
    private List<Long> productSkcIdList;
    //skuExtCode	string	否	sku货号
    private String skuExtCode;
    //labelCode	integer(int64)	否	标签条码
    private Long labelCode;
    //personalProductSkuIdList	list	否	定制品sku id
    private List<Long> personalProductSkuIdList;
    //createTimeStart	integer(int64)	否	定制品创建时间，支持毫秒时间戳
    private Long createTimeStart;
    //createTimeEnd	integer(int64)	否	定制品创建时间，支持毫秒时间戳
    private Long createTimeEnd;
    //return_data_key	string	否	是否以打印页面url返回；
    //如果入参'true'，则不返回参数信息，返回dataKey，通过拼接https://openapi.kuajingmaihuo.com/tool/print?dataKey={返回的dataKey}，访问组装的url即可打印，打印的条码按照入参参数所得结果进行打印
    //其他情况，则返回参数信息，需要开发者自行对参数进行条形码组装
    private String return_data_key;

}
