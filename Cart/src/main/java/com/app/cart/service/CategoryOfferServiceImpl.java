package com.app.cart.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.cart.entity.CategoryOffer;
import com.app.cart.repository.CategoryOfferRepository;

/**
 * @author Omkar Nikam
 * @since 06-Feb-2018
 * This class implements CategoryOfferService Interface methods
 */

@Service
@Transactional
public class CategoryOfferServiceImpl implements CategoryOfferService {

    private static final Logger logger = Logger.getLogger(CategoryOfferServiceImpl.class);

    @Autowired
    CategoryOfferRepository repository;

    @Override
    public ResponseEntity<?> addCategoryOffer(CategoryOffer categoryOffer) {
        try {
            logger.info("Saving a CategoryOffer : " + categoryOffer);
            categoryOffer.setCreationDate(new Date());
            return new ResponseEntity<Integer>(repository.save(categoryOffer).getCategoryOfferId(), new HttpHeaders(), HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error in saving a CategoryOffer : " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> editCategoryOffer(Integer id, CategoryOffer categoryOffer) {

        try {
            CategoryOffer dbObject = repository.findOne(id);
            if (null == dbObject) {
                logger.info("CategoryOffer not found with id : " + id);
                return ResponseEntity.notFound().build();
            }
            categoryOffer.setCategoryOfferId(dbObject.getCategoryOfferId());
            logger.info("Editing a CategoryOffer : " + categoryOffer);
            return new ResponseEntity<CategoryOffer>(repository.save(categoryOffer), new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error in saving a CategoryOffer : " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> deleteCategoryOffer(Integer id) {

        try {
            CategoryOffer dbObject = repository.findOne(id);
            if (null == dbObject) {
                logger.info("CategoryOffer not found with id : " + id);
                return ResponseEntity.notFound().build();
            }
            logger.info("Deleting a CategoryOffer, id : " + id);
            repository.delete(id);
            return new ResponseEntity<CategoryOffer>(dbObject, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error in deleting a CategoryOffer : " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> getCategoryOffer(Integer id) {

        try {
            logger.info("Getting CategoryOffer with id : " + id);
            CategoryOffer dbObject = repository.findOne(id);
            if (null == dbObject) {
                logger.info("CategoryOffer not found with id : " + id);
                return ResponseEntity.notFound().build();
            }

            logger.info("Found CategoryOffer with id : " + id + ", CategoryOffer : " + dbObject);
            return new ResponseEntity<CategoryOffer>(dbObject, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error in getting a CategoryOffer : " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

    @Override
    public ResponseEntity<?> getAllCategoryOffers() {

        try {
            logger.info("Getting All CategoryOffers");
            List<CategoryOffer> list = repository.findAll();
            if (null == list) {
                logger.info("Category Offers not found");
                return ResponseEntity.notFound().build();
            }
            logger.info("Category Offers Found : " + list);
            return new ResponseEntity<List<CategoryOffer>>(list, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error in getting all CategoryOffers : " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> getOffersByCategoryId(Integer categoryId) {

        try {
            logger.info("Getting CategoryOffers with Category Id : " + categoryId);
            List<CategoryOffer> list = repository.getOffersByCategoryId(categoryId);
            if (null == list) {
                logger.info("Category Offers not found for Category Id : " + categoryId);
                return ResponseEntity.notFound().build();
            }

            logger.info("Category Offers Found for Category Id : " + categoryId + ", List : " + list);
            return new ResponseEntity<List<CategoryOffer>>(list, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error in getting CategoryOffers by Category Id : " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
