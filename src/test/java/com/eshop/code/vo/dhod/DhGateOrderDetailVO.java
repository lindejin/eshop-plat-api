package com.eshop.code.vo.dhod;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DhGateOrderDetailVO {

    /**
     * 发货时间
     * 日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21
     */
    private String deliveryDate;

    /**
     * 订单涨价金额
     * 示例值:100.00
     */
    private Double risePrice;

    /**
     * 订单备注
     * 蓝色要10个，加急，圣诞前要用到等等备注信息
     */
    private String orderRemark;

    /**
     * 下单日期
     * 日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21
     */
    private String startedDate;

    /**
     * 订单编号
     * 卖家后台登录能看到成交的订单号；示例值：1330312162
     */
    private String orderNo;

    /**
     * 订单联盟补贴佣金
     * 订单联盟补贴佣金
     */
    private Double cpsSpecialCommission;

    /**
     * 买家下单备注
     * 买家下单备注
     */
    private String buyerRemark;

    /**
     * 付款时间
     * 日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21
     */
    private String payDate;

    /**
     * 订单是否合包
     * 订单是否合包，Y可合包，N为空或合包取消
     */
    private String isDPC;

    /**
     * 订单状态
     * 111000,订单取消;101003,等待买家付款;102001,买家已付款，等待平台确认;103001,等待发货;105001,买家申请退款，等待协商结果;105002,退款协议已达成;105003,部分退款后，等待发货;105004,买家取消退款申请;103002,已部分发货;101009,等待买家确认收货;106001,退款/退货协商中，等待协议达成;106002,买家投诉到平台;106003,协议已达成，执行中;102006,人工确认收货;102007,超过预定期限，自动确认收货;102111,交易成功;111111,交易关闭
     */
    private String orderStatus;

    /**
     * 运费
     * 示例值:100.00
     */
    private Double shippingCost;

    /**
     * 发货截止时间
     * 日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21
     */
    private String deliveryDeadline;

    /**
     * 订单退款金额
     * 示例值:100.00
     */
    private Double refundMoney;

    /**
     * seller优惠券
     * 示例值:100.00
     */
    private Double sellerCouponPrice;

    /**
     * 买家选择物流方式
     * 示例值：UPS,D-LINK等
     */
    private String shippingType;

    /**
     * 是否敦煌优选订单
     * 0:否, 1:是
     */
    private String preferOrder;

    /**
     * 订单处理信息
     * 订单处理信息
     */
    private List<DhOrderDetailDeliveryListItem> orderDeliveryList;

    /**
     * 订单总额
     * 示例值:100.00
     */
    private Double orderTotalPrice;

    /**
     * 实收金额
     * 示例值:100.00
     */
    private Double actualPrice;

    /**
     * 网关手续费
     * 示例值:100.00
     */
    private Double gatewayFee;

    /**
     * 订单补款金额
     * 示例值:100.00
     */
    private Double fillingMoney;

    /**
     * 佣金金额
     * 示例值:100.00
     */
    private Double commissionAmount;

    /**
     * 产品总计
     * 示例值:100.00
     */
    private Double itemTotalPrice;

    /**
     * 订单降价金额
     * 示例值:100.00
     */
    private Double reducePrice;

    /**
     * 订单联盟佣金
     * 订单联盟佣金
     */
    private Double cpsCommission;

    /**
     * 收货人基本信息
     * 订单基本信息
     */
    private DhOrderDetailOrderContact orderContact;
}