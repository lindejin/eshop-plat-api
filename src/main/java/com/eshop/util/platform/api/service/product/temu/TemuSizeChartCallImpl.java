package com.eshop.util.platform.api.service.product.temu;

import com.eshop.util.platform.api.client.temu.TemuApiInvoker;
import com.eshop.util.platform.api.service.product.temu.dto.TemuSizeChartGetReqDTO;
import com.eshop.util.platform.api.service.product.temu.vo.TemuSizeChartGetRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class TemuSizeChartCallImpl implements TemuSizeChartCall {

    @Resource
    private TemuApiInvoker temuApiInvoker;

    @Override
    public TemuSizeChartGetRespVO sizeChartGet(TemuAppClientDTO temuAcDTO, TemuSizeChartGetReqDTO reqDTO) throws Exception {
        String type = "bg.goods.sizecharts.get";
        return temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuSizeChartGetRespVO.class,
                reqDTO
        );
    }
}
