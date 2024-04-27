package com.rwi.e.billing.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Product_Details")
@AllArgsConstructor
@Data
public class Product_Entity {
	public Product_Entity() {
		System.out.println("Product_Entity.Product_Entity()");
	}
	@Id
	@GeneratedValue

	@Column(name = "Id")
	private int Id;
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "companyName", nullable = false)
	private String companyName;

	@Column(name = "price")
	private Double price;
	
	@Column(name = "mfd", nullable = false)
	private Date mfd;
	@Column(name = "exp", nullable = false)
	private Date exp;
	@Column(name = "units", nullable = false)
	private int units;
	@Column(name = "discount")
	private double discount;
	@Column(name = "gst")
	private double gst;


}
