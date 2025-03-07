package com.eshop.sync;

import lombok.Data;
import java.util.List;

@Data
public class OrderVO {
    private Double actualPrice;                      // 实际价格
    private String shippingType;                     // 物流类型
    private String orderStatus;                      // 订单状态
    private String startedDate;                     // 订单开始时间
    private String deliveryDeadline;                 // 配送截止时间
    private Double cpsSpecialCommission;            // CPS 特殊佣金
    private Double cpsCommission;                   // CPS 佣金
    private Double gatewayFee;                      // 网关费用
    private String deliveryDate;                     // 配送日期
    private String orderNo;                          // 订单号
    private Double shippingCost;                     // 物流费用
    private Double orderTotalPrice;                 // 订单总价
    private Double itemTotalPrice;                  // 商品总价
    private Double sellerCouponPrice;               // 卖家优惠券金额
    private String isDPC;                            // 是否为 DPC 订单
    private OrderContact orderContact;              // 订单联系人信息（内部类）
    private List<OrderDelivery> orderDeliveryList;  // 订单配送信息列表（内部类）
    private String preferOrder;                      // 偏好订单
    private Status status;                          // 状态信息（内部类）
    private String payDate;                         // 支付日期
    private Double commissionAmount;                // 佣金金额

    // 订单联系人信息
    @Data
    public static class OrderContact {
        private String lastName;                     // 姓氏
        private String country;                      // 国家
        private String city;                         // 城市
        private String buyerNickName;                // 买家昵称
        private String contactName;                  // 联系人姓名
        private String telephone;                    // 电话
        private String buyerId;                      // 买家 ID
        private String firstName;                    // 名字
        private String postalcode;                   // 邮政编码
        private String addressLine1;                 // 地址行 1
        private String addressLine2;                 // 地址行 2
        private String state;                        // 州/省
    }

    // 订单配送信息
    @Data
    public static class OrderDelivery {
        private String deliveryNo;                   // 配送单号
        private String shippingType;                // 物流类型
        private String deliveryDate;                // 配送日期
    }

    // 状态信息
    @Data
    public static class Status {
        private String code;                         // 状态码
        private String solution;                     // 解决方案
        private String message;                      // 消息
        private List<SubError> subErrors;           // 子错误列表（内部类）

        // 子错误信息
        @Data
        public static class SubError {
            private String code;                     // 子错误码
            private String message;                  // 子错误消息
        }
    }
}
