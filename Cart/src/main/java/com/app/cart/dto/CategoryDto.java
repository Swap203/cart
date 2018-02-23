package com.app.cart.dto;

import java.util.Set;

import com.app.cart.entity.Category;
import com.app.cart.entity.CategoryOffer;
import com.app.cart.entity.Product;
import lombok.Data;

@Data
public class CategoryDto {


    private Integer categoryId;
    private String categoryName;
    private String categoryImagePath;
    private Integer parentCategoryId;
    private Set<Product> products;
    private Set<CategoryOffer> offers;


}
