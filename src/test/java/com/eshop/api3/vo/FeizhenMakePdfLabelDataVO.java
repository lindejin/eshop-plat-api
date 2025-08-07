package com.eshop.api3.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeizhenMakePdfLabelDataVO {

    /**
     * 订单id
     */
    private String orderid;

    /**
     * 运单号
     */
    private String ydh;

    /**
     * pdf base64
     */
    private String pdf_base64;

    /**
     * pdf label_pdf
     */
    private String label_pdf;
}
