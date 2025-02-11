package com.eshop.entity.depot;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * AMS采购单
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("ams_purchase_order")
public class AmsPurchaseOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 采购单号
     */
    private String purchaseNo;

    /**
     * 采购数量
     */
    private Integer purchaseNumber;

    /**
     * 采购总价
     */
    private BigDecimal purchaseMoney;

    /**
     * 运费
     */
    private BigDecimal freight;

    /**
     * 商品主键Id
     */
    private Integer amsProductId;

    /**
     * 下单人
     */
    private String orderName;

    /**
     * 采购单状态
     */
    private String orderStatus;

    /**
     * 导入时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人Id
     */
    private Integer createId;
}
