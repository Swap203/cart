package com.app.cart.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
 * Table for Brand
 */

@Entity
@Table(name = "Brand")
@Data
@ToString(exclude = {"offers", "products"})
@EqualsAndHashCode(exclude = {"offers", "products"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "brandId")
@ApiModel
public class Brand {

    @Id
    @Column(unique = true, nullable = false)
    @SequenceGenerator(name = "brand_seq", sequenceName = "brand_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_seq")
    @ApiModelProperty(value = "Keep 0 , Id will be generated Automatically", required = true)
    private Integer brandId;

    @Column(unique = false, nullable = false, length = 50)
    @ApiModelProperty(value = "Brand Name, max Length is 50 Characters", required = true)
    private String brandName;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    @ApiModelProperty(required = false, allowEmptyValue = true)
    private Set<Product> products;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    @ApiModelProperty(required = false, allowEmptyValue = true)
    private Set<BrandOffer> offers;

}
