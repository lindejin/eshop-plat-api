package com.eshop.util.platform.api.service.media.temu.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuVideoInitReqDTO {

    //参数名称	类型	是否必须	说明
    //create_media 	Boolean 	是 	固定值，true
    private Boolean create_media;
    //content_type 	String 	是 	文件对应的contentType,且必须为视频类型，eg：video/quicktime、video/mp4等
    private String content_type;
    //sign 	String 	是 	1中获取的文件上传Sign
    private String sign;

}
