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
 * 虾皮全球商品类目
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("shopee_global_category")
public class ShopeeGlobalCategory implements Serializable {

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
     * 是否叶子类目（1：是， 0：不是）
     */
    private Byte leaf;
}
