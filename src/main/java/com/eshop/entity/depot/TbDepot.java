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
 * 仓库
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_depot")
public class TbDepot implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 仓库名称
     */
    private String depotName;

    /**
     * 是否启用(1:启用,2:停用)
     */
    private Byte depotStatus;

    /**
     * wms系统租户与仓库绑定记录的Id,就是def_tenant_depot表的Id
     */
    private Long wmsDepotId;

    /**
     * 仓库类型(1: 常规发货仓库, 2: 无需采购发货仓库)
     */
    private Byte depotType;

    /**
     * 寄件地址
     */
    private Long mailId;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 联系_手机号
     */
    private String phone;

    /**
     * 邮编
     */
    private Long postcode;

    /**
     * 国家
     */
    private String country;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String zone;

    /**
     * 详细地址
     */
    private String detailedAddress;

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
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private Date deleteTime;

    /**
     * 国家id
     */
    private Long countryId;

    /**
     * 快递投递类型1:送货到快递站,2:上门取件
     */
    private Long deliveryType;

    /**
     * 语言
     */
    private String language;
}
