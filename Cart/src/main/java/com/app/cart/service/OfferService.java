package com.app.cart.service;

import org.springframework.http.ResponseEntity;
import com.app.cart.entity.Offer;

public interface OfferService {

    public ResponseEntity<?> addOffer(Offer offer);

    public ResponseEntity<?> editOffer(Integer id, Offer offer);

    public ResponseEntity<?> deleteOffer(Integer id);

    public ResponseEntity<?> getOffer(Integer id);

    public ResponseEntity<?> getAllOffers();

}
