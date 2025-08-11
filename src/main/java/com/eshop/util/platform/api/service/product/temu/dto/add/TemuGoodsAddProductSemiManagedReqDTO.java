package com.eshop.util.platform.api.service.product.temu.dto.add;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSemiManagedReqDTO {

    //semiLanguageStrategy	INTEGER	否	半托管-素材语种策略
    private Long semiLanguageStrategy;
    //bindSiteIds	LIST	是	绑定站点列表
    private List<String> bindSiteIds;
    //semiManagedSiteMode	INTEGER	否	半托管站点售卖模式，1:泛欧售卖，全欧洲售卖（包含未开站），2:非泛欧售卖，支持选择欧洲站点（包含未开站）
    private Long semiManagedSiteMode;
}
