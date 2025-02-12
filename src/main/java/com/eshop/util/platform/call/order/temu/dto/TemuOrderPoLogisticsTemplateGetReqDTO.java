package com.eshop.util.platform.call.order.temu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoLogisticsTemplateGetReqDTO {
    //siteIds  update 	LIST		站点ID列表
    private List<Long> siteIds;
}
