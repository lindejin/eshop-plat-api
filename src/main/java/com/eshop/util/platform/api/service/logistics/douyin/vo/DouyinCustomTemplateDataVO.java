package com.eshop.util.platform.api.service.logistics.douyin.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
public class DouyinCustomTemplateDataVO {
    //参数名称	参数类型	是否必须	示例值	参数描述
    //logistics_code	String	否	shunfeng	物流服务商编码
    private String logistics_code;
    //custom_template_infos	List	否	-	用户使用的模板数据
    private List<DouyinCustomTemplateInfoVO> custom_template_infos;

}
