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
 * 虾皮产品包装尺码
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("shopee_dimension")
public class ShopeeDimension implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品sku_id
     */
    private Integer productId;

    /**
     * 产品sku编码
     */
    private String spuCode;

    /**
     * 包装高度，单位为厘米
     */
    private Integer packageHeight;

    /**
     * 包装长度，单位为厘米
     */
    private Integer packageLength;

    /**
     * 包装宽度，单位为厘米
     */
    private Integer packageWidth;

    /**
     * 重量
     */
    private BigDecimal weight;
}
