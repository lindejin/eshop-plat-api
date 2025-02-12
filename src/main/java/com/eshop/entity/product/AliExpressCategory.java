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
 * 速卖通商品类目
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("ali_express_category")
public class AliExpressCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品目录编号
     */
    private Long categoryId;

    /**
     * 父目录编号
如果为第一级目录时为0

     */
    private Long parentId;

    /**
     * 目录中文名
     */
    private String categoryName;

    /**
     * 目录英文名
     */
    private String categoryNameEn;

    /**
     * 表示是几级目录

1、一级目录

2、二级目录

3、三级目录

4、四级目录
     */
    private Byte level;

    /**
     * 是否是叶子节点:

1、否

2、是
     */
    private Byte isLeaf;

    /**
     * 用于下载数据的时候,做剔除用
     */
    private Byte flag;
}
