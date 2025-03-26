package com.eshop.code.vo.shopeeod;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopeeOrderDetailRecipientAddress {
    /**
     * Recipient's name for the address.
     */
    private String name;

    /**
     * <p>Recipient's phone number input when order was placed.<br />[Only for TW non-integrated channel] Will return "****" when the "virtual_contact_number" is available<br /></p>
     */
    private String phone;

    /**
     * The town of the recipient's address. Whether there is a town will depend on the region and/or country.
     */
    private String town;

    /**
     * The district of the recipient's address. Whether there is a district will depend on the region and/or country.
     */
    private String district;

    /**
     * The city of the recipient's address. Whether there is a city will depend on the region and/or country.
     */
    private String city;

    /**
     * The state/province of the recipient's address. Whether there is a state/province will depend on the region and/or country.
     */
    private String state;

    /**
     * The two-digit code representing the region of the Recipient.
     */
    private String region;

    /**
     * Recipient's postal code.
     */
    private String zipcode;

    /**
     * The full address of the recipient, including country, state, even street, and etc.
     */
    private String full_address;

}
