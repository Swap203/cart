package com.app.cart.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Omkar Nikam
 * @since 03-Feb-2018
 * Table for Product
 */

@Entity
@Table(name = "Product")
@Data
@EqualsAndHashCode(exclude = {"category", "brand", "offers"})
@ToString(exclude = {"category", "brand", "offers"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "productId")
@ApiModel
public class Product {

    @Id
    @Column(unique = true, nullable = false)
    @SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @ApiModelProperty(value = "Keep 0 , Id will be generated Automatically", required = true)
    private Integer productId;

    @Column(unique = false, nullable = false, length = 50)
    @ApiModelProperty(value = "Product Name, max Length is 50 Characters", required = true)
    private String productName;

    @Column(unique = false, nullable = false, length = 200)
    @ApiModelProperty(value = "Product Description, max Length is 200 Characters", required = true)
    private String productDescription;

    @Column(unique = false, nullable = false)
    @ApiModelProperty(value = "Unit of the product", required = true)
    private Integer unit;

    @Column(unique = false, nullable = false)
    @ApiModelProperty(value = "Quantity of the product", required = true)
    private Integer quantity;

    @Column(unique = false, nullable = false)
    @ApiModelProperty(value = "Rate of the product", required = true)
    private Double rate;

    @Column(unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "Max Length is 50 Characters", required = false, allowEmptyValue = true)
    private String productImagePath;

    @Column(unique = false, nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(value = "format : dd-MM-yyyy", required = true)
    private Date stockUpdatedDate;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    @ApiModelProperty(required = true)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brandId", nullable = false)
    @ApiModelProperty(required = true)
    private Brand brand;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    @ApiModelProperty(required = false, allowEmptyValue = true)
    private Set<ProductOffer> offers;

}
