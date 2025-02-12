package com.eshop.entity.kpi;

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
 * 项目组
 * </p>
 *
 * @author kpi
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("kpi_project_team")
public class KpiProjectTeam implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 项目组名称
     */
    private String groupName;

    /**
     * logo图片id
     */
    private Long logoImgId;

    /**
     * 组长
     */
    private String groupLeader;

    /**
     * 是否播报(1: 是, 2: 否)
     */
    private Byte isBroadcast;

    /**
     * 创建人id
     */
    private Long createId;

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
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private Date deleteTime;
}
