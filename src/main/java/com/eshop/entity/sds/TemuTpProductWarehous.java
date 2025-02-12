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
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("temu_tp_product_warehous")
public class TemuTpProductWarehous implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品模板Id
     */
    private Long productId;

    /**
     * 仓库ID
     */
    private String warehouseId;

    /**
     * 库存值 
     */
    private Long targetStockAvailable;

    /**
     * 站点Id
     */
    private Long siteId;

    /**
     * 仓库名称
     */
    private String warehouseName;
}
