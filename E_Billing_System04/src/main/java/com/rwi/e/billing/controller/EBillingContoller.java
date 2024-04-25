package com.rwi.e.billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rwi.e.billing.Service.IBillingService;
import com.rwi.e.billing.Service.Product_Service;
import com.rwi.e.billing.dto.Customer;
import com.rwi.e.billing.dto.ProductRequest;

@RestController
@RequestMapping("/api/customers")
public class EBillingContoller {

	@Autowired
	private IBillingService billService;
	
	@Autowired
	private Product_Service productService;

	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping("/addBill")
	public ResponseEntity<String> addBill(@RequestBody Customer customerData) {
		try {
			// Here, you would call your service method to handle the bill addition
			billService.SaveBillInfo(customerData);
			return ResponseEntity.status(HttpStatus.CREATED).body("Bill added successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding bill");
		}
	}

	@CrossOrigin(origins = "http://127.0.0.1:5500")
	 @GetMapping("/getProduct")
	    public String getProductNames() {
	        try {
	            // Fetch product names from the repository
	            List<String> productNames =productService.getItemNames();
	            
	            // Convert the list of product names to JSON
	            ObjectMapper mapper = new ObjectMapper();
	            String jsonProductNames = mapper.writeValueAsString(productNames);
	            
	            // Return the JSON response
	            return jsonProductNames;
	        } catch (JsonProcessingException e) {
	            // Handle JSON processing exception
	            e.printStackTrace();
	            return "{\"error\": \"An error occurred while processing the JSON response.\"}";
	        }
	    }

		/*
		 * @CrossOrigin(origins = "http://127.0.0.1:5500")
		 * 
		 * @GetMapping("/details") public Product_Dto getProductDetails(@RequestParam
		 * String name) { // Fetch product details based on the product name return
		 * productService.getDeatailsByName(name); }
		 */
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	 @GetMapping("/maxQuantity")
	    public Integer getMaxQuantityByProductName(@RequestParam String productName) {
	        return productService.getUnits(productName);
	    }
	
	 @PostMapping("/getPrice")
	    public ResponseEntity<?> getPrice(@RequestBody ProductRequest request) {
	        String productName = request.getProductName();
	        int quantity = request.getQuantity();

	        if (productName == null || quantity <= 0) {
	            return ResponseEntity.badRequest().body("Product name and quantity are required");
	        }

	        // Call the ProductService to retrieve the price based on product name and quantity
	        Double price = productService.getPrice(productName, quantity);

	        if (price == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
	        }

	        // Return the price in the response
	        return ResponseEntity.ok(price);
	    }
	 }