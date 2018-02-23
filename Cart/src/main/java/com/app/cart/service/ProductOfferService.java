package com.app.cart.service;

import org.springframework.http.ResponseEntity;
import com.app.cart.entity.ProductOffer;

public interface ProductOfferService {

    public ResponseEntity<?> addOffer(ProductOffer offer);

    public ResponseEntity<?> editOffer(Integer id, ProductOffer offer);

    public ResponseEntity<?> deleteOffer(Integer id);

    public ResponseEntity<?> getOffer(Integer id);

    public ResponseEntity<?> getAllOffers();

    public ResponseEntity<?> getOffersByProduct(Integer id);

}
