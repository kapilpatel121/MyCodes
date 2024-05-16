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
*/
	}

}
