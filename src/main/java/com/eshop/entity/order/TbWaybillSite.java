package com.eshop.entity.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 运单地址 / 收货地址
 * </p>
 *
 * @author order
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_waybill_site")
public class TbWaybillSite implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 运单id
     */
    private Integer waybillId;

    /**
     * 买家姓	
     */
    private String lastName;

    /**
     * 买家名
     */
    private String firstName;

    /**
     * 手机号(包含国家区号)
     */
    private String mobile;

    /**
     * 座机(包含国家区号)
     */
    private String phone;

    /**
     * 邮编
     */
    private String postcode;

    /**
     * 国家
     */
    private String country;

    /**
     * 省/州
     */
    private String provinceOrState;

    /**
     * 城市
     */
    private String city;

    /**
     * 详细地址
     */
    private String detailedAddress;

    /**
     * 备用地址
     */
    private String reserveAddress;

    /**
     * 地址状态(0:原收件地址.1:指定地址)
     */
    private Byte siteStatus;

    /**
     * 收货人的门牌号码
     */
    private String consigneeDoorNo;
}
