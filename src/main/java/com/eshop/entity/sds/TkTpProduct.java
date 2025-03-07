package com.eshop.entity.sds;

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
 * 模版基础信息
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tk_tp_product")
public class TkTpProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 模版id
     */
    private Long templateId;

    /**
     * 类目id
     */
    private String catePubId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品价格
     */
    private BigDecimal originalPrice;

    /**
     * 单价折扣
     */
    private BigDecimal priceDiscount;

    /**
     * 品牌id
     */
    private String brandId;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 描述-需要确认大小
     */
    private String description;

    /**
     * 包装高度，单位为厘米
     */
    private Long packageHeight;

    /**
     * 包装长度，单位为厘米
     */
    private Long packageLength;

    /**
     * 包装宽度，单位为厘米
     */
    private Long packageWidth;

    /**
     * 封装尺寸单位
     */
    private String packageDimensionUnit;

    /**
     * 重量
     */
    private BigDecimal packageWeight;

    /**
     * 默认sku库存
     */
    private Long availableStock;

    /**
     * 是否打开货到付款(1.是 2.否)
     */
    private Byte isCodOpen;

    /**
     * 送货服务 ID
     */
    private String deliveryServiceIds;

    /**
     * 仓库ID
     */
    private String warehouseId;

    /**
     * 仓库名称
     */
    private String warehouseName;
}
