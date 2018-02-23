package com.app.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.cart.entity.BrandOffer;

/**
 * @author Pratik Upare
 * @since 06-Feb-2018
 */

@Repository
public interface BrandOfferRepository extends JpaRepository<BrandOffer, Integer> {

    public List<BrandOffer> findByBrandBrandName(String brandName);

    public List<BrandOffer> findByBrandBrandId(Integer id);
}
