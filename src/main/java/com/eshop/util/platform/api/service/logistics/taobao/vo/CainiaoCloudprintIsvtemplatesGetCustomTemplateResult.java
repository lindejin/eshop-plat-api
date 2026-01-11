package com.eshop.util.platform.api.service.logistics.taobao.vo;

import java.util.List;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 16:27
 **/
@lombok.Getter
@lombok.Setter
public class CainiaoCloudprintIsvtemplatesGetCustomTemplateResult {

    //字段名	类型	示例值	说明
    //isv_template_id	Number	1011	isv模板的id
    //isv_template_name	String	自定义模板1	isv模板的名称
    //isv_template_url	String	http://cloud.print.cainiao.com/xxx	isv模板的url
    //keys	KeyResult[]	-	模板的keys
    //version	String	1.0	版本号

    private Long isv_template_id;
    private String isv_template_name;
    private String isv_template_url;
    private List<CainiaoCloudprintIsvtemplatesGetKeyResult> keys;
    private String version;

}
