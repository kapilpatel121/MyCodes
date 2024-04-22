package com.rwi.e.billing.Service;

import org.springframework.http.ResponseEntity;

import com.rwi.e.billing.dto.Product_Dto;

import jakarta.xml.ws.Response;

public interface Product_Service {
	ResponseEntity<?> addProduct(Product_Dto product_Dto);
	ResponseEntity<?> getAllProduct();
}
