package com.eshop.entity.file;

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
 * 面单信息
 * </p>
 *
 * @author file
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_face_sheet")
public class TbFaceSheet implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 运单号/货运单号
     */
    private String waybillNo;

    /**
     * 文件名(包含文件类型)
     */
    private String fileName;

    /**
     * 原文件名称(包含文件类型)
     */
    private String originalName;

    /**
     * 相对路径/资源路径
     */
    private String relativePath;

    /**
     * 绝对路径
     */
    private String absolutePath;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 删除时间
     */
    private Date deleteTime;
}
