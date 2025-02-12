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
 * 样机属性
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_prototype_attr")
public class TbPrototypeAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 样机_id
     */
    private Long prototypeId;

    /**
     * 产品属性名称
     */
    private String attrName;

    /**
     * 属性值是否存在图片(1: 是, 2:否)
     */
    private Byte isContainImg;
}
