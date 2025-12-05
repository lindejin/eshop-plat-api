package com.eshop.util.platform.api.service.logistics.jdl.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
public class JdlTemplateCustomTemplateListDto {
    //type	String	出库单	模板类型名称，长度2-20
    //templates	List<CustomTemplateDto>		对应类型自定义模板资源列表

    private String type;
    private List<JdlTemplateCustomTemplateDto> templates;
}
