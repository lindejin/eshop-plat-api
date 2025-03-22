package com.eshop.sync;

import com.alibaba.fastjson.JSONObject;
import com.eshop.sync.dto.*;
import com.eshop.sync.vo.*;
import com.eshop.util.platform.api.service.order.dhgate.DhGateOrderCall;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ldj
 * @date 2024/3/16 11:00
 * @Description: ...
 * @Version 1.0
 */
@Service
public class DhOrderCallServiceImpl implements DhOrderCallService {

    @Resource
    private DhGateOrderCall dhGateOrderCall;

    @Override
    public DhOrderListRespVO getOrderList(DhAppClientDTO dcDTO, DhOrderListReqDTO orderListReqDTO) throws Exception {
        JSONObject businessDto = getDhOrderListReqDTO(orderListReqDTO);
        String respBody = dhGateOrderCall.getOrderList(dcDTO, businessDto);
        DhOrderListRespVO respVO = new DhOrderListRespVO();
        respVO.setRespBody(respBody);
        return respVO;
    }

    @Override
    public DhOrderDetailRespVO getOrderDetail(DhAppClientDTO dcDTO, DhOrderDetailReqDTO orderDetailReqDTO) throws Exception {
        JSONObject businessDto = getDhOrderDetailReqDTO(orderDetailReqDTO);
        String respBody = dhGateOrderCall.getOrderDetail(dcDTO, businessDto);
        DhOrderDetailRespVO respVO = new DhOrderDetailRespVO();
        respVO.setRespBody(respBody);
        return respVO;
    }

    @Override
    public DhOrderProductListRespVO getOrderProductList(DhAppClientDTO dcDTO, DhOrderProductListReqDTO orderProductListReqDTO) throws Exception {
        JSONObject businessDto = getDhOrderProductListReqDTO(orderProductListReqDTO);
        String respBody = dhGateOrderCall.getOrderProductList(dcDTO, businessDto);
        DhOrderProductListRespVO respVO = new DhOrderProductListRespVO();
        respVO.setRespBody(respBody);
        return respVO;
    }

    @Override
    public DhOrderShipmentTrackingRespVO getOrderShipmentTracking(DhAppClientDTO dcDTO, DhOrderShipmentTrackingReqDTO orderShipmentTrackingReqDTO) throws Exception {
        JSONObject businessDto = getDhOrderShipmentTrackingReqDTO(orderShipmentTrackingReqDTO);
        String respBody = dhGateOrderCall.getOrderShipmentTracking(dcDTO, businessDto);
        DhOrderShipmentTrackingRespVO respVO = new DhOrderShipmentTrackingRespVO();
        respVO.setRespBody(respBody);
        return respVO;
    }

    @Override
    public DhOrderDisputeOpenListRespVO orderDisputeOpenListPage(DhAppClientDTO dcDTO, DhOrderDisputeOpenListReqDTO orderDisputeOpenListReqDTO) throws Exception {
        JSONObject businessDto = getDhOrderDisputeOpenListReqDTO(orderDisputeOpenListReqDTO);
        String respBody = dhGateOrderCall.orderDisputeOpenListPage(dcDTO, businessDto);
        DhOrderDisputeOpenListRespVO respVO = new DhOrderDisputeOpenListRespVO();
        respVO.setRespBody(respBody);
        return respVO;
    }

    @Override
    public DhOrderDisputeCloseListRespVO orderDisputeCloseListPage(DhAppClientDTO dcDTO, DhOrderDisputeCloseListReqDTO orderDisputeCloseListReqDTO) throws Exception {
        JSONObject businessDto = getDhOrderDisputeCloseListReqDTO(orderDisputeCloseListReqDTO);
        String respBody = dhGateOrderCall.orderDisputeCloseListPage(dcDTO, businessDto);
        DhOrderDisputeCloseListRespVO respVO = new DhOrderDisputeCloseListRespVO();
        respVO.setRespBody(respBody);
        return respVO;
    }

    @Override
    public DhOrderRefundListRespVO getOrderRefundList(DhAppClientDTO dcDTO, DhOrderRefundListReqDTO orderRefundListReqDTO) throws Exception {
        JSONObject businessDto = getDhOrderRefundListReqDTO(orderRefundListReqDTO);
        String respBody = dhGateOrderCall.orderRefundList(dcDTO, businessDto);
        DhOrderRefundListRespVO respVO = new DhOrderRefundListRespVO();
        respVO.setRespBody(respBody);
        return respVO;
    }

    @Override
    public DhOrderCanSendInvoiceRespVO canSendInvoice(DhAppClientDTO dcDTO, DhOrderCanSendInvoiceReqDTO orderCanSendInvoiceReqDTO) throws Exception {
        JSONObject businessDto = getDhOrderCanSendInvoiceReqDTO(orderCanSendInvoiceReqDTO);
        String respBody = dhGateOrderCall.canSendInvoice(dcDTO, businessDto);
        DhOrderCanSendInvoiceRespVO respVO = new DhOrderCanSendInvoiceRespVO();
        respVO.setRespBody(respBody);
        return respVO;
    }

