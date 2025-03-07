package com.eshop.service.api.marketplace.biz.order.normal.domain.serivce.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eshop.api.modules.service.api.marketplace.order.domain.order.domain.serivce.OrderSyncPromotionOrderService;
import com.eshop.api.modules.task.crm.PlatformCustomerRecord;
import com.eshop.api.modules.util.service.CustomerServiceUtils;
import com.eshop.db.customer.service.CustomerImportInfoService;
import com.eshop.db.customer.service.CustomerInfoService;
import com.eshop.db.order.service.CustomerBaseService;
import com.eshop.modal.modal.eshop_customer.CustomerAddress;
import com.eshop.modal.modal.eshop_customer.CustomerImportInfo;
import com.eshop.modal.modal.eshop_customer.CustomerInfo;
import com.eshop.modal.modal.eshop_order.TbCustomerBase;
import com.eshop.modal.modal.eshop_order.TbOrder;
import com.eshop.modal.modal.eshop_order.TbOrderBuyerInfo;
import com.eshop.modal.modal.eshop_order.TbWaybillSite;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ldj
 * @date 2023/12/9 14:45
 * @Description: 推广订单处理 服务类
 * @Version 1.0
 */
@Service
public class OrderSyncPromotionOrderServiceImpl implements OrderSyncPromotionOrderService {

    @Resource
    private CustomerBaseService customerBaseService;

    @Resource
    private CustomerInfoService customerInfoService;

    @Resource
    private CustomerImportInfoService customerImportInfoService;

    @Resource
    private CustomerServiceUtils customerServiceUtils;

    @Resource
    private PlatformCustomerRecord platformCustomerRecord;

    /**
     * 推广订单处理
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public void promotionOrderProcessor(TbOrder order, TbOrderBuyerInfo orderBuyer, TbWaybillSite tbWaybillSite, Long creatorId) throws Exception {
        //erp 平台id
        Long platformIdQ = order.getPlatformId();
        //买家第三方平台id
        String buyerId = orderBuyer.getBuyerId();
        //买家昵称（别名）
        String buyerName = orderBuyer.getBuyerName();

        //客户信息处置 兼容老数据
        if (order.getCustomerBase() != null) {
            Integer customerType = order.getCustomerBase().getCustomerType();
            if (customerType != null && customerType == -1) {
                //设置订单类型 耍单订单
                order.setOrderType(2);
            }
        }

        //查询推广客户信息 新结构
        CustomerImportInfo ciiNewDO = getCustomerImportInfo(platformIdQ, buyerName);
        if (ciiNewDO != null) {
            //设置订单类型 推广订单
            order.setOrderType(2);
        }

        //客户信息处置 兼容旧数据
        TbCustomerBase cbOldVO = getCustomerBaseVO(platformIdQ, buyerId);
        if (cbOldVO == null) {
            //(旧)客户信息 新增处理
            Long platformId = order.getPlatformId();
            TbCustomerBase info = customerServiceUtils.getCustomerBaseInfo(platformId, orderBuyer);
            customerBaseService.insertData(info);
        }

        //查询客户信息 新结构
        CustomerInfo ciDO = getCustomerInfo(platformIdQ, buyerId);
        if (ciDO == null) {
            addCiDO(platformIdQ, buyerId, buyerName, tbWaybillSite, creatorId);
        }

    }

    /**
     * 旧数据获取客户信息
     */
    private TbCustomerBase getCustomerBaseVO(Long platformIdQ, String buyerId) throws Exception {
        //客户信息
        TbCustomerBase cbFind = new TbCustomerBase();
        cbFind.setPlatformId(platformIdQ);
        cbFind.setBuyerId(buyerId);
        List<TbCustomerBase> cbDOS = customerBaseService.selectByExample(cbFind, 1, 1, null, null);
        if (CollectionUtils.isNotEmpty(cbDOS)) {
            return cbDOS.get(0);
        }
        return null;
    }

    /**
     * 查询推广客户信息 新结构
     */
    private CustomerImportInfo getCustomerImportInfo(Long platformIdQ, String buyerName) {
        // 创建QueryWrapper对象
        QueryWrapper<CustomerImportInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("platform_id", platformIdQ);
        queryWrapper.eq("buyer_name", buyerName);
        // 执行查询
        List<CustomerImportInfo> ciiDO = customerImportInfoService.list(queryWrapper);

        if (CollectionUtils.isNotEmpty(ciiDO)) {
            return ciiDO.get(0);
        }
        return null;
    }

    /**
     * 查询客户信息 新结构
     */
    private CustomerInfo getCustomerInfo(Long platformIdQ, String platformCustomerId) {
        // 创建QueryWrapper对象
        QueryWrapper<CustomerInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("platform_id", platformIdQ);
        queryWrapper.eq("platform_customer_id", platformCustomerId);
        // 执行查询
        List<CustomerInfo> ciiDO = customerInfoService.list(queryWrapper);
        if (CollectionUtils.isNotEmpty(ciiDO)) {
            return ciiDO.get(0);
        }
        return null;
    }

    /**
     * 新增客户信息 新结构
     */
    private void addCiDO(Long platformIdQ, String buyerId, String buyerName, TbWaybillSite tbWaybillSite, Long creatorId) {
        CustomerInfo addCustomerInfo = new CustomerInfo();
        addCustomerInfo.setPlatformId(platformIdQ);
        addCustomerInfo.setPlatformCustomerId(buyerId);
        addCustomerInfo.setPlatformBuyerNickName(buyerName);
        addCustomerInfo.setPlatformAddressId(0L);
        addCustomerInfo.setCustomerCategoryId(0L);
        //来源 订单
        addCustomerInfo.setSourceType(1);
        addCustomerInfo.setCreateId(creatorId);
        addCustomerInfo.setUpdateId(creatorId);

        CustomerAddress customerAddress = getCustomerAddress(tbWaybillSite);

        platformCustomerRecord.saveCustomer(addCustomerInfo, customerAddress);
    }

    /**
     * 获取客户地址 新结构
     */
    private CustomerAddress getCustomerAddress(TbWaybillSite tbWaybillSite) {
        CustomerAddress ca = new CustomerAddress();
        ca.setFirstName(tbWaybillSite.getFirstName());
        ca.setLastName(tbWaybillSite.getLastName());
        ca.setMobile(tbWaybillSite.getMobile());
        ca.setPhone(tbWaybillSite.getPhone());
        ca.setPostcode(tbWaybillSite.getPostcode());
        ca.setCountry(tbWaybillSite.getCountry());
        ca.setProvinceOrState(tbWaybillSite.getProvinceOrState());
        ca.setCity(tbWaybillSite.getCity());
        ca.setDetailedAddress(tbWaybillSite.getDetailedAddress());
        ca.setReserveAddress(tbWaybillSite.getReserveAddress());
        return ca;
    }
}
