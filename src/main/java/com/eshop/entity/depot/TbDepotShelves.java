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
 * 仓库货架
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_depot_shelves")
public class TbDepotShelves implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 仓库id
     */
    private Integer depotId;

    /**
     * 区域id
     */
    private Integer areaId;

    /**
     * 货架名称
     */
    private String shelfName;

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
     * 仓位前缀
     */
    private String positionPrefix;

    /**
     * 列数
     */
    private Integer columnNumber;

    /**
     * 层数
     */
    private Integer rowNumber;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private LocalDateTime deleteTime;
}
