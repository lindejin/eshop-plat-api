package com.eshop.entity.customer;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 客户地址表
 * </p>
 *
 * @author customer
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("customer_address")
public class CustomerAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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
}
