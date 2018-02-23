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
import com.app.cart.entity.ProductOffer;
import com.app.cart.repository.ProductOfferRepository;

/**
 * @author Nilesh Sargar
 * @since 06-Feb-2018
 */

@Service
@Transactional
public class ProductOfferServiceImpl implements ProductOfferService {

    @Autowired
    private ProductOfferRepository repo;
	
	/*@Autowired
	private EntityManager em;*/

    private static final Logger logger = Logger.getLogger(ProductOfferServiceImpl.class);

    @Override
    public ResponseEntity<?> addOffer(ProductOffer offer) {
        try {
            offer.setCreationDate(new Date());
            return new ResponseEntity<Integer>(repo.saveAndFlush(offer).getProductOfferId(), new HttpHeaders(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> editOffer(Integer id, ProductOffer offer) {
        try {
            ProductOffer dbcopy = repo.findOne(id);
            if (null == dbcopy)
                return ResponseEntity.notFound().build();
            offer.setProductOfferId(dbcopy.getProductOfferId()); //Just set new received offer objects id field to the one we want to edit in DB and persist using save()
            return new ResponseEntity<ProductOffer>(repo.save(offer), new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> deleteOffer(Integer id) {
        try {
            ProductOffer deletedObject = repo.findOne(id);
            if (null == deletedObject)
                return ResponseEntity.notFound().build();
            else {
                repo.delete(id);
                return new ResponseEntity<ProductOffer>(deletedObject, new HttpHeaders(), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> getOffer(Integer id) {
        try {
            ProductOffer requestedObject = repo.findOne(id);
            if (null == requestedObject)
                return ResponseEntity.notFound().build();
            //em.detach(requestedObject.getProduct());
            logger.info(requestedObject);
            return new ResponseEntity<ProductOffer>(requestedObject, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> getAllOffers() {
        try {
            List<ProductOffer> list = repo.findAll();
            if (list.isEmpty())
                return ResponseEntity.notFound().build();
            return new ResponseEntity<List<ProductOffer>>(list, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> getOffersByProduct(Integer id) {
        try {
            List<ProductOffer> list = repo.findByProductProductId(id);
            if (list.isEmpty())
                return ResponseEntity.notFound().build();
            return new ResponseEntity<List<ProductOffer>>(list, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
