package com.app.cart.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Omkar Nikam
 * @since 03-Feb-2018
 * Table for Product Offers
 */

@Entity
@Table(name="ProductOffer")
@Data
@EqualsAndHashCode(exclude = {"product"})
@ToString(exclude = {"product"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "productOfferId")
@ApiModel
public class ProductOffer {

	@Id
	@Column(unique = true, nullable = false)
	@SequenceGenerator(name="productoffer_seq", sequenceName="productoffer_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="productoffer_seq")
	@ApiModelProperty(value="Keep 0 , Id will be generated Automatically", required = true)
	private Integer productOfferId;
	
	@Column(unique = false, nullable = false, length=50)
	@ApiModelProperty(value="Offer Description, max Length is 50 Characters", required = true)
	private String offerDescription;
	
	@ApiModelProperty(value="Coupon Code, max Length is 15 Characters", required = true)
	@Column(unique = false, nullable = false, length=15)
	private String couponCode;
	
	
	@Column(unique = false, nullable = true)
	@ApiModelProperty(value="Discount Percentage, put 0 in case of nothing", required = false, allowEmptyValue=true)
	private Double discountPercent;
	
	@Column(unique = false, nullable = true)
	@ApiModelProperty(value="Discount Amount, put 0 in case of nothing", required = false, allowEmptyValue=true)
	private Double discountAmount;
	
	@Column(unique = false, nullable = false)
	@ApiModelProperty(value="Minimum Order Amount, put 0 in case of nothing", required = false, allowEmptyValue=true)
	private Double minOrderAmount;
	
	@Column(unique = false, nullable = false)
	@ApiModelProperty(value="Maximum Discount Amount, put 0 in case of nothing", required = false, allowEmptyValue=true)
	private Double maxDiscountAmount;
	
	@Column(unique = false, nullable = false)
	@JsonFormat(pattern="dd-MM-yyyy")
	@ApiModelProperty(value="Keep it blank, Creation date will be generated automatically", required = true, hidden = true)
	private Date creationDate;
	
	@Column(unique = false, nullable = false)
	@JsonFormat(pattern="dd-MM-yyyy")
	@ApiModelProperty(value="format : dd-MM-yyyy", required = true)
	private Date expiryDate;
	
	@ManyToOne
	@JoinColumn( name = "productId", nullable = false )
	@ApiModelProperty(required = true)
	private Product product;
	
}
