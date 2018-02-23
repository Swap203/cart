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
import com.app.cart.entity.Brand;
import com.app.cart.service.BrandService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author pradnya.katkar
 * @since 04-02-2018
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    private static final Logger logger = Logger.getLogger(BrandController.class);

    @Autowired
    BrandService service;

    /**
     * @param brand
     * @return brand.id
     */
    @ApiOperation(value = "Add a Brand", notes = "Creates a new Brand", response = Integer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully added a new Brand !"),
            @ApiResponse(code = 422, message = "Something went wrong, Brand could not be added !")
    })
    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<?> addBrand(@RequestBody Brand brand) {
        logger.info("Object ->" + brand);
        return service.addBrand(brand);
    }

    /**
     * @param id
     * @param brand
     * @return brand entity
     */
    @ApiOperation(value = "Edit a Brand", notes = "Updates an existing Brand", response = Brand.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated a Brand !"),
            @ApiResponse(code = 404, message = "Brand to be edited not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Brand could not be updated !")
    })
    @PutMapping(value = "/edit/{id}", produces = "application/json")
    public ResponseEntity<?> editBrand(@PathVariable Integer id, @RequestBody Brand brand) {
        logger.info("Object and ID -> " + brand + ", ID -> " + id);
        return service.editBrand(id, brand);
    }

    /**
     * @param id
     * @return
     */
    @ApiOperation(value = "Delete a Brand", notes = "Deletes an existing Brand", response = Brand.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted a Brand !"),
            @ApiResponse(code = 404, message = "Brand to be deleted not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Brand could not be deleted !")
    })
    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<?> deleteBrand(@PathVariable Integer id) {
        logger.info("Id to be deleted -> " + id);
        return service.deleteBrand(id);
    }

    /**
     * @param id
     * @return BrandEntity
     */
    @ApiOperation(value = "Get a Brand", notes = "Get an existing Brand", response = Brand.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved a Brand !"),
            @ApiResponse(code = 404, message = "Brand to be retrieved not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Brand could not be retrieved !")
    })
    @GetMapping(value = "/get/{id}", produces = "application/json")
    public ResponseEntity<?> getBrand(@PathVariable Integer id) {
        logger.info("Id to be deleted -> " + id);
        return service.getBrand(id);
    }

    /**
     * @return
     */
    @ApiOperation(value = "Get all Brands", notes = "Get all existing Brands", response = ArrayList.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Brands !"),
            @ApiResponse(code = 404, message = "Brands to be retrieved not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Brands could not be retrieved !")
    })
    @GetMapping(value = "/getall", produces = "application/json")
    public ResponseEntity<?> getAllBrands() {
        return service.getAllBrands();
    }
}
