package com.eshop.util.platform.api.service.media.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/28 10:55
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AePhotoBankUploadTempImageDTO {
    //file_data	byte[]	是	文件字节数组
    private byte[] file_data;
    //file_name	String	是	文件名
    private String file_name;
}
