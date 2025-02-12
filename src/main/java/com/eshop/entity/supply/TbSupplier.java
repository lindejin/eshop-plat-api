package com.eshop.entity.supply;

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
 * 供应商
 * </p>
 *
 * @author supply
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_supplier")
public class TbSupplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 是否启用(1: 启用, 2: 停用)
     */
    private Byte status;

    /**
     * 供应商类型(1: 线下, 2: 1688, 3: 拼多多, 4: 淘宝, 5: 其他)
     */
    private Byte supplierType;

    /**
     * 收款方式(1: 现结, 2: 到付, 3: 分期付款)
     */
    private Byte paymentType;

    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * 联系电话
     */
    private String contactTel;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人id
     */
    private Long creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private Date deleteTime;
}
