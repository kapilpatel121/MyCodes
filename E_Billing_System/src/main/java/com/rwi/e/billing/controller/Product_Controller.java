package com.rwi.e.billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rwi.e.billing.Entity.Product_Entity;
import com.rwi.e.billing.Service.Product_Service;
import com.rwi.e.billing.dto.Product_Dto;

@RestController
@RequestMapping("/rwi/ebill/api")
public class Product_Controller {
    @Autowired
    private Product_Service product_Service;
    
	/* @CrossOrigin(origins = "http://127.0.0.1:5500") */
    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product_Dto request) {
        return product_Service.addProduct(request);
    }
    
    // Endpoint to retrieve all products
	/* @CrossOrigin(origins = "http://127.0.0.1:5500") */
    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product_Entity>> getAllProducts() {
        List<Product_Entity> products = product_Service.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    
 // Endpoint to retrieve all products
	/* @CrossOrigin(origins = "http://127.0.0.1:5500") */
    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product_Entity> getProductById(@PathVariable("id") int id) {
        Product_Entity product = product_Service.getProductDeatilsById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    // Endpoint to update an existing product
	/* @CrossOrigin(origins = "http://127.0.0.1:5500") */
    @PostMapping("/updateProduct")
    public ResponseEntity<Product_Entity> updateProduct(@PathVariable("id") int id, @RequestBody Product_Entity product) {
        Product_Entity updatedProduct = product_Service.updateProduct(id, product);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete a product by ID
	/* @CrossOrigin(origins = "http://127.0.0.1:5500") */
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") int id) {
    	product_Service.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
