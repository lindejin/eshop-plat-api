package com.eshop.util.platform.api.service.logistics.jdl.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
public class JdlTemplatesDataVO {
    //standardTemplateList	List<StandardTemplatesDto>		京东官方标准面单模板资源列表
    //userTemplateList	UserTemplatesDto		订阅ISV服务的普通商家绘制的模板资源列表
    //isvTemplateList	IsvTemplatesDto		ISV绘制的模板资源列表
    //devUserTemplateList	DevUserTemplatesDto		自研商家绘制的模板资源列表

    private List<JdlTemplateStandardTemplatesVO> standardTemplateList;
    private JdlTemplateUserTemplatesVO userTemplateList;
    private JdlTemplateIsvTemplatesVO isvTemplateList;
    private JdlTemplateDevUserTemplatesVO devUserTemplateList;
}
