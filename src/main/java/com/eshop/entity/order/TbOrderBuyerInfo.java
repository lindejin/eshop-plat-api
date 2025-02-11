package com.eshop.entity.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 订单买家信息
 * </p>
 *
 * @author order
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_order_buyer_info")
public class TbOrderBuyerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 买家id
     */
    private String buyerId;

    /**
     * 买家姓名
     */
    private String buyerName;

    /**
     * 买家邮箱
     */
    private String email;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 国家
     */
    private String country;

    /**
     * 省/州
     */
    private String provinceOrState;

    /**
     * 城市
     */
    private String city;

    /**
     * 税号
     */
    private String dutyParagraph;

    /**
     * 卖家税号
     */
    private String sellerTaxCode;
}
