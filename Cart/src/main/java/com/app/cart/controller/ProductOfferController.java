package com.app.cart.controller;

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
import com.app.cart.entity.ProductOffer;
import com.app.cart.service.ProductOfferService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author SwapnilPawale
 * @since 15-02-2018
 */

@RestController
@RequestMapping("/productoffer")
public class ProductOfferController {

    @Autowired
    private ProductOfferService service;

    @ApiOperation(value = "Add a ProductOffer", notes = "Creates New ProductOffer", response = Integer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully added a new ProductOffer!!!"),
            @ApiResponse(code = 422, message = "Something went wrong, ProductOffer could not be added!!!")
    })
    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<?> addOffer(@RequestBody ProductOffer offer) {
        return service.addOffer(offer);
    }

    @ApiOperation(value = "Edit a ProductOffer", notes = "Update an Existing ProductOffer by using ID", response = ProductOffer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully edited and saved ProductOffer!!!"),
            @ApiResponse(code = 404, message = "Cannot find any ProductOffer to be Edited for Given ID!!!"),
            @ApiResponse(code = 422, message = "Something went wrong, ProductOffer could not be updated!!!"),
    })
    @PutMapping(value = "/edit/{id}", produces = "application/json")
    public ResponseEntity<?> editOffer(@PathVariable Integer id, @RequestBody ProductOffer offer) {
        return service.editOffer(id, offer);
    }

    @ApiOperation(value = "Delete a ProductOffer", notes = "Delete an Existing ProductOffer by using ID", response = ProductOffer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Deleted ProductOffer!!!"),
            @ApiResponse(code = 404, message = "Cannot find any ProductOffer to be Deleted for Given ID!!!"),
            @ApiResponse(code = 422, message = "Something went wrong, ProductOffer could not be Deleted!!!"),
    })
    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<?> deleteOffer(@PathVariable Integer id) {
        return service.deleteOffer(id);
    }

    @ApiOperation(value = "Get a ProductOffer", notes = "Get an Existing ProductOffer by using ID", response = ProductOffer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved ProductOffer!!!"),
            @ApiResponse(code = 404, message = "Cannot find any ProductOffer for given ID!!!"),
            @ApiResponse(code = 422, message = "Something went wrong, ProductOffer could not be retrieved!!!"),
    })
    @GetMapping(value = "/get/{id}", produces = "application/json")
    public ResponseEntity<?> getOffer(@PathVariable Integer id) {
        return service.getOffer(id);
    }

    @ApiOperation(value = "Get all ProductOffer", notes = "Get all Existing ProductOffers", response = ProductOffer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all ProductOffers!!!"),
            @ApiResponse(code = 404, message = "Cannot find ProductOffers!!!"),
            @ApiResponse(code = 422, message = "Something went wrong, ProductOffers could not be retrieved!!!"),
    })
    @GetMapping(value = "/getall", produces = "application/json")
    public ResponseEntity<?> getallOffers() {
        return service.getAllOffers();
    }

    @ApiOperation(value = "Get all ProductOffers by Product ID", notes = "Get all Existing ProductOffers by using Product ID", response = ProductOffer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all ProductOffers for Given Product ID !!!"),
            @ApiResponse(code = 404, message = "Cannot find ProductOffers for Given Product ID!!!"),
            @ApiResponse(code = 422, message = "Something went wrong, ProductOffers could not be retrieved!!!"),
    })
    @GetMapping(value = "/getbyproduct/{id}", produces = "application/json")
    public ResponseEntity<?> getOffersByProduct(@PathVariable Integer id) {
        return service.getOffersByProduct(id);
    }
}
