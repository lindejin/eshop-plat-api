package com.eshop.util.platform.call.order.temu.order.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoLogisticsTemplateGetResultResultVO {

    //freightTemplates	LIST	否
    private List<TemuOrderPoLogisticsTemplateGetFreightTemplateVO> freightTemplates;
}
