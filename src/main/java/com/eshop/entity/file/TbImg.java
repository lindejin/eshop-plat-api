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
 * 图片空间
 * </p>
 *
 * @author file
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_img")
public class TbImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分组id
     */
    private Long groupingId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 原文件名称(包含文件类型)
     */
    private String originalName;

    /**
     * minio_图片地址
     */
    private String minioUrl;

    /**
     * minio_缩略图图片地址
     */
    private String minioThuUrl;

    /**
     * 原url地址(图片为url地址下载类型的,被下载地址)
     */
    private String originalUrl;

    /**
     * 图片来源类型(1:本地上传,2:url地址下载)
     */
    private Byte sourceType;

    /**
     * 是否共享(1:是, 2:否)
     */
    private Byte isShare;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 删除时间
     */
    private Date deleteTime;
}
