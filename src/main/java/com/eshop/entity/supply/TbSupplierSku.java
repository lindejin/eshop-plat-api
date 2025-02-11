package com.eshop.entity.supply;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 供应商_sku信息
 * </p>
 *
 * @author supply
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_supplier_sku")
public class TbSupplierSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 供应商_id
     */
    private Integer supplierId;

    /**
     * sku编码
     */
    private String skuCode;

    /**
     * 创建人_id
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
