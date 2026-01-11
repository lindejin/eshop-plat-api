package com.eshop.util.platform.api.service.logistics.taobao.vo;

import java.util.List;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-11 21:48
 **/
@lombok.Getter
@lombok.Setter
public class CainiaoCloudprintStdtemplatesGetStandardTemplateStdResult {
    //字段名	类型	示例值	说明
    //cp_code	String	YTO	CP编码
    //standard_templates	StandardTemplateDo[]	-	该CP的所有标准模板

    private String cp_code;
    private CainiaoCloudprintStdtemplatesGetStandardTemplateDo standard_templates;

}
