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
 * 仓库货架
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_depot_shelves")
public class TbDepotShelves implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 区域id
     */
    private Long areaId;

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
     * 仓位前缀
     */
    private String positionPrefix;

    /**
     * 列数
     */
    private Long columnNumber;

    /**
     * 层数
     */
    private Long rowNumber;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private Date deleteTime;
}
