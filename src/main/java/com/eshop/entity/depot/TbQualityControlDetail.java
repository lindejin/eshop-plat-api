package com.eshop.entity.depot;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 质检单明细
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_quality_control_detail")
public class TbQualityControlDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 质检单号
     */
    private Long qcNo;

    /**
     * 采购单单号
     */
    private Long purchaseNo;

    /**
     * sku编号
     */
    private String productSku;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 异常原因
     */
    private Integer errorCauseId;

    /**
     * 备注
     */
    private String remark;
}
