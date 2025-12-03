package com.eshop.util.platform.api.service.order.xiaohongshu.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
public class XiaohongshuOrderSimpleDeliveryOrder {

    //  deliveryOrderIndex	integer	发货订单索引标识 修改快递单号会使用
    //	status	integer	发货订单状态,1:已下单待付款 2:已支付处理中 3:清关中 4:待发货 6:待收货 7:已完成 8:已关闭 9:已取消 10:换货申请中
    //	expressTrackingNo	string	拆包快递单号
    //	expressCompanyCode	string	快递公司代码
    //	skuIdList	array<string>	此发货订单中有哪些商品，status=4待发货时，列表中的sku可以拆包发货。status=6时，列表中的sku共享相同的快递公司和单号，修改时一起修改
    //	expressUrlProofList	object	非必填，List<String>格式，仅用于自动发货订单的发货链接展示


    private Integer deliveryOrderIndex;
    private Integer status;
    private String expressTrackingNo;
    private String expressCompanyCode;
    private List<String> itemIdList;
    private List<String> skuIdList;
    private List<String> expressUrlProofList;

}
