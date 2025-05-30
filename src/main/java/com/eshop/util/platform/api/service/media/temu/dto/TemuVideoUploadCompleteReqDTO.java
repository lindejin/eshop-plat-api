package com.eshop.util.platform.api.service.media.temu.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuVideoUploadCompleteReqDTO {

    //参数名称	类型	是否必须	说明
    //content_md5 	String 	否 	当前大文件的md5，用于违规资源拦截检测
    private String content_md5;
    //sign 	String 	是 	3中获取的文件上传Sign
    private String sign;

}
