package com.eshop.service.api.marketplace.biz.order.normal.domain.serivce.impl;


import com.eshop.entity.base.PlatformSyncInfoResponseVO;
import com.eshop.entity.base.ShopContextVO;
import com.eshop.entity.order.TbOrder;
import com.eshop.service.api.marketplace.biz.order.normal.domain.serivce.OrderSyncCustomerService;
import com.eshop.util.ExceptionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ldj
 * @date 2023/12/8 10:57
 * @Description: 订单同步 客户处理
 * @Version 1.0
 */
@Service
public class OrderSyncCustomerServiceImpl implements OrderSyncCustomerService {

//    @Resource
//    private CustomerServiceUtils customerServiceUtils;

    private final Lock lock = new ReentrantLock();

    /**
     * 客户加工
     */
    @Override
    public void customerProcess(ShopContextVO shopContextVO, List<PlatformSyncInfoResponseVO<TbOrder>> poList) throws Exception {
        //加锁
        lock.lock();
        try {
//            //客户信息查询
//            Map<String, CustomerBaseVO> customerBaseMap = getCustomerBaseMap(shopContextVO, poList);
//            //客户信息 新增处理
//            List<TbCustomerBase> infoAdd = getAddCustomerBaseDOS(poList, customerBaseMap);
//            //新增
//            if (CollectionUtils.isNotEmpty(infoAdd)) {
//                //将 infoAdd 集合中的元素按照 buyerId 进行排序，并且确保每个 buyerId 值只出现一次。
//                infoAdd = infoAdd.stream().collect(Collectors.collectingAndThen(
//                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(TbCustomerBase::getBuyerId))), ArrayList::new));
//                customerServiceUtils.getCustomerBaseInfo(infoAdd);
//            }
        } catch (Exception e) {
            throw new RuntimeException(ExceptionUtils.exToString(e));
        } finally {
            lock.unlock();
        }
    }

//    /**
//     * 客户信息查询
//     */
//    private Map<String, CustomerBaseVO> getCustomerBaseMap(ShopContextVO shopContextVO, List<PlatformSyncInfoResponseVO<TbOrder>> poList) throws Exception {
//        //订单信息
//        List<TbOrder> orders = poList.stream().map(PlatformSyncInfoResponseVO::getInfo).collect(Collectors.toList());
//        //平台id
//        Long platformIdQ = shopContextVO.getPlatformId();
//        //客户信息
//        List<FindOrderCustomer> focs = new ArrayList<>();
//        for (TbOrder order : orders) {
//            Long platformId = order.getPlatformId();
//            TbOrderBuyerInfo buyerInfo = order.getBuyerInfo();
//            if (buyerInfo == null) {
//                continue;
//            }
//            FindOrderCustomer foc = new FindOrderCustomer();
//            foc.setPlatformId(platformId);
//            foc.setBuyerId(buyerInfo.getBuyerId());
//            foc.setBuyerNickName(buyerInfo.getBuyerName());
//            focs.add(foc);
//        }
//        //客户信息查询
//        Map<String, CustomerBaseVO> customerBaseMap = customerServiceUtils.getCustomerBaseMap(platformIdQ, focs);
//        return customerBaseMap;
//    }

//    /**
//     * 客户信息 新增处理
//     */
//    private List<TbCustomerBase> getAddCustomerBaseDOS(List<PlatformSyncInfoResponseVO<TbOrder>> poList, Map<String, CustomerBaseVO> customerBaseMap) {
//        //订单信息
//        List<TbOrder> orders = poList.stream().map(PlatformSyncInfoResponseVO::getInfo).collect(Collectors.toList());
//        //客户信息 新增处理
//        List<TbCustomerBase> infoAdd = new ArrayList<>();
//        for (TbOrder order : orders) {
//            Long platformId = order.getPlatformId();
//            TbOrderBuyerInfo buyerInfo = order.getBuyerInfo();
//            if (buyerInfo == null) {
//                continue;
//            }
//            CustomerBaseVO customerBase = customerServiceUtils.getCustomerBase(platformId, buyerInfo, customerBaseMap);
//            if (customerBase == null) {
//                TbCustomerBase info = customerServiceUtils.getCustomerBaseInfo(platformId, buyerInfo);
//                infoAdd.add(info);
//            } else {
//                order.setCustomerBase(customerBase);
//            }
//        }
//        return infoAdd;
//    }

}
