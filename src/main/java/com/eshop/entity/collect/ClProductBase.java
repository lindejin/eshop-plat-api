package com.eshop.entity.collect;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 采集商品基础信息
 * </p>
 *
 * @author collect
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("cl_product_base")
public class ClProductBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    private Integer productId;

    /**
     * spu编码
     */
    private String spuCode;

    /**
     * 长描述
     */
    private String longDetail;

    /**
     * 短描述
     */
    private String shortDetail;
}
