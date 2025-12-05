package com.eshop.util.platform.api.service.logistics.jdl.dto;

@lombok.Getter
@lombok.Setter
public class JdlGetTemplatesReqDTO {

    //字段名	类型	是否必填	默认值	描述
    //cpCode	String	否	JD	承运商编码，入参cpCode作用于京东官方标准面单模板资源和自定义区资源。承运商编码列表。长度2-10
    private String cpCode;
    //templateType	Integer	否	1	模板类型：1.自定义区；2.自定义模板；不传则获取全部类型模板。长度1
    private Integer templateType;
}
