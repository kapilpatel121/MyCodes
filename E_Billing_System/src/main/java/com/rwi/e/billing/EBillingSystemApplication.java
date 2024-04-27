package com.rwi.e.billing;



import java.sql.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rwi.e.billing.Entity.Product_Entity;
import com.rwi.e.billing.Service.Product_Service;
import com.rwi.e.billing.dto.Product_Dto;

@SpringBootApplication
public class EBillingSystemApplication {
	
	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(EBillingSystemApplication.class, args);
		
	/*	Product_Service service= ctx.getBean(Product_Service.class,"productService");
		// Create a new instance of Product_Entity
		Product_Entity product = new Product_Entity();
		product.setName("Sugar");
		product.setCompanyName("Adani");
		product.setPrice(10.99);
		product.setMfd(Date.valueOf("2024-01-01"));
		product.setExp(Date.valueOf("2025-12-31"));
		product.setUnits(100);
		product.setDiscount(0.5);
		product.setGst(18.0);
		Product_Dto dto =new  Product_Dto();
		BeanUtils.copyProperties(product, dto);
		// Save the product instance using your repository or EntityManager
		service.addProduct(dto);
*/
	}

}
