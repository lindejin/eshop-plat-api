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
 * 类目
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_category")
public class TbCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父类目id
     */
    private Long parentId;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 类目英文名称
     */
    private String categoryNameEn;

    /**
     * 目录级别(1:一级目录,2:级目录,3:三级目录,4:四级目录)
     */
    private Byte level;

    /**
     * 是否叶子节点(1: 是, 2:不是)
     */
    private Byte isLeaf;

    /**
     * 外部id
     */
    private Long rawId;

    /**
     * 外部父id
     */
    private Long rawParentId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人id
     */
    private Long creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private Date deleteTime;
}
