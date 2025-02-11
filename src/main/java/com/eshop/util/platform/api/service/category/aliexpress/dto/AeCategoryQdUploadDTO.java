package com.eshop.util.platform.api.service.category.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/27 18:02
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeCategoryQdUploadDTO {

    //名称	类型	是否必须	描述
    //upload_meta	Object	是	上传数据配置信息
    private String upload_meta;
    //file_data	byte[]	是	文件字节数组
    private byte[] file_data;
    //file_name	String	是	文件名
    private String file_name;
}