    @Override
    public DhOrderSendInvoiceRespVO sendInvoice(DhAppClientDTO dcDTO, DhOrderSendInvoiceReqDTO orderSendInvoiceReqDTO) throws Exception {
        JSONObject businessDto = getDhOrderSendInvoiceReqDTO(orderSendInvoiceReqDTO);
        String respBody = dhGateOrderCall.sendInvoice(dcDTO, businessDto);
        DhOrderSendInvoiceRespVO respVO = new DhOrderSendInvoiceRespVO();
        respVO.setRespBody(respBody);
        return respVO;
    }

    private JSONObject getDhOrderListReqDTO(DhOrderListReqDTO orderListReqDTO) {
        JSONObject businessDto = new JSONObject();
        //请求参数
        //参数名称	参数类型	是否必须	取值说明	参数说明
        //endDate	String	必须	日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21	结束时间
        businessDto.put("endDate", orderListReqDTO.getEndDate());
        //orderNo	String	否	卖家后台能查看；示例值：1455953150	订单号
        businessDto.put("orderNo", orderListReqDTO.getOrderNo());
        //orderStatus	String	否	111000,订单取消;101003,等待买家付款;102001,买家已付款，等待平台确认;103001,等待发货;105001,买家申请退款，等待协商结果;105002,退款协议已达成;105003,部分退款后，等待发货;105004,买家取消退款申请;103002,已部分发货;101009,等待买家确认收货;106001,退款/退货协商中，等待协议达成;106002,买家投诉到平台;106003,协议已达成，执行中;102006,人工确认收货;102007,超过预定期限，自动确认收货;102111,交易成功;111111,交易关闭；示例值：101009,101003,多种状态时用英文逗号分隔，默认为空，查询所有订单	订单状态列表
        businessDto.put("orderStatus", orderListReqDTO.getOrderStatus());
        //buyerNickName	String	否	示例值：zhangsan	买家昵称
        businessDto.put("buyerNickName", orderListReqDTO.getBuyerNickName());
        //querytimeType	String	必须	按哪种时间类型查询订单列表，值：1、下单时间 ,2、付款时间,3、更新时间 仅支持此三种时间类型查询	查询时间类型
        businessDto.put("querytimeType", orderListReqDTO.getQuerytimeType());
        //startDate	String	必须	日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21	开始时间
        businessDto.put("startDate", orderListReqDTO.getStartDate());
        //itemCode	String	否	产品号在页面详情的URL中即可查看到；示例值：180366586	产品编号
        businessDto.put("itemCode", orderListReqDTO.getItemCode());
        //pageSize	int	必须	示例值：10,表示每页10条记录	每页记录数
        businessDto.put("pageSize", orderListReqDTO.getPageSize());
        //pageNo	int	必须	示例值：10,表示第10页（返回值中pages为总页数，若超过总页数，则返回最后一页数据。）	第几页
        businessDto.put("pageNo", orderListReqDTO.getPageNo());
        //deliveryNo	String	否	示例值：1Z68A9X70467731838	运单号
        businessDto.put("deliveryNo", orderListReqDTO.getDeliveryNo());
        return businessDto;
    }

    private JSONObject getDhOrderDetailReqDTO(DhOrderDetailReqDTO orderDetailReqDTO) {
        JSONObject businessDto = new JSONObject();
        //请求参数
        //参数名称	参数类型	是否必须	取值说明	参数说明
        //orderNo	String	必须	卖家后台登录能看到成交的订单号；示例值：1330312162	订单号
        businessDto.put("orderNo", orderDetailReqDTO.getOrderNo());
        return businessDto;
    }

    private JSONObject getDhOrderProductListReqDTO(DhOrderProductListReqDTO orderProductListReqDTO) {
        JSONObject businessDto = new JSONObject();
        //orderNo	String	必须	卖家后台登录能看到成交的订单号；示例值：1330312162	订单号
        businessDto.put("orderNo", orderProductListReqDTO.getOrderNo());
        return businessDto;
    }

    private JSONObject getDhOrderShipmentTrackingReqDTO(DhOrderShipmentTrackingReqDTO orderShipmentTrackingReqDTO) {
        JSONObject businessDto = new JSONObject();
        //请求参数
        //参数名称	参数类型	是否必须	取值说明	参数说明
        //trackno	String	必须		运单号
        businessDto.put("trackno", orderShipmentTrackingReqDTO.getTrackno());
        //shippingtype	String	必须		物流方式，如e-ulink等
        businessDto.put("shippingtype", orderShipmentTrackingReqDTO.getShippingtype());
        //language	String	必须		语言，只能是EN或CN
        businessDto.put("language", orderShipmentTrackingReqDTO.getLanguage());
        return businessDto;
    }

