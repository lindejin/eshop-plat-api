package com.eshop.util.platform.api.service.logistics.jdl.dto;


@lombok.Getter
@lombok.Setter
public class JdlJdlPullDataReqDTO {
    //cpCode	String	是	JD	承运商编码。承运商编码列表：https://cloud.jdl.com/#/open-business-document/access-guide/157/54133。长度2-10
    private String cpCode;
    //wayBillInfos	List<WayBillInfo>	是		运单信息列表。最多支持10条
    private java.util.List<JdlWayBillInfoDTO> wayBillInfos;
    //parameters	Map<String, String>	是		商家信息
    /**
     * key	String	是	ewCustomerCode	cpCode为JD\JDKY\JDDJ\ZY时，key的值是ewCustomerCode；
     * value	String	是	11223344	cpCode为JD\JDKY\JDDJ\ZY时，value传商家编码（京东快递传商家编码，京东快运、京东大件传事业部编码）；
     * cpCode是非京东物流的其他物流服务时，key的值是eCustomerCode。长度13-14
     * cpCode是非京东物流的其他物流服务时，value传下运单时无界电子面单店铺的vendorid或vendorcode。长度1-30
     */
    private java.util.Map<String, String> parameters;
    //objectId	String	是	d553f7a1-a0f2-4b00-92b4-1975f3b5a45e	每次请求唯一，本次获取打印数据请求ID，根据此请求ID可快速定位并进行排查。长度10-50
    private String objectId;
}
