package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 关键词
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("product_keyword")
public class ProductKeyword implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 关系类型 1.子库 2.模版
     */
    private Byte productType;

    /**
     * 平台Code
     */
    private String platformCode;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * spuCode
     */
    private String spuCode;

    /**
     * 关键词id
     */
    private Integer keywordId;

    /**
     * 关键词
     */
    private String keyword;

    /**
     * 排序
     */
    private Byte sort;

    /**
     * 创建人
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private Integer updateId;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
