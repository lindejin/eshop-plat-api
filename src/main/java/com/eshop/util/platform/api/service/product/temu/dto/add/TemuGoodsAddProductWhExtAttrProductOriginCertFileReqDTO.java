package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductWhExtAttrProductOriginCertFileReqDTO {

    //fileName	STRING	是	文件名称，需要带文件扩展，eg: test.pdf
    //fileUrl	STRING	是	文件url，从bg.goods.file.upload上传，支持文件格式：['pdf', 'png', 'jpeg', 'jpg']，文件最大3MB

    private String fileName;
    private String fileUrl;
}
