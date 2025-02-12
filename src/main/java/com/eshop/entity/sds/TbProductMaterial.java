package com.eshop.entity.sds;

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
 * 款式商品_素材
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_product_material")
public class TbProductMaterial implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 供应链商品id
     */
    private Long scmProductId;

    /**
     * 样机_id
     */
    private Long prototypeId;

    /**
     * 外部任务id
     */
    private String externalTaskId;

    /**
     * 外部任务同步状态（0未同步 1已同步）
     */
    private Long synStatus;

    /**
     * 外部任务创建时间
     */
    private Date taskCreateTime;

    /**
     * 成品_id
     */
    private Long finishedProductId;

    /**
     * 素材id
     */
    private Long materialId;

    /**
     * 背景_id
     */
    private Long backgroundId;

    /**
     * 数据来源类型(4: 手动合成, 5: 自动合成)
     */
    private Byte sourceType;

    /**
     * 定位名称
     */
    private String clipName;

    /**
     * 宽度比例(定位实际厘米比例)
     */
    private Double widthPct;

    /**
     * 长度比例(定位实际厘米比例)
     */
    private Double heightPct;

    /**
     * 主商品_id(款式)
     */
    private Long productId;
}
