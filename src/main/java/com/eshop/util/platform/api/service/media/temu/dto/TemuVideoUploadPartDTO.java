package com.eshop.util.platform.api.service.media.temu.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuVideoUploadPartDTO {

    private byte[] partFile;
    private String fileParam;
    private String fileName;

    private String sign;
    private String contentMd5;
    private String partNum;

}
