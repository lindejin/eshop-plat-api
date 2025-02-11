package com.eshop.util.platform.api.service.media.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/28 10:59
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AePhotoBankUploadImageDTO {
    private byte[] file_data;
    //request.addApiParameter("file_name", "0");
    private String src_file_name;
    //request.addApiParameter("group_id", "0");
    private String group_id;
}
