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
 * Temu商品类目
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("temu_category")
public class TemuCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类目id
     */
    private String catId;

    /**
     * 类目名称 
     */
    private String catName;

    /**
     * 类目层级
     */
    private Integer catLevel;

    /**
     * 类目类型，0：未分类，1：服饰类
     */
    private Integer catType;

    /**
     * 父类目id
     */
    private String parentCatId;

    /**
     * 是否叶子分类
     */
    private Boolean isLeaf;

    /**
     * 是否隐藏
     */
    private Boolean isHidden;

    /**
     * 隐藏类型，0：不隐藏，1：一般隐藏，2：老类目，3：废弃类目
     */
    private Long hiddenType;
}
