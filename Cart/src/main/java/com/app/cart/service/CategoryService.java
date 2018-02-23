package com.app.cart.service;

import org.springframework.http.ResponseEntity;
import com.app.cart.entity.Category;

/**
 * @author Omkar Nikam
 * @since 04-Feb-2018
 * Service Interface for Category
 */

public interface CategoryService {

    public ResponseEntity<?> addCategory(Category category);

    public ResponseEntity<?> editCategory(Integer id, Category category);

    public ResponseEntity<?> deleteCategory(Integer id);

    public ResponseEntity<?> getCategory(Integer id);

    public ResponseEntity<?> getAllCategories();

    public ResponseEntity<?> getAllSubCategories();

    public ResponseEntity<?> getAllParentCategories();
}
