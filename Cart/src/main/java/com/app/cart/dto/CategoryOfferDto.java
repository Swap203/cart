package com.app.cart.dto;

import java.util.Date;


import com.app.cart.entity.Category;
import com.app.cart.entity.CategoryOffer;

import lombok.Data;

@Data
public class CategoryOfferDto {

    private Integer categoryOfferId;

    private String offerDescription;

    private String couponCode;

    private Double discountPercent;

    private Double discountAmount;

    private Double minOrderAmount;

    private Double maxDiscountAmount;

    private Date creationDate;

    private Date expiryDate;

    private Category category;


}
