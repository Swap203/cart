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
import com.app.cart.entity.CategoryOffer;
import com.app.cart.service.CategoryOfferService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Omkar Nikam
 * @since 06-Feb-2018
 * Rest Controller for Category Offer APIs
 */

@RestController
@RequestMapping("/categoryoffer")
public class CategoryOfferController {

	private static final Logger logger=Logger.getLogger(CategoryOfferController.class);
	
	@Autowired
	CategoryOfferService service;
	
	/**
	 * @param categoryOffer - the entity CategoryOffer
	 * @return id of the persisted CategoryOffer entity
	 */
	@ApiOperation(value = "Add a Category Offer", notes = "Creates a new Category Offer", response = Integer.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully added a new Category Offer !"),
			@ApiResponse(code = 422, message = "Something went wrong, Category Offer could not be added !")
	})
	@PostMapping(value = "/add", produces = "application/json")
	public ResponseEntity<?> addCategoryOffer(@RequestBody CategoryOffer categoryOffer) {
		
		logger.info("Calling CategoryOffer Service - Add : " + categoryOffer);
		return service.addCategoryOffer(categoryOffer);
	}
	
	/**
	 * @param id - id of the CategoryOffer to be edited
	 * @param categoryOffer - the entity CategoryOffer
	 * @return the edited entity CategoryOffer
	 */
	@ApiOperation(value = "Edit a Category Offer", notes = "Updates an existing Category Offer", response = CategoryOffer.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully updated a Category Offer !"),
			@ApiResponse(code = 404, message = "Category Offer to be edited not found !"),
			@ApiResponse(code = 422, message = "Something went wrong, Category Offer could not be updated !")
	})
	@PutMapping(value = "/edit/{id}", produces = "application/json")
	public ResponseEntity<?> editCategoryOffer(@PathVariable Integer id, @RequestBody CategoryOffer categoryOffer) {
		
		logger.info("Calling CategoryOffer Service - Edit, id : " + id + ", categoryOffer :" + categoryOffer);
		return service.editCategoryOffer(id, categoryOffer);
	}
	
	/**
	 * @param id - id of the CategoryOffer to be deleted
	 * @return the deleted entity CategoryOffer
	 */
	@ApiOperation(value = "Delete a Category Offer", notes = "Deletes an existing Category Offer", response = CategoryOffer.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully deleted a Category Offer !"),
			@ApiResponse(code = 404, message = "Category Offer to be deleted not found !"),
			@ApiResponse(code = 422, message = "Something went wrong, Category Offer could not be deleted !")
	})
	@DeleteMapping(value = "/delete/{id}", produces = "application/json")
	public ResponseEntity<?> deleteCategoryOffer(@PathVariable Integer id) {
		
		logger.info("Calling CategoryOffer Service - Delete, id : " + id);
		return service.deleteCategoryOffer(id);
	}
	
	/**
	 * 
	 * @param id - id of the CategoryOffer to be retrieved
	 * @return the requested entity CategoryOffer
	 */
	@ApiOperation(value = "Get a Category Offer", notes = "Get an existing Category Offer", response = CategoryOffer.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved a Category Offer !"),
			@ApiResponse(code = 404, message = "Category Offer to be retrieved not found !"),
			@ApiResponse(code = 422, message = "Something went wrong, Category Offer could not be retrieved !")
	})
	@GetMapping(value = "/get/{id}", produces = "application/json")
	public ResponseEntity<?> getCategoryOffer(@PathVariable Integer id) {
		
		logger.info("Calling CategoryOffer Service - Get, id : " + id);
		return service.getCategoryOffer(id);
	}
	
	/**
	 * @return list of CategoryOffer Entities
	 */
	@ApiOperation(value = "Get all Category Offers", notes = "Get all existing Category Offers", response = ArrayList.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved all Category Offers !"),
			@ApiResponse(code = 404, message = "Category Offers to be retrieved not found !"),
			@ApiResponse(code = 422, message = "Something went wrong, Category Offers could not be retrieved !")
	})
	@GetMapping(value = "/getall", produces = "application/json")
	public ResponseEntity<?> getAllCategoryOffers() {
		
		logger.info("Calling CategoryOffer Service - Get All");
		return service.getAllCategoryOffers();
	}
	
	/**
	 * @param categoryId - id of the Category of which the offers are to be retrieved
	 * @return list of CategoryOffer Entities
	 */
	@ApiOperation(value="Get a List of Category Offers by Category Id", notes="Get a List of existing Category Offers by Category Id", response=ArrayList.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved all Category Offers by Category Id!"),
			@ApiResponse(code = 404, message = "Category Offers of Category to be retrieved not found!"),
			@ApiResponse(code = 422, message = "Something went wrong, Category Offers of Category could not be retrieved !")
	})
	@GetMapping(value = "/getbycategory/{categoryId}", produces = "application/json")
	public ResponseEntity<?> getOffersByCategoryId(@PathVariable Integer categoryId){
		
		logger.info("Calling CategoryOffer Service - Get Offers by Category Id");
		return service.getOffersByCategoryId(categoryId);
	}
}
