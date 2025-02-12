package com.eshop.entity.depot;

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
 * 仓位
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_depot_position")
public class TbDepotPosition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 仓位编号
     */
    private String positionCode;

    /**
     * 仓位序号
     */
    private Long positionNo;

    /**
     * 是否已放商品(1:是; 2:否)
     */
    private Byte isHaveGoods;

    /**
     * 区域_id
     */
    private Long areaId;

    /**
     * 货架_id
     */
    private Long shelfId;

    /**
     * 货架层_id
     */
    private Long tierId;

    /**
     * 行业_id
     */
    private Long industryId;

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
    private Long createrId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改人id
     */
    private Long lastUpdateId;

    /**
     * 最后修改时间
     */
    private Date lastUpdateTime;

    /**
     * 库存sku编号 (有值表示永久绑定)
     */
    private String productSku;

    /**
     * 列
     */
    private Long columnIndex;

    /**
     * 层
     */
    private Long rowIndex;

    /**
     * 仓位类型(1.普通 2.虚拟)
     */
    private Byte positionType;
}
