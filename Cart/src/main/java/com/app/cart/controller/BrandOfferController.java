package com.app.cart.controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.cart.entity.BrandOffer;
import com.app.cart.entity.Category;
import com.app.cart.entity.Offer;
import com.app.cart.service.BrandOfferService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Pratik Upare
 */

@RestController
@RequestMapping("/brandoffer")
public class BrandOfferController {

    @Autowired
    private BrandOfferService brandOfferService;

    private static final Logger logger = Logger.getLogger(BrandOfferController.class);

    @ApiOperation(value = "Add a Brand Offer", notes = "Creates a new Brand Offer", response = Integer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully added a new Brand Offer !"),
            @ApiResponse(code = 422, message = "Something went wrong, Brand Offer could not be added !")
    })
    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<?> addBrandOffer(@RequestBody BrandOffer brandOffer) {
        return brandOfferService.addBrandOffer(brandOffer);
    }

    @ApiOperation(value = "Edit a Brand Offer", notes = "Update existing Brand Offer", response = BrandOffer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully edited  Brand Offer !"),
            @ApiResponse(code = 404, message = "There is no Brand Offer entry for requested id to edit !"),
            @ApiResponse(code = 422, message = "Something went wrong, Brand Offer could not be edited !")
    })
    @PutMapping(value = "/edit/{id}", produces = "application/json")
    public ResponseEntity<?> editBrandOffer(@PathVariable Integer id, @RequestBody BrandOffer brandOffer) {
        return brandOfferService.editBrandOffer(id, brandOffer);
    }

    /**
     * @param id - id of the Brand Offer to be deleted
     * @return the deleted entity Brand Offer
     */
    @ApiOperation(value = "Delete a Brand Offer", notes = "Deletes an existing Brand Offer", response = BrandOffer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted a Brand Offer !"),
            @ApiResponse(code = 404, message = "Brand Offer to be deleted not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Brand Offer could not be deleted !")
    })
    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<?> deleteBrandOffer(@PathVariable Integer id) {
        return brandOfferService.deleteBrandOffer(id);
    }

    /**
     * @param id - id of the Brand Offer to be retrieved
     * @return the requested entity Brand Offer
     */
    @ApiOperation(value = "Get a Brand Offer", notes = "Get an existing Brand Offer", response = BrandOffer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved a Brand Offer !"),
            @ApiResponse(code = 404, message = "Brand Offer to be retrieved not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Brand Offer could not be retrieved !")
    })
    @GetMapping(value = "/get/{id}", produces = "application/json")
    public ResponseEntity<?> getBrandOffer(@PathVariable Integer id) {
        return brandOfferService.getBrandOffer(id);
    }

    /**
     * @return list of Brand Offer Entities
     */
    @ApiOperation(value = "Get all Brand Offers", notes = "Get all existing Brand Offers", response = ArrayList.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Brand Offers !"),
            @ApiResponse(code = 404, message = "Brand Offers to be retrieved not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Brand Offers could not be retrieved !")
    })
    @GetMapping(value = "/getall", produces = "application/json")
    public ResponseEntity<?> getAllBrandOffers() {
        return brandOfferService.getAllBrandOffers();
    }

	/*@GetMapping(value = "/get/{brandName}", produces = "application/json")
	public ResponseEntity<?> getAllBrandOffersByBrandName(@PathVariable String brandName)
	{	
		return brandOfferService.getAllBrandOffersByBrandName(brandName);
	}*/

    /**
     * @param id - id of the Brand Offer to be retrieved
     * @return the requested entity Brand Offers
     */
    @ApiOperation(value = "Get a Brand Offers", notes = "Get an existing Brand Offers", response = ArrayList.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved a Brand Offers !"),
            @ApiResponse(code = 404, message = "Brand Offers to be retrieved not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Brand Offers could not be retrieved !")
    })
    @GetMapping(value = "/getbybrand/{id}", produces = "application/json")
    public ResponseEntity<?> getAllBrandOffersByBrandId(@PathVariable Integer id) {

        return brandOfferService.getAllBrandOffersByBrandId(id);
    }
}
	
	
	
	


