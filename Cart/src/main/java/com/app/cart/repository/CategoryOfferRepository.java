package com.app.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.app.cart.entity.CategoryOffer;

/**
 * @author Omkar Nikam
 * @since 06-Feb-2018
 * Category Offer Repository
 */

@Repository
public interface CategoryOfferRepository extends JpaRepository<CategoryOffer, Integer> {

    @Query(value = "from CategoryOffer c where c.category.categoryId=?1")
    List<CategoryOffer> getOffersByCategoryId(Integer categoryId);
}
