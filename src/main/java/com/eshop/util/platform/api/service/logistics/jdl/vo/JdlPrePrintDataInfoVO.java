package com.eshop.util.platform.api.service.logistics.jdl.vo;

@lombok.Getter
@lombok.Setter
public class JdlPrePrintDataInfoVO {
    //msg	String	操作成功！	单个运单查询响应信息。暂时无其他状态码。长度255
    //code	String	1	单个运单查询结果。暂时无其他状态码。长度1-10
    //packageCode	String	JDV009104311208-1-1-	包裹号。京东物流的运单则有此字段，其他物流服务商的运单无此字段。规则："运单号-包囊序号-包裹总数-"。长度15-30
    //wayBillNo	String	JDV009104311208	运单号，与请求参数的运单号一致。长度15-30
    //perPrintData	String		面单信息加密后的内容，这个字符串比较大，建议使用对象存储来存数据

    private String msg;
    private String code;
    private String packageCode;
    private String wayBillNo;
    private String perPrintData;
}
