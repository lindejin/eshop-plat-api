package com.eshop.util.platform.api.service.product.temu.dto.add;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductWhExtAttrReqDTO {

    //productOriginCertFiles	LIST	否	货品产地证明文件，全托管、非中国大陆产地时必填，目前仅支持1个文件
    //outerGoodsUrl	STRING	是	站外商品链接
    //productOrigin	OBJECT	是	货品产地

    private List<TemuGoodsAddProductWhExtAttrProductOriginCertFileReqDTO> productOriginCertFiles;
    private String outerGoodsUrl;
    private TemuGoodsAddProductOriginReqDTO productOrigin;
}
