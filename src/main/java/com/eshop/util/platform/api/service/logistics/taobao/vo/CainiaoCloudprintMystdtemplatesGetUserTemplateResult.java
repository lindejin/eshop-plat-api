package com.eshop.util.platform.api.service.logistics.taobao.vo;

import java.util.List;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 16:40
 **/
@lombok.Getter
@lombok.Setter
public class CainiaoCloudprintMystdtemplatesGetUserTemplateResult {

    //字段名	类型	示例值	说明
    //cp_code	String	YTO	cp编码
    //user_std_templates	UserTemplateDo[]	用户使用的模板数据	用户使用的模板数据

    //
    private String cp_code;

    private List<CainiaoCloudprintMystdtemplatesGetUserTemplateDo> user_std_templates;
}
