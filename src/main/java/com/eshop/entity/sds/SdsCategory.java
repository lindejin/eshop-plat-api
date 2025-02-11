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
 * sds类目属性值	
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("sds_category")
public class SdsCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * sds-平台分类id
     */
    private Integer categoryId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类父id
     */
    private Integer parentId;

    /**
     * 是否叶子类目（1：是， 0：不是）
     */
    private Byte leaf;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
