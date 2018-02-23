package com.app.cart.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.cart.entity.BrandOffer;
import com.app.cart.repository.BrandOfferRepository;

/**
 * @author Pratik Upare
 * @since 06-Feb-2018
 */

@Service
@Transactional
public class BrandOfferServiceImpl implements BrandOfferService {

    @Autowired
    private BrandOfferRepository repository;

    @Override
    public ResponseEntity<?> addBrandOffer(BrandOffer brandOffer) {

        try {
            brandOffer.setCreationDate(new Date());
            return new ResponseEntity<Integer>(repository.save(brandOffer).getBrandOfferId(), new HttpHeaders(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> editBrandOffer(Integer brandOfferId, BrandOffer brandOffer) {
        try {
            BrandOffer dbbrandOffer = repository.findOne(brandOfferId);
            if (null == dbbrandOffer)
                return ResponseEntity.notFound().build();
            brandOffer.setBrandOfferId(dbbrandOffer.getBrandOfferId());
            return new ResponseEntity<BrandOffer>(repository.save(brandOffer), new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> deleteBrandOffer(Integer brandOfferId) {
        try {
            BrandOffer dbbrandOffer = repository.findOne(brandOfferId);
            if (null == dbbrandOffer)
                return ResponseEntity.notFound().build();
            else {
                repository.delete(dbbrandOffer);
                return new ResponseEntity<BrandOffer>(dbbrandOffer, new HttpHeaders(), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> getBrandOffer(Integer brandOfferId) {
        try {
            BrandOffer dbbrandOffer = repository.findOne(brandOfferId);
            if (null == dbbrandOffer)
                return ResponseEntity.notFound().build();
            return new ResponseEntity<BrandOffer>(dbbrandOffer, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> getAllBrandOffers() {
        try {
            List<BrandOffer> list = repository.findAll();
            if (list.isEmpty())
                return ResponseEntity.notFound().build();
            return new ResponseEntity<List<BrandOffer>>(list, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> getAllBrandOffersByBrandName(String brandName) {
        try {
            List<BrandOffer> list = repository.findByBrandBrandName(brandName);
            if (list.isEmpty())
                return ResponseEntity.notFound().build();
            return new ResponseEntity<List<BrandOffer>>(list, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> getAllBrandOffersByBrandId(Integer id) {
        try {
            List<BrandOffer> list = repository.findByBrandBrandId(id);
            if (list.isEmpty())
                return ResponseEntity.notFound().build();
            return new ResponseEntity<List<BrandOffer>>(list, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
