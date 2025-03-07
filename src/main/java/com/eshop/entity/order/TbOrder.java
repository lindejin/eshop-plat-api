package com.eshop.entity.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 订单信息
 * </p>
 *
 * @author order
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_order")
public class TbOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 商户_id
     */
    private Long merchantId;

    /**
     * 交易号
     */
    private String transactionNo;

    /**
     * 平台id
     */
    private Long platformId;

    /**
     * 平台名称
     */
    private String platformName;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 订单状态(-1.已作废,1.待审,2.待处理,3.配货中,4.已发货,5.已完成,6.部分发货,7:等待配货,8:待重审)
     */
    private Byte orderStatus;

    /**
     * 订单类型(1.普通订单,2.推广订单,3.海外发货订单)
     */
    private Byte orderType;

    /**
     * 订单时间/下单时间
     */
    private Date orderTime;

    /**
     * 付款时间
     */
    private Date paymentTime;

    /**
     * 店长/负责人_id
     */
    private Long shopownerId;

    /**
     * 发货时间
     */
    private Date deliverTime;

    /**
     * 交货截止时间
     */
    private Date deliveryDeadlineTime;

    /**
     * 平台订单状态
     */
    private Long platformOrderStatus;

    /**
     * 平台留言/买家留言
     */
    private String platformMessage;

    /**
     * 平台备注
     */
    private String platformRemark;

    /**
     * 订单备注
     */
    private String orderRemark;

    /**
     * 订单发货备注
     */
    private String deliverRemark;

    /**
     * 支付类型
     */
    private Byte paymentType;

    /**
     * 收款账号
     */
    private String collectionAccountNumber;

    /**
     * 请款时间
     */
    private Date requestFundsTime;
}
