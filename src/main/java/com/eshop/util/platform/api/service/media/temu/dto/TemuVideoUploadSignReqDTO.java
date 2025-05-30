package com.eshop.util.platform.api.service.media.temu.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuVideoUploadSignReqDTO {
    //参数名称	参数类型	是否必须	说明
    //  isBigVideo 	BOOLEAN 	是 	需上传文件是否大于20MB
    private Boolean isBigVideo;
    //  contentType 	STRING 	是 	文件对应的contentType，且必须为视频类型
    private String contentType;
}
