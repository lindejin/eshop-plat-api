package com.eshop.api4;

import com.alibaba.fastjson.JSON;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.platform.call.order.temu.ship.TemuOrderShipCall;
import com.eshop.util.platform.call.order.temu.ship.dto.TemuOrderShipPackageGetReqDTO;
import com.eshop.util.platform.call.order.temu.ship.dto.TemuOrderShipPackingMatchReqDTO;
import com.eshop.util.platform.call.order.temu.ship.dto.TemuOrderShipV2GetReqDTO;
import com.eshop.util.platform.call.order.temu.ship.vo.*;
import com.eshop.util.shop.PlatformAppClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@SpringBootTest
public class TemuOrderShipCallTest {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbShopService shopService;

    @Resource
    private TemuOrderShipCall temuOrderShipCall;

    @Test
    void packingMatch() throws Exception {
        String orderNo = "WB2508071121432";
        Long shopId = 3258L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "CN";
        TemuAppClientDTO temuAcDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);


        TemuOrderShipV2GetReqDTO shipOrderDTO = new TemuOrderShipV2GetReqDTO();
        shipOrderDTO.setPageNo(1);
        shipOrderDTO.setPageSize(100);
        shipOrderDTO.setSubPurchaseOrderSnList(Arrays.asList(orderNo));
        TemuOrderShipV2GetRespVO shipOrder = temuOrderShipCall.v2Get(temuAcDTO, shipOrderDTO);

        System.out.println(shipOrder.getRespBody());
        TemuOrderShipV2GetVO getVO = Optional.ofNullable(shipOrder)
                .map(TemuOrderShipV2GetRespVO::getResult)
                .map(TemuOrderShipV2GetResultVO::getList)
                .filter(list -> !list.isEmpty())  // 确保列表不为空
                .map(list -> list.get(0))
                .orElse(null);

//        TemuOrderShipV2GetVO getVO = shipOrder.getResult().getList().get(0);
        if (getVO == null) {
            throw new RuntimeException("v2Get异常!!orderNo:" + orderNo + "," + shipOrder.getRespBody());
        }
        String deliveryOrderSn = getVO.getDeliveryOrderSn();

        TemuOrderShipPackingMatchReqDTO reqDTO  = new TemuOrderShipPackingMatchReqDTO();
        reqDTO.setDeliveryOrderSnList(Collections.singletonList(deliveryOrderSn));
        TemuOrderShipPackingMatchRespVO temuOrderShipPackingMatchRespVO = temuOrderShipCall.packingMatch(temuAcDTO, reqDTO);
        System.out.println(temuOrderShipPackingMatchRespVO.getRespBody());

        String msg = temuOrderShipPackingMatchRespVO.getErrorMsg();
        if (StringUtils.isNotBlank(msg)|| msg.contains("存在未打印打包标签的发货单")) {
            log.error(temuOrderShipPackingMatchRespVO.getRespBody());
            throw new RuntimeException(msg);
        }
    }

    @Test
    void v2Get2() throws Exception {
        String orderNo = "WB2508055677566";
        Long shopId = 3258L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "CN";
        TemuAppClientDTO temuAcDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

        List<TemuPurchasePackageVO> packageVOList = getTemuPurchasePackageVOMap(orderNo, temuAcDTO);

        System.out.println(JSON.toJSON(packageVOList));
    }

    private List<TemuPurchasePackageVO> getTemuPurchasePackageVOMap(String orderNo, TemuAppClientDTO temuAcDTO) throws Exception {


        TemuOrderShipV2GetReqDTO shipOrderDTO = new TemuOrderShipV2GetReqDTO();
        shipOrderDTO.setPageNo(1);
        shipOrderDTO.setPageSize(100);
        shipOrderDTO.setSubPurchaseOrderSnList(Arrays.asList(orderNo));
        TemuOrderShipV2GetRespVO shipOrder = temuOrderShipCall.v2Get(temuAcDTO, shipOrderDTO);

        System.out.println(shipOrder.getRespBody());
        TemuOrderShipV2GetVO getVO = Optional.ofNullable(shipOrder)
                .map(TemuOrderShipV2GetRespVO::getResult)
                .map(TemuOrderShipV2GetResultVO::getList)
                .filter(list -> !list.isEmpty())  // 确保列表不为空
                .map(list -> list.get(0))
                .orElse(null);

//        TemuOrderShipV2GetVO getVO = shipOrder.getResult().getList().get(0);
        if (getVO == null) {
            throw new RuntimeException("v2Get异常!!orderNo:" + orderNo + "," + shipOrder.getRespBody());
        }
        String deliveryOrderSn = getVO.getDeliveryOrderSn();
        List<TemuOrderShipV2GetPackageVO> packageList = getVO.getPackageList();
        List<TemuOrderShipV2GetPackageDetailVO> packageDetailList = getVO.getPackageDetailList();


        TemuOrderShipPackageGetReqDTO reqDTO = new TemuOrderShipPackageGetReqDTO();
        reqDTO.setDeliveryOrderSn(deliveryOrderSn);
        TemuOrderShipPackageGetRespVO respVO = temuOrderShipCall.packageGet(temuAcDTO, reqDTO);

        System.out.println(respVO.getRespBody());
        List<TemuOrderShipPackageGetPackageInfoVO> packageInfoVOS = Optional.ofNullable(respVO).map(TemuOrderShipPackageGetRespVO::getResult).map(TemuOrderShipPackageGetResultVO::getPackageInfo).orElse(null);
        if (packageInfoVOS == null) {
            throw new RuntimeException("packageGet异常!!orderNo:" + orderNo + "," + respVO.getRespBody());
        }

        Map<String, TemuPurchasePackageVO> packageVOAllMap = new HashMap<>();
        for (TemuOrderShipPackageGetPackageInfoVO packageInfoVO : packageInfoVOS) {
            Long productSkuId = packageInfoVO.getPackageDetails().get(0).getProductSkuId();

            TemuPurchasePackageVO packageVO = new TemuPurchasePackageVO();
            packageVO.setPackageSn(packageInfoVO.getPackageSn());
            packageVO.setProductSkcId(packageInfoVO.getProductSkcId());
            packageVO.setNum(packageInfoVO.getSkcNum());
            packageVO.setProductSkuId(productSkuId);

            packageVOAllMap.put(packageInfoVO.getPackageSn(), packageVO);
        }


        Map<String, TemuPurchasePackageVO> packageVOMap = new HashMap<>();

        for (TemuOrderShipV2GetPackageVO packageVO : packageList) {
            String packageSn = packageVO.getPackageSn();
            Integer skcNum = packageVO.getSkcNum();

            TemuPurchasePackageVO packageVOTemp = packageVOAllMap.get(packageSn);
            if (packageVOTemp == null) {
                throw new RuntimeException("无法获取包裹详情异常!!orderNo:" + orderNo + ",packageSn:" + packageSn);
            }

            packageVOMap.put(packageSn, packageVOTemp);
        }

        return new ArrayList<>(packageVOMap.values());
    }
}
