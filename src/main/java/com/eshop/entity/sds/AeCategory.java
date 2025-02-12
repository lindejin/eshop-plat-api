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
 * 虾皮商品类目
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("ae_category")
public class AeCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 发布类目id(ae平台)
     */
    private String catePubId;

    /**
     * 父级发布类目(ae平台)
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
    private Byte isleaf;

    /**
     * 发布类目层级
     */
    private Byte level;

    /**
     * 类目特征的map
     */
    private String features;
}
