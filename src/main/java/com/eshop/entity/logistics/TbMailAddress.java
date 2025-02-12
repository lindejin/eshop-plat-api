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
 * 寄件地址
 * </p>
 *
 * @author logistics
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_mail_address")
public class TbMailAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String mailingName;

    /**
     * 联系人
     */
    private String linkman;

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
     * 邮编
     */
    private String postcode;

    /**
     * 固定电话
     */
    private String telephone;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司传真
     */
    private String companyFax;

    /**
     * 邮箱
     */
    private String mailbox;

    /**
     * 是否启用(1:启用,2:未启用)
     */
    private Byte addressStatus;

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
}
