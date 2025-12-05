package com.eshop.util.platform.api.service.logistics.jdl.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
public class JdlTemplateCustomAreaListDto {

    //cpCode	String	JD	承运商编码，长度2-10
    //templates	List<CustomAreaDto>		对应承运商面单模板的自定义区资源列表

    private String cpCode;
    private List<JdlTemplateCustomAreaDto> templates;
}
