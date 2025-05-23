package com.eshop.order;

import com.alibaba.fastjson.JSONObject;
import com.eshop.constant.ConstantPlatform;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.logistics.shopee.ShopeeLogisticsCall;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ApiShopeeLogisticsSyncServiceTest {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ShopeeLogisticsCall shopeeLogisticsCall;

    @Resource
    private ITbShopService iTbShopService;

    @Test
    void contextLoads() throws Exception {
        String orderNo = "250514TRD00R9V";
        String packageNumber = "OFG200919568263315";
        TbShop shopDO = iTbShopService.getById(1729L);
        ShopeeDownloadShippingDocumentDTO downloadDTO = getDownloadDTO(orderNo, packageNumber);

        ResponseEntity<byte[]> documentResult = downloadShippingDocument(shopDO, downloadDTO);

        // 2. 保存为 PDF 文件
        String outputPath = "C:/downloads/shipping_document.pdf";
        savePdfFromResponse(documentResult, outputPath);

    }

    /**
     * 将 ResponseEntity<byte[]> 保存为 PDF 文件
     * @param responseEntity 包含 PDF 数据的响应
     * @param outputPath 保存路径（如 "C:/downloads/shipping_document.pdf"）
     * @throws IOException 如果文件写入失败
     */
    public static void savePdfFromResponse(ResponseEntity<byte[]> responseEntity, String outputPath) throws IOException {
        if (responseEntity.getBody() == null || responseEntity.getBody().length == 0) {
            throw new IOException("PDF 数据为空");
        }

        Path path = Paths.get(outputPath);
        Files.createDirectories(path.getParent()); // 确保目录存在
        try (FileOutputStream fos = new FileOutputStream(outputPath)) {
            fos.write(responseEntity.getBody());
        }
    }
    /**
     * 装配下载参数DTO
     */
    private ShopeeDownloadShippingDocumentDTO getDownloadDTO(String orderNo, String packageNumber) {
        ShopeeDownloadShippingDocumentDTO parameterDTO = new ShopeeDownloadShippingDocumentDTO();
        parameterDTO.setOrderSn(orderNo);
        parameterDTO.setPackageNumber(packageNumber);
        return parameterDTO;
    }

    private ResponseEntity<byte[]> downloadShippingDocument(TbShop shopDO, ShopeeDownloadShippingDocumentDTO shDTO) {
        try {
            ShopeeAppClientDTO acDTO = platformAppClientUtils.getShopeeAppClientDTO(shopDO);
            ShopeeDownloadShippingDocumentReqDTO reqDTO = new ShopeeDownloadShippingDocumentReqDTO();
            reqDTO.setShipping_document_type(shDTO.getShippingDocumentType());
            List<ShopeeDownloadShippingDocumentItemDTO> order_list = new ArrayList<>();
            ShopeeDownloadShippingDocumentItemDTO itemDTO = new ShopeeDownloadShippingDocumentItemDTO();
            itemDTO.setOrder_sn(shDTO.getOrderSn());
            itemDTO.setPackage_number(shDTO.getPackageNumber());
            order_list.add(itemDTO);
            reqDTO.setOrder_list(order_list);
            return downloadShippingDocument(acDTO, reqDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<byte[]> downloadShippingDocument(ShopeeAppClientDTO dcDTO, ShopeeDownloadShippingDocumentReqDTO downloadShippingDocumentReqDTO) throws Exception {
        JSONObject businessDTO = getDownloadShippingDocumentReqDTO(downloadShippingDocumentReqDTO);
        return shopeeLogisticsCall.downloadShippingDocument(dcDTO, businessDTO);
    }

    /**
     * 下载面单 参数装配
     */
    private JSONObject getDownloadShippingDocumentReqDTO(ShopeeDownloadShippingDocumentReqDTO reqDTO) {
        JSONObject businessDTO = new JSONObject();
        //Name	Type	Required	Sample	Description
        //shipping_document_type	string	False	NORMAL_AIR_WAYBILL	The type of shipping document. Available values: NORMAL_AIR_WAYBILL,THERMAL_AIR_WAYBILL,NORMAL_JOB_AIR_WAYBILL,THERMAL_JOB_AIR_WAYBILL
        businessDTO.put("shipping_document_type", reqDTO.getShipping_document_type());
        //order_list	object[]	True		The list of orders you need to download it's shipping document.
        if (reqDTO.getOrder_list() != null && !reqDTO.getOrder_list().isEmpty()) {
            businessDTO.put("order_list", JSONObject.toJSON(reqDTO.getOrder_list()));
        }
        //  order_sn	string	True	201118BCKPJQQ8	Shopee's unique identifier for an order.
        //  package_number	string	False	2485710696837122445	Shopee's unique identifier for the package under an order. You should't fill the field with empty string when there is't a package number.
        return businessDTO;
    }
}
