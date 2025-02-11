package com.eshop.entity.file;

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
 * 下载列表
 * </p>
 *
 * @author file
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_produce_export_file")
public class TbProduceExportFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务状态(1: 生成文件中, 2: 生成成功, 3: 生成失败)
     */
    private Byte taskStatus;

    /**
     * 任务参数(前端展示,就是把属性转换为文本)
     */
    private String taskParam;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件路径(不带 filePath)
     */
    private String filePath;

    /**
     * 执行参数_json,重复执行参数
     */
    private String taskParamJson;

    /**
     * 错误原因
     */
    private String errorReason;

    /**
     * 创建人id
     */
    private Integer creatorId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private LocalDateTime deleteTime;

    /**
     * 生成时间
     */
    private LocalDateTime generateTime;

    /**
     * minio_图片地址
     */
    private String minioUrl;
}
