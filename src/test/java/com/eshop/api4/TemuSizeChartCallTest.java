package com.eshop.api4;

import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.product.temu.TemuSizeChartCall;
import com.eshop.util.platform.api.service.product.temu.dto.TemuSizeChartGetReqDTO;
import com.eshop.util.platform.api.service.product.temu.vo.TemuSizeChartGetRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class TemuSizeChartCallTest {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbShopService shopService;

    @Resource
    private TemuSizeChartCall temuSizeChartCall;

    @Test
    void modelInfoGet() throws Exception {
        Long shopId = 3611L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "CN";
        TemuAppClientDTO temuAcDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);


        TemuSizeChartGetReqDTO reqDTO = new TemuSizeChartGetReqDTO();
        reqDTO.setCatId(30467L);
        reqDTO.setOffset(0L);
        reqDTO.setPageSize(500L);
        TemuSizeChartGetRespVO respVO = temuSizeChartCall.sizeChartGet(temuAcDTO, reqDTO);
        System.out.println(respVO.getRespBody());
    }
}
