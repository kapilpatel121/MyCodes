package com.rwi.e.billing.dto;

import lombok.Data;

@Data
public class ProductRequest {

    private String productName;
    private int quantity;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

    // getters and setters
}
