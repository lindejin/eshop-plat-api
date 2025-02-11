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
 * wms类目
 * </p>
 *
 * @author product
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("wms_category")
public class WmsCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * wms类目Id
     */
    private Long categoryId;

    /**
     * 父类目id
     */
    private Long parentId;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 目录级别(1:一级目录,2:级目录,3:三级目录,4:四级目录)
     */
    private Integer level;

    /**
     * 是否叶子节点(1: 是, 2:不是)
     */
    private Boolean isLeaf;

    /**
     * 排序
     */
    private Integer sortValue;
}
