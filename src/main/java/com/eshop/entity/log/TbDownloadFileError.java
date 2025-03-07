package com.eshop.entity.log;

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
 * 文件下载失败记录
 * </p>
 *
 * @author log
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_download_file_error")
public class TbDownloadFileError implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 关联编码
     */
    private String joinCode;

    /**
     * 关联类型(1: 主商品主图, 2: 主商品附图, 3: sku图片)
     */
    private Byte joinType;

    /**
     * 下载地址
     */
    private String downloadUrl;

    /**
     * 存储路径(绝对路径)
     */
    private String storagePath;

    /**
     * 下载失败次数
     */
    private Long gamesLost;

    /**
     * 失败时间(上一次)
     */
    private Date loseTime;

    /**
     * 是否已下载(1: 是, 2: 否)
     */
    private Byte isDownload;
}
