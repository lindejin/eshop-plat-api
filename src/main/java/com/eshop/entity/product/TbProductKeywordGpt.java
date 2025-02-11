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
 * 关键词_gpt
 * </p>
 *
 * @author product
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_product_keyword_gpt")
public class TbProductKeywordGpt implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * spu编码
     */
    private String spuCode;

    /**
     * 关键词
     */
    private String keyword;

    /**
     * 关键词类型(1: 类别词, 2: 素材词, 3: 背景词, 4: 背景词标签)
     */
    private Byte keywordType;
}
