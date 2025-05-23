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
 * 平台订单费用明细
 * </p>
 *
 * @author order
 * @since 2025-05-23
 */
@Getter
@Setter
@ToString
@TableName("tb_order_bill_platform")
public class TbOrderBillPlatform implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 平台id
     */
    private Long platformId;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 账单类型(指各个接口的费用信息,各个平台自己定义)
     */
    private Byte billType;

    /**
     * 订单费用json
     */
    private String responseBody;

    /**
     * 状态(1: 最新结果, 2: 被跟新覆盖的)
     */
    private Byte status;

    /**
     * 创建时间
     */
    private Date createTime;
}
