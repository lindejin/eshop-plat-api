package com.eshop.util.platform.api.service.logistics.taobao.vo;

import java.util.List;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 16:41
 **/
@lombok.Getter
@lombok.Setter
public class CainiaoCloudprintMystdtemplatesGetUserTemplateDo {

    //字段名	类型	示例值	说明
    //keys	KeyResult[]	keys	模板的keys
    //user_std_template_url	String	http://cloudprint.cainiao.com/xxx	用户使用模板的url
    //user_std_template_id	Number	1021	用户使用模板的id
    //user_std_template_name	String	模板1	用户使用模板名称
    //brand_code	String	品牌 code	品牌 code

    //
    private List<CainiaoCloudprintMystdtemplatesGetKeyResult> keys;
    private String user_std_template_url;
    private Long user_std_template_id;
    private String user_std_template_name;
    private String brand_code;

}
