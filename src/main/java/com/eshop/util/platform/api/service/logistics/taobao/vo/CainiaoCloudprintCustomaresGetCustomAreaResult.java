package com.eshop.util.platform.api.service.logistics.taobao.vo;

import java.util.List;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 16:51
 **/
@lombok.Getter
@lombok.Setter
public class CainiaoCloudprintCustomaresGetCustomAreaResult {
    //字段名	类型	示例值	说明
    //custom_area_id	Number	1024	自定义区id
    //custom_area_url	String	"http://cloudprint.cainiao.com/xxx"	自定义区url
    //keys	KeyResult[]	keys	模板的keys

    //
    private Long custom_area_id;
    private String custom_area_url;
    private List<CainiaoCloudprintCustomaresGetKeyResult> keys;
}
