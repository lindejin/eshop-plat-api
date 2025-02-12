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
 * 敦煌商品类目
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("dh_category")
public class DhCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 发布类目id（物理父级类目id + 自身id 每段为3位）
     */
    private String catePubId;

    /**
     * 父级发布类目（物理父级类目）
     */
    private String pareCatePubId;

    /**
     * 英文名称
     */
    private String pubName;

    /**
     * 中文名称	
     */
    private String pubNameCn;

    /**
     * 不能包含的关键词	
     */
    private String excludeKeywords;

    /**
     * 必须包含的关键词
     */
    private String inlucdeKeywords;

    /**
     * 是否叶子类目（1：是， 0：不是）
     */
    private String leaf;

    /**
     * 是否有效类目（1：是， 0：不是）
     */
    private String valid;

    /**
     * 说明
     */
    private String remark;

    /**
     * 目录级别(1:一级目录,2:级目录,3:三级目录,4:四级目录)
     */
    private Byte level;
}
