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
 * 面单任务运行日志
 * </p>
 *
 * @author order
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_waybill_face_sheet_task")
public class TbWaybillFaceSheetTask implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 物流方式
     */
    private Long modeId;

    /**
     * 运单号/货运单号
     */
    private String waybillNo;

    /**
     * 下载地址
     */
    private String downloadUrl;

    /**
     * 下载参数
     */
    private String downloadParams;

    /**
     * 是否下载(1: 是, 2:否)
     */
    private Byte isDownload;

    /**
     * 下载时间
     */
    private Date downloadTime;

    /**
     * 创建人
     */
    private Long createrId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否删除(1: 是, 2:否)
     */
    private Byte isDelete;

    /**
     * 删除人
     */
    private Long deleteId;

    /**
     * 删除时间
     */
    private Date deleteTime;
}
