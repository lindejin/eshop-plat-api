package com.eshop.util.platform.api.service.logistics.taobao.vo;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-11 21:50
 **/
@lombok.Getter
@lombok.Setter
public class CainiaoCloudprintStdtemplatesGetStandardTemplateStdDo {
    //字段名	类型	示例值	说明
    //standard_template_id	Number	1024	模板ID
    //standard_template_name	String	YTO模板	模板名称
    //standard_template_url	String	http://xxx	模板URL
    //standard_waybill_type	Number	1	面单类型：1-快递标准面单, 2-快递三联面单, 3-快递便携式三联单, 4-快运标准面单, 5-快运三联面单, 6-快递一联单, 7-快递蓝牙标准面单, 8-快递蓝牙一联单, 9-快运一联单, 10-快运二联
    //brand_code	String	default	品牌编码，如果没有则为 default


    private Long standard_template_id;
    private String standard_template_name;
    private String standard_template_url;
    private Long standard_waybill_type;
    private String brand_code;
}
