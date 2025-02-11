package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 17:19
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeEcowarehouseReverseOrderUploadDTO {
    //        request.addFileParameter("file_stream",new FileItem("/Users/D ocuments/book.jpg"));
    private byte[] file_stream;
    //file_name	String	是	文件名
    private String file_name;
    //        request.addApiParameter("warehouse_customer_id", "123123123123");
    private String warehouse_customer_id;
}
