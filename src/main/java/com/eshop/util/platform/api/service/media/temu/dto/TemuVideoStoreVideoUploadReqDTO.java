package com.eshop.util.platform.api.service.media.temu.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuVideoStoreVideoUploadReqDTO {

    //参数名称	类型	是否必须	说明
    //file 	File 	是 	视频文件
    //create_media 	Boolean 	是 	固定值，true
    private Boolean create_media;
    //content_md5 	String 	否 	文件MD5值，用于校验实际收到的数据和发起方本地的数据是否一致
    private String content_md5;
    //sign 	String 	是 	1中获取的文件上传Sig
    private String sign;
}
