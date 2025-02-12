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
 * 仓库权限
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_depot_auth")
public class TbDepotAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 权限类型 1.绑定用户
     */
    private Byte authType;

    /**
     * 权限关联id
     */
    private Long authLinkId;

    /**
     * 创建人id
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;
}
