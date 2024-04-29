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

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getMfd() {
		return mfd;
	}
	public void setMfd(Date mfd) {
		this.mfd = mfd;
	}
	public Date getExp() {
		return exp;
	}
	public void setExp(Date exp) {
		this.exp = exp;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	
	
}
