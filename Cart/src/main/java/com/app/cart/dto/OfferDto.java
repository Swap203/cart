package com.app.cart.dto;

import java.util.Date;

import lombok.Data;

@Data
public class OfferDto {


    /**
     * @author omkar.nikam
     * Table for General Offers
     */

    private Integer offerId;
    private String offerDescription;
    private String couponCode;

    private Double discountPercent;

    private Double discountAmount;

    private Double minOrderAmount;
    private Double maxDiscountAmount;

    private Integer minNumberOfProducts;

    private Date creationDate;

    private Date expiryDate;


}
