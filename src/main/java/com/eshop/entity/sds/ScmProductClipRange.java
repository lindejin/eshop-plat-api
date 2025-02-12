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
 * 定位加工递增百分比
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("scm_product_clip_range")
public class ScmProductClipRange implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 供应链商品_id
     */
    private Long scmProductId;

    /**
     * 定位_id
     */
    private Long scmClipId;

    /**
     * 定位名称
     */
    private String clipName;

    /**
     * 递增属性值
     */
    private String rangeAttrVal;

    /**
     * 递增百分比
     */
    private Double rangePct;
}
