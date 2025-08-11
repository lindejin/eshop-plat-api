package com.eshop.util.platform.api.service.product.temu.dto.add;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductGuideFileReqDTO {

    //fileName	STRING	是	文件名称
    //pdfMaterialId	INTEGER	是	pdf文件id
    //languages	LIST	是	语言

    private String fileName;
    private Long pdfMaterialId;
    private List<String> languages;
}
