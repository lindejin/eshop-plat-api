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
 * 平台订单取消信息
 * </p>
 *
 * @author order
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_order_cancel")
public class TbOrderCancel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 平台Code
     */
    private String platformCode;

    /**
     * 平台名称
     */
    private String platformName;

    /**
     * 商户_id
     */
    private Long merchantId;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 店长/负责人_id
     */
    private Long shopownerId;

    /**
     * 取消状态(1.待处理, 2.同意 3.拒绝)
     */
    private Byte cancelStatus;

    /**
     * 申请取消时间
     */
    private Date applyCancelTime;

    /**
     * 买家取消原因
     */
    private String buyerCancelReason;

    /**
     * 反向拒绝原因(平台值)
     */
    private String reverseReason;

    /**
     * 拒绝原因Key(TK拒绝需要传入该值)
     */
    private String reverseReasonKey;

    /**
     * TK同意或者拒绝使用此ID
     */
    private String reverseOrderId;

    /**
     * 创建人
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Long updateId;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 备注(如何拒绝使用该值传入平台)
     */
    private String remarks;
}
