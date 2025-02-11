package com.eshop.entity.sds;

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
 * sds成品
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("sds_turnoff")
public class SdsTurnoff implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * sds成品id
     */
    private Long turnoffId;

    /**
     * spu编码
     */
    private String spuCode;

    /**
     * sku编码
     */
    private String skuCode;

    /**
     * sds产品id
     */
    private Integer productId;

    /**
     * 分类id
     */
    private Integer categoryId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * sds产品母体id
     */
    private Integer productParentId;

    /**
     * 素材名称
     */
    private String layerName;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 素材ID
     */
    private String layerId;

    /**
     * 颜色
     */
    private String color;

    /**
     * 尺码	尺码
     */
    private String size;

    /**
     * 成品类型  2母体 3简单商品 4变体
     */
    private Byte type;

    /**
     * key_id
     */
    private String keyId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
