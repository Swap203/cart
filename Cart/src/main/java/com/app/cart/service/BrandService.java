package com.app.cart.service;

import org.springframework.http.ResponseEntity;
import com.app.cart.entity.Brand;

/**
 * @author pradnya.katkar
 * @since 04-02-2018
 */
public interface BrandService {
    /**
     * @param brand
     * @return brandId
     */
    public ResponseEntity<?> addBrand(Brand brand);

    /**
     * @param id
     * @param brand
     * @return BrandEntity
     */
    public ResponseEntity<?> editBrand(Integer id, Brand brand);

    /**
     * @param id
     * @return
     */
    public ResponseEntity<?> deleteBrand(Integer id);

    /**
     * @param id
     * @return
     */
    public ResponseEntity<?> getBrand(Integer id);

    /**
     * @return List of Brands
     */
    public ResponseEntity<?> getAllBrands();
}
