package com.eshop.util.platform.api.service.logistics.jdl.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
public class JdlTemplateDevUserTemplatesVO {
    //customAreaList	List<CustomAreaListDto>		自定义区资源列表
    //customTemplateList	List<CustomTemplateListDto>		自定义模板资源列表

    private List<JdlTemplateCustomAreaListDto> customAreaList;
    private List<JdlTemplateCustomTemplateListDto> customTemplateList;
}
