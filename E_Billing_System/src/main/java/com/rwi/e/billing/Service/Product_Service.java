package com.rwi.e.billing.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rwi.e.billing.Entity.Product_Entity;
import com.rwi.e.billing.dto.Product_Dto;

import jakarta.xml.ws.Response;

public interface Product_Service {
	ResponseEntity<?> addProduct(Product_Dto product_Dto);
	ResponseEntity<?> getAllProduct();
	List<String> getItemNames();
	/* public Product_Dto getDeatailsByName(String name); */
	public Integer getUnits(String name);
	public Double  getPrice(String productName, int quantity);
	List<Product_Entity> getAllProducts();
	void deleteProduct(int id);
	Product_Entity updateProduct(int id, Product_Entity product);
	Product_Entity getProductDeatilsById(int id);
}
