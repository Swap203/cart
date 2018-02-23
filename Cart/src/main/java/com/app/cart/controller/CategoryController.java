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
import com.app.cart.entity.Category;
import com.app.cart.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Omkar Nikam
 * @since 04-Feb-2018
 * Rest Controller for Category APIs
 */

@RestController
@RequestMapping("/category")
public class CategoryController {

    private static final Logger logger = Logger.getLogger(CategoryController.class);

    @Autowired
    CategoryService service;

    /**
     * @param category - the entity Category
     * @return id of the persisted Category entity
     */
    @ApiOperation(value = "Add a Category", notes = "Creates a new Category", response = Integer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully added a new Category !"),
            @ApiResponse(code = 422, message = "Something went wrong, Category could not be added !")
    })
    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {

        logger.info("Calling Category Service - Add : " + category);
        return service.addCategory(category);
    }

    /**
     * @param id       - id of the Category to be edited
     * @param category - the entity Category
     * @return the edited entity Category
     */
    @ApiOperation(value = "Edit a Category", notes = "Updates an existing Category", response = Category.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated a Category !"),
            @ApiResponse(code = 404, message = "Category to be edited not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Category could not be updated !")
    })
    @PutMapping(value = "/edit/{id}", produces = "application/json")
    public ResponseEntity<?> editCategory(@PathVariable Integer id, @RequestBody Category category) {

        logger.info("Calling Category Service - Edit, id : " + id + ", category :" + category);
        return service.editCategory(id, category);
    }

    /**
     * @param id - id of the Category to be deleted
     * @return the deleted entity Category
     */
    @ApiOperation(value = "Delete a Category", notes = "Deletes an existing Category", response = Category.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted a Category !"),
            @ApiResponse(code = 404, message = "Category to be deleted not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Category could not be deleted !")
    })
    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {

        logger.info("Calling Category Service - Delete, id : " + id);
        return service.deleteCategory(id);
    }

    /**
     * @param id - id of the Category to be retrieved
     * @return the requested entity Category
     */
    @ApiOperation(value = "Get a Category", notes = "Get an existing Category", response = Category.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved a Category !"),
            @ApiResponse(code = 404, message = "Category to be retrieved not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Category could not be retrieved !")
    })
    @GetMapping(value = "/get/{id}", produces = "application/json")
    public ResponseEntity<?> getCategory(@PathVariable Integer id) {

        logger.info("Calling Category Service - Get, id : " + id);
        return service.getCategory(id);
    }

    /**
     * @return list of Category Entities
     */
    @ApiOperation(value = "Get all Categories", notes = "Get all existing Categories", response = ArrayList.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Categories !"),
            @ApiResponse(code = 404, message = "Categories to be retrieved not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Categories could not be retrieved !")
    })
    @GetMapping(value = "/getall", produces = "application/json")
    public ResponseEntity<?> getAllCategories() {

        logger.info("Calling Category Service - Get All");
        return service.getAllCategories();
    }

    /**
     * @return list of Sub Category Entities
     */
    @ApiOperation(value = "Get all Sub-Categories", notes = "Get all existing Sub-Categories", response = ArrayList.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Sub-Categories !"),
            @ApiResponse(code = 404, message = "Sub-Categories to be retrieved not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Sub-Categories could not be retrieved !")
    })
    @GetMapping(value = "/getallsubcategories", produces = "application/json")
    public ResponseEntity<?> getAllSubCategories() {

        logger.info("Calling Category Service - Get All Sub Categories");
        return service.getAllSubCategories();
    }

    /**
     * @return list of Parent Category Entities
     */
    @ApiOperation(value = "Get all Parent-Categories", notes = "Get all existing Parent-Categories", response = ArrayList.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Parent-Categories !"),
            @ApiResponse(code = 404, message = "Parent-Categories to be retrieved not found !"),
            @ApiResponse(code = 422, message = "Something went wrong, Parent-Categories could not be retrieved !")
    })
    @GetMapping(value = "/getallparentcategories", produces = "application/json")
    public ResponseEntity<?> getAllParentCategories() {

        logger.info("Calling Category Service - Get All Parent Categories");
        return service.getAllParentCategories();
    }

}
