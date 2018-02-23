package com.app.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.cart.entity.Brand;

/**
 * @author pradnya.katkar
 * @since 04-02-2018
 */

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
