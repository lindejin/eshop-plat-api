package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 样机定位组
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_prototype_clip")
public class TbPrototypeClip implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 样机_id
     */
    private Long prototypeId;

    /**
     * 定位名称
     */
    private String clipName;

    /**
     * 默认定位宽度(cm)
     */
    private BigDecimal width;

    /**
     * 默认定位高度(cm)
     */
    private BigDecimal height;

    /**
     * 递增属性
     */
    private String rangeAttr;
}
