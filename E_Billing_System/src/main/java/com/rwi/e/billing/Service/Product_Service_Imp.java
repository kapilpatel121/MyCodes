package com.rwi.e.billing.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rwi.e.billing.Entity.Product_Entity;
import com.rwi.e.billing.dto.Product_Dto;
import com.rwi.e.billing.repository.Product_Repository;
@Service
public class Product_Service_Imp implements Product_Service{
	@Autowired
	private Product_Repository product_Repository;
	@Override
	public ResponseEntity<?> addProduct(Product_Dto product_Dto) {
		try {
		Optional<Product_Entity>ProductID=product_Repository.findById(product_Dto.getId());
		if(ProductID.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Product already exists");
		}
		Product_Entity addproduct=new Product_Entity();
		addproduct.setName(product_Dto.getName());
			addproduct.setDiscount(product_Dto.getDiscount());
			addproduct.setPrice(product_Dto.getPrice());
			addproduct.setUnits(product_Dto.getUnits());
			addproduct.setMfd(product_Dto.getMfd());
			addproduct.setExp(product_Dto.getExp());
			addproduct.setGst(product_Dto.getGst());
		product_Repository.save(addproduct);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Product add success");
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Getting Some error");
		}
	}
	@Override
	public ResponseEntity<List<Product_Dto>> getAllProduct() {
	    List<Product_Dto> prod = new ArrayList<>();
	    try {
	        List<Product_Entity> entityList = product_Repository.findAll();
	        
	        // Mapping entity objects to DTO objects
	        for (Product_Entity entity : entityList) {
	            Product_Dto dto = new Product_Dto();
	            BeanUtils.copyProperties(entity, dto);
	            prod.add(dto);
	        }
	        
	        // Returning success response with the list of DTOs
	        return ResponseEntity.status(HttpStatus.OK).body(prod);
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Returning error response
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	        
	    }
	}
}