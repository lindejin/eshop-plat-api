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
 * 款式商品_素材
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_product_material")
public class TbProductMaterial implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 供应链商品id
     */
    private Integer scmProductId;

    /**
     * 样机_id
     */
    private Integer prototypeId;

    /**
     * 外部任务id
     */
    private String externalTaskId;

    /**
     * 外部任务同步状态（0未同步 1已同步）
     */
    private Integer synStatus;

    /**
     * 外部任务创建时间
     */
    private LocalDateTime taskCreateTime;

    /**
     * 成品_id
     */
    private Long finishedProductId;

    /**
     * 素材id
     */
    private Integer materialId;

    /**
     * 背景_id
     */
    private Integer backgroundId;

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
    private Integer productId;
}
