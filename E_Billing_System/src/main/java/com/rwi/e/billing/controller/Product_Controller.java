package com.rwi.e.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rwi.e.billing.Service.Product_Service;
import com.rwi.e.billing.dto.Product_Dto;

@RestController
@RequestMapping("/rwi/ebill/api")
public class Product_Controller {
    @Autowired
    private Product_Service product_Service;
    
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product_Dto request) {
        return product_Service.addProduct(request);
    }
}
