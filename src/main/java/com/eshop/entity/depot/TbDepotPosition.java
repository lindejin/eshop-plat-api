package com.eshop.entity.depot;

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
 * 仓位
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_depot_position")
public class TbDepotPosition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 仓库id
     */
    private Integer depotId;

    /**
     * 仓位编号
     */
    private String positionCode;

    /**
     * 仓位序号
     */
    private Integer positionNo;

    /**
     * 是否已放商品(1:是; 2:否)
     */
    private Byte isHaveGoods;

    /**
     * 区域_id
     */
    private Integer areaId;

    /**
     * 货架_id
     */
    private Integer shelfId;

    /**
     * 货架层_id
     */
    private Integer tierId;

    /**
     * 行业_id
     */
    private Integer industryId;

    /**
     * 仓位距离(1:远, 2: 近)
     */
    private Byte distance;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人id
     */
    private Integer createrId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后修改人id
     */
    private Integer lastUpdateId;

    /**
     * 最后修改时间
     */
    private LocalDateTime lastUpdateTime;

    /**
     * 库存sku编号 (有值表示永久绑定)
     */
    private String productSku;

    /**
     * 列
     */
    private Integer columnIndex;

    /**
     * 层
     */
    private Integer rowIndex;

    /**
     * 仓位类型(1.普通 2.虚拟)
     */
    private Byte positionType;
}
