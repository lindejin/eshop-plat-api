package com.eshop.entity.customer;

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
 * 客户购买记录表
 * </p>
 *
 * @author customer
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("customer_purchase_record")
public class CustomerPurchaseRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 客户信息表id
     */
    private Long customerInfoId;

    /**
     * 平台_id
     */
    private Long platformId;

    /**
     * 商户_id
     */
    private Long merchantId;

    /**
     * 店铺_id
     */
    private Long shopId;

    /**
     * 店长/负责人_id
     */
    private Long shopownerId;

    /**
     * 最近一笔订单时间
     */
    private Date lastOrderTime;
}
