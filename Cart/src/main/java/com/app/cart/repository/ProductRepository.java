package com.app.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.app.cart.entity.Product;

/**
 * @author Priyanka Bagul
 * @since 05-Feb-2018
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByBrandBrandId(Integer id);

    @Query("from Product p where p.category.categoryId = ?1 or p.category.parentCategoryId = ?1")
    List<Product> findByCategoryId(Integer id);

    //List<Product> findByCategoryCategoryId(Integer id);

}
