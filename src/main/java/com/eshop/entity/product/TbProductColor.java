package com.eshop.entity.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 主商品颜色
 * </p>
 *
 * @author product
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_product_color")
public class TbProductColor implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 颜色中文名称
     */
    private String name;

    /**
     * 颜色英文名称
     */
    private String nameEn;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 删除时间
     */
    private Date deleteTime;
}
