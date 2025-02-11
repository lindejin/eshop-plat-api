package com.eshop.entity.logistics;

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
 * 回邮地址
 * </p>
 *
 * @author logistics
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_mailing_address")
public class TbMailingAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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
}
