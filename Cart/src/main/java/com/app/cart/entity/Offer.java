package com.app.cart.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Omkar Nikam
 * @since 03-Feb-2018
 * Table for General Offers
 */

@Entity
@Table(name = "Offer")
@Data
@ApiModel
public class Offer {


    @Id
    @Column(unique = true, nullable = false)
    @SequenceGenerator(name = "offer_seq", sequenceName = "offer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offer_seq")
    @ApiModelProperty(value = "Keep 0 , Id will be generated Automatically", required = true)
    private Integer offerId;

    @Column(unique = false, nullable = false, length = 50)
    @ApiModelProperty(value = "Offer Description, max Length is 50 Characters", required = true)
    private String offerDescription;

    @Column(unique = false, nullable = false, length = 15)
    @ApiModelProperty(value = "Coupon Code, max Length is 15 Characters, No spaces allowed", required = true)
    private String couponCode;

    @Column(unique = false, nullable = true)
    @ApiModelProperty(value = "Discount Percentage, put 0 in case of nothing", required = false, allowEmptyValue = true)
    private Double discountPercent;

    @Column(unique = false, nullable = true)
    @ApiModelProperty(value = "Discount Amount, put 0 in case of nothing", required = false, allowEmptyValue = true)
    private Double discountAmount;

    @Column(unique = false, nullable = true)
    @ApiModelProperty(value = "Minimum Order Amount, put 0 in case of nothing", required = false, allowEmptyValue = true)
    private Double minOrderAmount;

    @Column(unique = false, nullable = true)
    @ApiModelProperty(value = "Maximum Discount Amount, put 0 in case of nothing", required = false, allowEmptyValue = true)
    private Double maxDiscountAmount;

    @Column(unique = false, nullable = true)
    @ApiModelProperty(value = "Minimum number of Products, put 0 in case of nothing", required = false, allowEmptyValue = true)
    private Integer minNumberOfProducts;

    @Column(unique = false, nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(value = "Keep it blank, Creation date will be generated automatically", required = true, hidden = true)
    private Date creationDate;

    @Column(unique = false, nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(value = "format : dd-MM-yyyy", required = true)
    private Date expiryDate;

}
