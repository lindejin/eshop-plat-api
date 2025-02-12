package com.eshop.entity.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 关键词组
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_product_keyword_group")
public class TbProductKeywordGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品词组id
     */
    private Long wordId;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 排序
     */
    private Byte sort;

    /**
     * 最少取词个数
     */
    private Byte startIndex;

    /**
     * 最多取词个数
     */
    private Byte endIndex;
}
