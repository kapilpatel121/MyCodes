package com.rwi.e.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rwi.e.billing.Service.IBillingService;
import com.rwi.e.billing.dto.Customer;

@RestController
public class EBillingContoller {

    @Autowired
    private IBillingService billService;
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/api/customers/addBill")
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
}
