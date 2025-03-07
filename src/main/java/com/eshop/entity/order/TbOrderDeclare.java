package com.eshop.entity.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 订单申报信息
 * </p>
 *
 * @author order
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_order_declare")
public class TbOrderDeclare implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 商品sku
     */
    private String productSku;

    /**
     * 商品申报中文名称
     */
    private String declareCnName;

    /**
     * 商品申报英文名称
     */
    private String declareEnName;

    /**
     * 申报价格(存的是总价)
     */
    private BigDecimal declarePrice;

    /**
     * 申报重量(保存的是总重量,单位克)
     */
    private Double declareWeight;

    /**
     * 申报数量
     */
    private Long declareCount;

    /**
     * 报关编码
     */
    private String customsCode;
}
