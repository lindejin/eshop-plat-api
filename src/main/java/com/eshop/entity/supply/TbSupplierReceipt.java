package com.eshop.entity.supply;

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
 * 供应商收款账号信息
 * </p>
 *
 * @author supply
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_supplier_receipt")
public class TbSupplierReceipt implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 供应商_id
     */
    private Integer supplierId;

    /**
     * 收款账号类型(1: 银行卡, 2: 1688, 3: 微信, 4: 支付宝, 5: QQ, 6: 拼多多, 7: 其他)
     */
    private Byte receiptType;

    /**
     * 收款账号 (二维码跟收款账号必填其一)
     */
    private String receiptAccount;

    /**
     * 收款二维码图片id (二维码跟收款账号必填其一)
     */
    private Integer imgId;

    /**
     * 是否为默认收款信息(1: 是, 2: 否)
     */
    private Byte isDefault;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private LocalDateTime deleteTime;
}
