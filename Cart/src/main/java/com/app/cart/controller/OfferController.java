package com.app.cart.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.cart.entity.Offer;
import com.app.cart.service.OfferService;

import java.util.ArrayList;

/**
 * @author Nilesh Sargar
 */

@RestController
@RequestMapping("/offer")
public class OfferController {

    @Autowired
    private OfferService service;

    @Autowired
    private DiscoveryClient client;

	/*@Autowired
	private CategoryRepository repo;*/

    private static final Logger logger = Logger.getLogger(OfferController.class);


    @ApiOperation(value = "Add a Offer", notes = "Creates a new Offer", response = Integer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully added a new Offer !"),
            @ApiResponse(code = 422, message = "Something went wrong, Offer could not be added !")
    })
    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<?> addOffer(@RequestBody Offer offer) {

        return service.addOffer(offer);
    }

    @ApiOperation(value = "Edit a Offer", notes = "Update existing Offer", response = Offer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully edited  Offer !"),
            @ApiResponse(code = 404, message = "There is no Offer entry for requested id to edit !"),
            @ApiResponse(code = 422, message = "Something went wrong, Offer could not be edited !")
    })
    @PutMapping(value = "/edit/{id}", produces = "application/json")
    public ResponseEntity<?> editOffer(@PathVariable Integer id, @RequestBody Offer offer) {

        return service.editOffer(id, offer);
    }

    @ApiOperation(value = "Delete an Offer", notes = "Delete Offer if existed else return no found response", response = Offer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully deleted an Offer !"),
            @ApiResponse(code = 404, message = "There is no Offer entry in databse to delete !"),
            @ApiResponse(code = 422, message = "Something went wrong, Offer could not be deleted !")
    })
    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<?> deleteOffer(@PathVariable Integer id) {

        return service.deleteOffer(id);
    }


    @ApiOperation(value = "Get an Offer", notes = "Get an Offer for id", response = Offer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully retrieved an Offer !"),
            @ApiResponse(code = 404, message = "There is no Offer entry available for requested id !"),
            @ApiResponse(code = 422, message = "Something went wrong, Offer not found !")
    })
    @GetMapping(value = "/get/{id}", produces = "application/json")
    public ResponseEntity<?> getOffer(@PathVariable Integer id) {

        return service.getOffer(id);
    }

    @ApiOperation(value = "Get all Offers", notes = "Get list of all offers", response = ArrayList.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully added a new Offer !"),
            @ApiResponse(code = 422, message = "Something went wrong, Offer could not be added !")
    })
    @GetMapping(value = "/getall", produces = "application/json")
    public ResponseEntity<?> getAllOffers() {
        return service.getAllOffers();
    }

}