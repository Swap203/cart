package com.app.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.cart.entity.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {

}
