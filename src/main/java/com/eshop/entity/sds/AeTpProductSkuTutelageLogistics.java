package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 速卖通产品物流信息
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("ae_tp_product_sku_tutelage_logistics")
public class AeTpProductSkuTutelageLogistics implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 产品SkuId
     */
    private Long skuId;

    /**
     * 是否原箱 1.是 0.否
     */
    private Byte isOriginalBox;

    /**
     * 重量kg
     */
    private BigDecimal grossWeight;

    /**
     * 商品包装高度 单位:厘米。
     */
    private Long packageHeight;

    /**
     * 商品包装长度 单位:厘米。
     */
    private Long packageLength;

    /**
     * 商品包装宽度 单位:厘米。
     */
    private Long packageWidth;

    /**
     * 特殊商品类型 1.纯电 2.闪电 3.弱磁 4.强磁 5.液体 6.粉末 7.膏体 8.管制刀具 9.颗粒
     */
    private String type;

    /**
     * 创建人
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Long updateId;

    /**
     * 修改时间
     */
    private Date updateTime;
}
