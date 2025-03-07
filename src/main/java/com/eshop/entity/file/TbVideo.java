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
 * 视频
 * </p>
 *
 * @author file
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_video")
public class TbVideo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 原文件名称(包含文件类型)
     */
    private String originalName;

    /**
     * minio图片访问地址
     */
    private String minioUrl;

    /**
     * 文件大小(字节 / b)
     */
    private Long fileSize;

    /**
     * 视频时长(秒 / s)
     */
    private Long videoDuration;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 创建人id
     */
    private Long creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 删除时间
     */
    private Date deleteTime;
}
