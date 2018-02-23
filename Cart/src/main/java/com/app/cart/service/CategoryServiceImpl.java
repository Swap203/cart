package com.app.cart.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.cart.entity.Category;
import com.app.cart.repository.CategoryRepository;

/**
 * @author Omkar Nikam
 * @since 04-Feb-2018
 * This class implements CategoryService Interface methods
 */

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private static final Logger logger = Logger.getLogger(CategoryServiceImpl.class);

    @Autowired
    CategoryRepository repository;

    @Override
    public ResponseEntity<?> addCategory(Category category) {

        try {
            logger.info("Saving a Category : " + category);
            return new ResponseEntity<Integer>(repository.save(category).getCategoryId(), new HttpHeaders(), HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error in saving a Category : " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> editCategory(Integer id, Category category) {

        try {
            Category dbObject = repository.findOne(id);
            if (null == dbObject) {
                logger.info("Category not found with id : " + id);
                return ResponseEntity.notFound().build();
            }
            category.setCategoryId(dbObject.getCategoryId());
            logger.info("Editing a Category : " + category);
            return new ResponseEntity<Category>(repository.save(category), new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error in editing a Category : " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> deleteCategory(Integer id) {

        try {
            Category dbObject = repository.findOne(id);
            if (null == dbObject) {
                logger.info("Category not found with id : " + id);
                return ResponseEntity.notFound().build();
            }
            logger.info("Deleting a Category, id : " + id);
            repository.delete(id);
            return new ResponseEntity<Category>(dbObject, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error in deleting a Category : " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> getCategory(Integer id) {

        try {
            logger.info("Getting Category with id : " + id);
            Category dbObject = repository.findOne(id);
            if (null == dbObject) {
                logger.info("Category not found with id : " + id);
                return ResponseEntity.notFound().build();
            }
            logger.info("Found Category with id : " + id + ", Category : " + dbObject);
            return new ResponseEntity<Category>(dbObject, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error in getting a Category : " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> getAllCategories() {

        try {
            logger.info("Getting All Categories");
            List<Category> list = repository.findAll();
            if (null == list) {
                logger.info("Categories not found");
                return ResponseEntity.notFound().build();
            }
            logger.info("Categories Found : " + list);
            return new ResponseEntity<List<Category>>(list, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error in getting all Categories : " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> getAllSubCategories() {

        try {
            logger.info("Getting All Sub Categories");
            List<Category> list = repository.findAllSubCategories();
            if (null == list) {
                logger.info("Sub Categories not found");
                return ResponseEntity.notFound().build();
            }
            logger.info("Sub Categories Found : " + list);
            return new ResponseEntity<List<Category>>(list, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error in getting all Sub Categories : " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> getAllParentCategories() {

        try {
            logger.info("Getting All Parent Categories");
            List<Category> list = repository.findAllParentCategories();
            if (null == list) {
                logger.info("Parent Categories not found");
                return ResponseEntity.notFound().build();
            }
            logger.info("Parent Categories Found : " + list);
            return new ResponseEntity<List<Category>>(list, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error in getting all Parent Categories : " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
