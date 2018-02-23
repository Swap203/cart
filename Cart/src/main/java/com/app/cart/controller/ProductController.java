package com.app.cart.controller;

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
import com.app.cart.entity.Product;
import com.app.cart.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;

/**
 * @author Priyanka Bagul
 * @since 05-Feb-2018
 * Rest Controller for Product APIs
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    private static final Logger logger = Logger.getLogger(ProductController.class);

    /**
     * @param product - the entity Product
     * @return id of the persisted Product entity
     */
    @ApiOperation(value = "Add a Product", notes = "Creates a new Product", response = Integer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully added a new Product !"),
            @ApiResponse(code = 422, message = "Something went wrong, Product could not be added !")
    })
    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {

        logger.info("Calling Product Service - Add : " + product);
        return service.addProduct(product);
    }

    /**
     * @param id      - id of the Product to be edited
     * @param product - the entity Product
     * @return the edited entity Product
     */
    @ApiOperation(value = "Edit a Product", notes = "Updates an existing Product", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated a Product !"),
            @ApiResponse(code = 404, message = "Product to be edited not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Product could not be updated !")
    })
    @PutMapping(value = "/edit/{id}", produces = "application/json")
    public ResponseEntity<?> editProduct(@PathVariable Integer id, @RequestBody Product product) {
        logger.info("Calling Product Service - Edit, id : " + id + ", Product :" + product);

        return service.editProduct(id, product);
    }

    /**
     * @param id - id of the Product to be deleted
     * @return the deleted entity Product
     */
    @ApiOperation(value = "Delete a Product", notes = "Deletes an existing Product", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted a Product !"),
            @ApiResponse(code = 404, message = "Product to be deleted not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Product could not be deleted !")
    })
    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        logger.info("Calling Product Service - Delete, id : " + id);
        return service.deleteProduct(id);
    }

    /**
     * @param id - id of the Product to be retrieved
     * @return the requested entity Product
     */
    @ApiOperation(value = "Get a Product", notes = "Get an existing Product", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved a Product !"),
            @ApiResponse(code = 404, message = "Product to be retrieved not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Product could not be retrieved !")
    })
    @GetMapping(value = "/get/{id}", produces = "application/json")
    public ResponseEntity<?> getProduct(@PathVariable Integer id) {
        logger.info("Calling Product Service - Get, id : " + id);
        return service.getProduct(id);
    }

    /**
     * @return list of Product Entities
     */
    @ApiOperation(value = "Get all Product", notes = "Get all existing Product", response = ArrayList.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Product !"),
            @ApiResponse(code = 404, message = "Product to be retrieved not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Product could not be retrieved !")
    })
    @GetMapping(value = "/getall", produces = "application/json")
    public ResponseEntity<?> getAllProducts() {
        logger.info("Calling Product Service - Get All");
        return service.getAllProducts();
    }

    /**
     * @return list of Product Entities
     */
    @ApiOperation(value = "Get all Products by brand", notes = "Get all existing Products", response = ArrayList.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Product !"),
            @ApiResponse(code = 404, message = "Product to be retrieved not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Product could not be retrieved !")
    })
    @GetMapping(value = "/getbybrand/{id}", produces = "application/json")
    public ResponseEntity<?> getByBrand(@PathVariable Integer id) {
        logger.info("Calling Product Service - getbybrand");
        return service.getProductByBrand(id);
    }

    /**
     * @return list of Product Entities
     */
    @ApiOperation(value = "Get all Products by Category", notes = "Get all existing Products", response = ArrayList.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Product !"),
            @ApiResponse(code = 404, message = "Product to be retrieved not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Product could not be retrieved !")
    })
    @GetMapping(value = "/getbycategory/{id}", produces = "application/json")
    public ResponseEntity<?> getByCategory(@PathVariable Integer id) {
        logger.info("Calling Product Service - getbybcategory");
        return service.getProductByCategory(id);
    }
}
