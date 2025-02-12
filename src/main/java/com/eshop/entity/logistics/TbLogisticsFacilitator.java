package com.eshop.entity.logistics;

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
 * 物流服务商
 * </p>
 *
 * @author logistics
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_logistics_facilitator")
public class TbLogisticsFacilitator implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 共用_服务商编码(唯一值)
     */
    private String facilitatorCode;

    /**
     * 服务商名
     */
    private String facilitatorName;

    /**
     * 服务商别名
     */
    private String facilitatorAliasName;

    /**
     * 是否停用,1:未停用,2:已停用
     */
    private Byte facilitatorStatus;

    /**
     * 是否授权:1已授权,2:未授权
     */
    private Byte isAuthorized;

    /**
     * 备注
     */
    private String remark;

    /**
     * 帮助文档地址
     */
    private String helpFileUrl;

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
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private Date deleteTime;

    /**
     * 删除人Id
     */
    private Long deleteId;
}
