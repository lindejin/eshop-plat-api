package com.eshop.util.platform.api.service.logistics.taobao.vo;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 16:15
 **/
@lombok.Getter
@lombok.Setter
public class CainiaoCloudprintIsvResourcesGetIsvResourceDo {

    //字段名	类型	示例值	说明
    //resource_content	String	资源内容（当资源类型为TEMPLATE时，为空）	资源内容（当资源类型为TEMPLATE时，为空）
    //resource_id	Number	100	资源id
    //resource_name	String	资源名称	资源名称
    //resource_type	String	TEMPLATE	资源类型
    //resource_url	String	http://xxx	资源url（当资源类型为打印项时，为空）

    private String resource_content;
    private Long resource_id;
    private String resource_name;
    private String resource_type;
    private String resource_url;
}
