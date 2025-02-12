package com.eshop.entity.depot;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 货架
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_depot_shelf")
public class TbDepotShelf implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父节点id
     */
    private Long parentId;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 节点code
     */
    private String nodeCode;

    /**
     * 节点名称
     */
    private String nodeName;

    /**
     * 可用仓位数量
     */
    private Long availableAmount;

    /**
     * 表示是几级目录

1、一级目录

2、二级目录

3、三级目录

4、四级目录
     */
    private Byte level;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;
}
