package com.eshop.util.platform.api.service.order.jushuitan.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JushuitanConfirmDeliverySaleOrderItemReqDTO {

    //sku_id	string	否		商品编码
    private String sku_id;
    //sn_list	array	否		唯一码列表
    private List<String> sn_list;
    //sn_exts	array	否		国补场景传
    private List<JushuitanConfirmDeliverySaleOrderItemSnExtReqDTO> sn_exts;
    //batch_list	array	否		批次节点，需要开启基础设置：不开启生产批次管理下，支持生产批次记录到跟踪信息
    private List<JushuitanConfirmDeliverySaleOrderItemBatchReqDTO> batch_list;
}
