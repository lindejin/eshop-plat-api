package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * Temu产品 库存信息
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("temu_tp_product_warehous")
public class TemuTpProductWarehous implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品模板Id
     */
    private Integer productId;

    /**
     * 仓库ID
     */
    private String warehouseId;

    /**
     * 库存值 
     */
    private Integer targetStockAvailable;

    /**
     * 站点Id
     */
    private Integer siteId;

    /**
     * 仓库名称
     */
    private String warehouseName;
}
