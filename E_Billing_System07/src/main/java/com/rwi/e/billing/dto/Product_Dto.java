package com.rwi.e.billing.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Product_Dto {

	private int Id;
	private String name;
	private Double price;
	private Date mfd;
	private Date exp;
	private int units;
	private double discount;
	private double gst;
	private String company_name;
	
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
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
	@Override
	public String toString() {
		return "\nProduct_Dto [Id=" + Id + ", name=" + name + ", price=" + price + ", mfd=" + mfd + ", exp=" + exp
				+ ", units=" + units + ", discount=" + discount + ", gst=" + gst + ", company_name=" + company_name
				+ ", getCompany_name()=" + getCompany_name() + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getPrice()=" + getPrice() + ", getMfd()=" + getMfd() + ", getExp()=" + getExp() + ", getUnits()="
				+ getUnits() + ", getDiscount()=" + getDiscount() + ", getGst()=" + getGst() + "]";
	}
}
