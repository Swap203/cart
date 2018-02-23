package com.app.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.app.cart.entity.Category;

/**
 * @author Omkar Nikam
 * @since 04-Feb-2018
 * Category Repository
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("from Category c where c.parentCategoryId is not null")
    List<Category> findAllSubCategories();

    @Query("from Category c where c.parentCategoryId is null")
    List<Category> findAllParentCategories();
}
