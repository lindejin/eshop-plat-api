package com.eshop.util.platform.call.order.temu.ship.dto;


import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipV2GetReqDTO {

    //参数接口	参数类型	是否必填	说明
    //productSkcIdList	LIST	否	skcId列表
    private List<Long> productSkcIdList;
    //isCustomProduct	BOOLEAN	否	是否为定制品 false-非定制品 true-定制品
    private Boolean isCustomProduct;
    //pageSize	INTEGER	是	每页记录数不能为空
    private Integer pageSize;
    //expressDeliverySnList	LIST	否	快递单号列表
    private List<String> expressDeliverySnList;
    //expressWeightFeedbackStatus	LIST	否	运单计费重量异常状态 1-异常待确认 2-已提交异常反馈，待物流商处理 3-物流商处理完成 4-平台介入处理中 5-平台处理完成. 可选值含义说明:[0:未定义（数据库默认值）或无异常;1:异常待确认;2:已提交异常反馈，待物流商处理;3:物流商处理完成;4:平台介入处理中;5:平台处理完成;6:卖家已确认;7:卖家超期自动确认;8:物流商介入处理，卖家确认或超时自动确认;9:结算消息驱动卖家确认;10:无需公示;11:结算物流单计算重量查询失败;12:结算理论计费重拦截;13:SKU重量体积拦截;]
    private List<Integer> expressWeightFeedbackStatus;
    //pageNo	INTEGER	是	页号， 从1开始
    private Integer pageNo;
    //isPrintBoxMark	INTEGER	否	是否已打印商品打包标签 0-未打印 1-已打印
    private Integer isPrintBoxMark;
    //targetDeliveryAddress	STRING	否	筛选项-发货地址（精准匹配）
    private String targetDeliveryAddress;
    //onlyTaxWarehouseWaitApply	BOOLEAN	否	仅查看保税仓资料待上传
    private Boolean onlyTaxWarehouseWaitApply;
    //subWarehouseIdList	LIST	否	收货子仓列表
    private List<Long> subWarehouseIdList;
    //subPurchaseOrderSnList	LIST	否	子采购单号列表
    private List<String> subPurchaseOrderSnList;
    //latestFeedbackStatusList	LIST	否	最新反馈状态列表 0-当前无异常 1-已提交 2-物流商处理中 4-已反馈 3-已撤销
    private List<Integer> latestFeedbackStatusList;
    //urgencyType	INTEGER	否	是否是紧急发货单，0-普通 1-急采
    private Integer urgencyType;
    //targetReceiveAddress	STRING	否	筛选项-收货地址（精准匹配）
    private String targetReceiveAddress;
    //deliverTimeFrom	INTEGER	否	发货时间-开始时间
    private Long deliverTimeFrom;
    //skcExtCodeList	LIST	否	货号列表
    private List<String> skcExtCodeList;
    //deliveryOrderSnList	LIST	否	发货单号列表
    private List<String> deliveryOrderSnList;
    //inventoryRegion	LIST	否	发货区域
    private List<Integer> inventoryRegion;
    //deliverTimeTo	INTEGER	否	发货时间-结束时间
    private Long deliverTimeTo;
    //isVmi	INTEGER	否	是否是vmi 0-非VMI 1-VMI
    private Integer isVmi;
    //sortType	INTEGER	否	排序类型 0-创建时间最新在上 1-要求发货时间较早在上 2-按照仓库名称排序
    private Integer sortType;
    //isJit	BOOLEAN	否	是否是jit，true:jit
    private Boolean isJit;
    //sortFieldName	STRING	否	排序字段名
    private String sortFieldName;
    //status	INTEGER	否	发货单状态 查询发货批次时仅支持查询发货单状态=1
    private Integer status;
}
