package com.eshop.entity.supply;

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
 * 供应商_spu信息
 * </p>
 *
 * @author supply
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_supplier_spu")
public class TbSupplierSpu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品spu
     */
    private String spu;

    /**
     * 供应商_id
     */
    private Integer supplierId;

    /**
     * 商品单价
     */
    private BigDecimal unitPrice;

    /**
     * 商品链接
     */
    private String productLink;

    /**
     * 是否为默认供应商(1:是,2否)
     */
    private Byte isDefault;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人_id
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
