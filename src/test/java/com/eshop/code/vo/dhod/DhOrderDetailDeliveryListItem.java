package com.eshop.code.vo.dhod;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DhOrderDetailDeliveryListItem {
    /**
     * 修改后物流方式
     * 没有修改时为空
     */
    private String newShippingType;

    /**
     * 修改后运单号
     * 没修改运单号此字段为空
     */
    private String newDeliveryNo;

    /**
     * 投诉状态
     * 0：投诉已取消，2：真实运单号，3：请更新运单号，4：调查后真实运单号，5：已处罚
     */
    private String complaintStatus;

    /**
     * 运单号
     * 示例值：1Z68A9X70467731838
     */
    private String deliveryNo;

    /**
     * 处理结果
     * 如买家来信要求取消、真实运单号、重复投诉等
     */
    private String processingResults;

    /**
     * 修改后备注
     * 已发货，附赠小赠品等等
     */
    private String newRemark;

    /**
     * 发货时间
     * 日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21
     */
    private String deliveryDate;

    /**
     * 物流方式(卖家填写的)
     * 示例值：UPS,D-LINK等
     */
    private String shippingType;

    /**
     * 备注
     * 已发货，附赠小赠品等等
     */
    private String remark;

}