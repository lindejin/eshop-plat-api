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
 * 加工sku信息
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_process_sku")
public class TbProcessSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商户_id
     */
    private Long merchantId;

    /**
     * 批次号
     */
    private Long batchNo;

    /**
     * sku编码
     */
    private String mainSkuCode;

    /**
     * 成品条形编码
     */
    private Long mainBarCode;

    /**
     * 成品条形编码(新)
     */
    private Long mainBarCodeNew;

    /**
     * sku加工状态(1-: 印花失败,1: 待开始, 2: 待印花, 3: 已完成)
     */
    private Byte processStatus;

    /**
     * 小篮子编号
     */
    private Long smallBasketCode;

    /**
     * 仓库_id
     */
    private Long depotId;

    /**
     * 款式sku编码
     */
    private String styleSkuCode;

    /**
     * 款式条形编码
     */
    private Long styleBarCode;

    /**
     * 备注
     */
    private String remark;

    /**
     * pp_id
     */
    private Long ppId;

    /**
     * ppp_id
     */
    private Long pppId;

    /**
     * 素材序号
     */
    private String psIndex;

    /**
     * 创建人id
     */
    private Long createrId;

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

    /**
     * 是否成品匹配(1: 是, 2: 否)
     */
    private Byte isFinal;
}
