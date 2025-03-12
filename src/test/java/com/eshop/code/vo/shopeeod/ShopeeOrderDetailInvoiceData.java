package com.eshop.code.vo.shopeeod;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
public class ShopeeOrderDetailInvoiceData {
    /**
     * The number of the invoice.
     */
    private String number;

    /**
     * The series number of the invoice.
     */
    private String series_number;

    /**
     * The access key of the invoice.
     */
    private String access_key;

    /**
     * The issue date of the invoice.
     */
    private Timestamp issue_date;

    /**
     * The total value of the invoice.
     */
    private BigDecimal total_value;

    /**
     * The products total value of the invoice.
     */
    private BigDecimal products_total_value;

    /**
     * The tax code for the invoice.
     */
    private String tax_code;

}
