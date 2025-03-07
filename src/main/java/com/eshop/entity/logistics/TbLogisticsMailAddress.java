package com.eshop.entity.logistics;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 物流方式与邮寄地址关联表
 * </p>
 *
 * @author logistics
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_logistics_mail_address")
public class TbLogisticsMailAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 物流方式
     */
    private Long logisticsModeId;

    /**
     * 寄件英文地址
     */
    private Long mailAddressEnId;

    /**
     * 寄件中文地址
     */
    private Long mailAddressCnId;
}