    private JSONObject getDhOrderDisputeOpenListReqDTO(DhOrderDisputeOpenListReqDTO orderDisputeOpenListReqDTO) {
        JSONObject businessDto = new JSONObject();
        //请求参数
        //参数名称	参数类型	是否必须	取值说明	参数说明
        //buyerNickName	String	否	示例值：zhangsan	买家昵称
        businessDto.put("buyerNickName", orderDisputeOpenListReqDTO.getBuyerNickName());
        //pageSize	int	必须	示例值：10,表示每页10条记录	每页记录数
        businessDto.put("pageSize", orderDisputeOpenListReqDTO.getPageSize());
        //orderNo	String	否	卖家后台能查看；示例值：1455953150	订单号
        businessDto.put("orderNo", orderDisputeOpenListReqDTO.getOrderNo());
        //disputeType	String	否	1、协议纠纷，2、平台纠纷，3、售后纠纷，默认全部纠纷中订单	纠纷类型
        businessDto.put("disputeType", orderDisputeOpenListReqDTO.getDisputeType());
        //pageNo	int	必须	示例值：10,表示第10页（返回值中pages为总页数，若超过总页数，则返回最后一页数据。）	第几页
        businessDto.put("pageNo", orderDisputeOpenListReqDTO.getPageNo());
        return businessDto;
    }

    private JSONObject getDhOrderDisputeCloseListReqDTO(DhOrderDisputeCloseListReqDTO orderDisputeCloseListReqDTO) {
        JSONObject businessDto = new JSONObject();
        //请求参数
        //参数名称	参数类型	是否必须	取值说明	参数说明
        //pageNo	int	必须	示例值：10,表示第10页（返回值中pages为总页数，若超过总页数，则返回最后一页数据。）	第几页
        businessDto.put("pageNo", orderDisputeCloseListReqDTO.getPageNo());
        //orderNo	String	否	卖家后台能查看；示例值：1455953150	订单号
        businessDto.put("orderNo", orderDisputeCloseListReqDTO.getOrderNo());
        //pageSize	int	必须	示例值：10,表示每页10条记录	每页记录数
        businessDto.put("pageSize", orderDisputeCloseListReqDTO.getPageSize());
        //startDate	String	必须	日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21	纠纷关闭开始时间
        businessDto.put("startDate", orderDisputeCloseListReqDTO.getStartDate());
        //endDate	String	必须	日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21	纠纷关闭结束时间
        businessDto.put("endDate", orderDisputeCloseListReqDTO.getEndDate());
        //buyerNickName	String	否	示例值：zhangsan	买家昵称
        businessDto.put("buyerNickName", orderDisputeCloseListReqDTO.getBuyerNickName());
        return businessDto;
    }

    private JSONObject getDhOrderRefundListReqDTO(DhOrderRefundListReqDTO orderRefundListReqDTO) {
        JSONObject businessDto = new JSONObject();
        //请求参数
        //参数名称	参数类型	是否必须	取值说明	参数说明
        //refundStatus	String	必须		退款状态
        businessDto.put("refundStatus", orderRefundListReqDTO.getRefundStatus());
        //applyStartDate	String	必须	日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21	申请开始时间
        businessDto.put("applyStartDate", orderRefundListReqDTO.getApplyStartDate());
        //completeStartDate	String	必须	日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21	完成开始时间
        businessDto.put("completeStartDate", orderRefundListReqDTO.getCompleteStartDate());
        //completeEndDate	String	必须	日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21	完成结束时间
        businessDto.put("completeEndDate", orderRefundListReqDTO.getCompleteEndDate());
        //applyEndDate	String	必须	日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21	申请结束时间
        businessDto.put("applyEndDate", orderRefundListReqDTO.getApplyEndDate());
        //pageSize	int	必须	示例值：10,表示每页10条记录	每页记录数
        businessDto.put("pageSize", orderRefundListReqDTO.getPageSize());
        //orderNo	String	必须	3600012301	订单号
        businessDto.put("orderNo", orderRefundListReqDTO.getOrderNo());
        //pageNo	int	必须	示例值：10,表示第10页（返回值中pages为总页数，若超过总页数，则返回最后一页数据。）	第几页
        businessDto.put("pageNo", orderRefundListReqDTO.getPageNo());
        return businessDto;
    }

    private JSONObject getDhOrderCanSendInvoiceReqDTO(DhOrderCanSendInvoiceReqDTO orderCanSendInvoiceReqDTO) {
        JSONObject businessDto = new JSONObject();
        //请求参数
        //参数名称	参数类型	是否必须	取值说明	参数说明
        //orderNo	String	必须	卖家后台登录能看到成交的订单号;示例值:1330312162	订单号
        businessDto.put("orderNo", orderCanSendInvoiceReqDTO.getOrderNo());
        return businessDto;
    }

    private JSONObject getDhOrderSendInvoiceReqDTO(DhOrderSendInvoiceReqDTO orderSendInvoiceReqDTO) {
        JSONObject businessDto = new JSONObject();
        //请求参数
        //参数名称	参数类型	是否必须	取值说明	参数说明
        //orderNo	String	必须	卖家后台登录能看到成交的订单号;示例值:1330312162	订单号
        businessDto.put("orderNo", orderSendInvoiceReqDTO.getOrderNo());
        return businessDto;
    }

}
