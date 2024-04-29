package com.rwi.e.billing.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.rwi.e.billing.dto.Product_Dto;

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
			return ResponseEntity.status(HttpStatus.OK).body("Bill added successfully");
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
			List<String> productNames = productService.getItemNames();

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

   @GetMapping("/getProductDetails")
	 public ResponseEntity<Product_Dto> getProductDetailsByName(@RequestParam String productName) {
        try {
        	Product_Dto product = productService.getDeatilsByName(productName);
            if (product != null) {
                return ResponseEntity.ok(product);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
	 @CrossOrigin(origins = "http://127.0.0.1:5500") 
	 @PostMapping("/sendProductList")
	    public ResponseEntity<String> sendProductList(@RequestBody List<Map<String,Integer>> productList) {
	     System.out.println("EBillingContoller.sendProductList()"); 
		 // Handle the productList received from the client
	        if (productList != null && !productList.isEmpty()) {
	           System.out.println(productList);
	            // Return a success response
	            return ResponseEntity.ok("Product list received successfully");
	        } else {
	            // Return an error response if the productList is empty or null
	            return ResponseEntity.badRequest().body("Product list is empty or invalid");
	        }
	    }


	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping("/maxQuantity")
	public Integer getMaxQuantityByProductName(@RequestParam String productName) {
		return productService.getUnits(productName);
	}

}