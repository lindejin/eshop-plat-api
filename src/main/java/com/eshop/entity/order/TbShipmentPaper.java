package com.eshop.entity.order;

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
 * 发货单纸张信息表
 * </p>
 *
 * @author order
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_shipment_paper")
public class TbShipmentPaper implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 主表ID
     */
    private Long majorId;

    /**
     * 平台纸张号码
     */
    private String platPaperNo;

    /**
     * 平台纸张类型
     */
    private Byte platPaperType;

    /**
     * 平台纸张大小
     */
    private String platPaperSize;

    /**
     * 是否一起打印条形码，0表示否，1表示是
     */
    private Byte printBarcode;

    /**
     * 送仓箱数
     */
    private Long warehouseBoxCount;

    /**
     * pdf_size
     */
    private String pdfSize;

    /**
     * 下载地址
     */
    private String fileUrl;

    /**
     * file_id
     */
    private Long fileId;

    /**
     * 创建人
     */
    private Long creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 扩展字段1
     */
    private String extField1;

    /**
     * 扩展字段2
     */
    private String extField2;

    /**
     * 扩展字段3
     */
    private String extField3;
}
