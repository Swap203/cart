package com.app.cart.service;

import org.springframework.http.ResponseEntity;
import com.app.cart.entity.CategoryOffer;

/**
 * @author Omkar Nikam
 * @since 06-Feb-2018
 * Service Interface for Category Offer
 */

public interface CategoryOfferService {

    public ResponseEntity<?> addCategoryOffer(CategoryOffer categoryOffer);

    public ResponseEntity<?> editCategoryOffer(Integer id, CategoryOffer categoryOffer);

    public ResponseEntity<?> deleteCategoryOffer(Integer id);

    public ResponseEntity<?> getCategoryOffer(Integer id);

    public ResponseEntity<?> getAllCategoryOffers();

    public ResponseEntity<?> getOffersByCategoryId(Integer categoryId);
}
