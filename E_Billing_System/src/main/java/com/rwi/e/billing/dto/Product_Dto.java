package com.rwi.e.billing.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Product_Dto {

	public Product_Dto() {
		System.out.println("Product_Dto.Product_Dto()");
	}
	private int Id;
	private String name;
	private String companyName;	
	private Double price;
	private Date mfd;
	private Date exp;
	private int units;
	private double discount;
	private double gst;
	
	
}
