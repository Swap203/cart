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
 * Table for Category
 */

@Entity
@Table(name = "Category")
@Data
@EqualsAndHashCode(exclude = {"offers", "products"})
@ToString(exclude = {"offers", "products"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "categoryId")
@ApiModel
public class Category {

    @Id
    @Column(unique = true, nullable = false)
    @SequenceGenerator(name = "category_seq", sequenceName = "category_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    @ApiModelProperty(value = "Keep 0 , Id will be generated Automatically", required = true)
    private Integer categoryId;

    @Column(unique = false, nullable = false, length = 50)
    @ApiModelProperty(value = "Category Name, max Length is 50 Characters", required = true)
    private String categoryName;

    @Column(unique = false, nullable = true, length = 50)
    @ApiModelProperty(value = "Max Length is 50 Characters", required = false, allowEmptyValue = true)
    private String categoryImagePath;

    @Column(unique = false, nullable = true)
    @ApiModelProperty(value = "Id of the Parent Category", required = false, allowEmptyValue = true)
    private Integer parentCategoryId;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    @ApiModelProperty(required = false, allowEmptyValue = true)
    private Set<Product> products;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    @ApiModelProperty(required = false, allowEmptyValue = true)
    private Set<CategoryOffer> offers;

}
