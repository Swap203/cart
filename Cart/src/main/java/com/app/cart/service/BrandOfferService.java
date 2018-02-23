package com.app.cart.service;

import org.springframework.http.ResponseEntity;
import com.app.cart.entity.BrandOffer;

public interface BrandOfferService {

    public ResponseEntity<?> addBrandOffer(BrandOffer brandOffer);

    public ResponseEntity<?> editBrandOffer(Integer id, BrandOffer brandOffer);

    public ResponseEntity<?> deleteBrandOffer(Integer id);

    public ResponseEntity<?> getBrandOffer(Integer id);

    public ResponseEntity<?> getAllBrandOffers();

    public ResponseEntity<?> getAllBrandOffersByBrandName(String brandName);

    public ResponseEntity<?> getAllBrandOffersByBrandId(Integer id);

}
