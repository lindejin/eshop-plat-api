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
 * Temu产品skc信息
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("temu_product_skc")
public class TemuProductSkc implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品模板Id
     */
    private Long productId;

    /**
     * SKC色块图 Id	SKC色块图Id
     */
    private Long colorImageUrlId;

    /**
     * 货品skc外部编码，没有的场景传空字符串
     */
    private String extCode;

    /**
     * 是否底板 1:是,2:否
     */
    private Byte isBasePlate;

    /**
     * 主销售属性Id
     */
    private String pid;

    /**
     * 产品属性名称
     */
    private String propName;

    /**
     * 主销售属性值Id
     */
    private String vid;

    /**
     * 产品属性值名称
     */
    private String valName;

    /**
     * 平台产品skcId
     */
    private String platformSkcId;

    /**
     * 是否可以开启了JIT模式 1:是, 2:否
     */
    private Byte isJit;
}
