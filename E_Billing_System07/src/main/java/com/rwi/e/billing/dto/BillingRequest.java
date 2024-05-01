package com.rwi.e.billing.dto;

import java.util.Map;

public class BillingRequest {
	private Customer cust;
	private Map<String, Integer> productMap;
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	public Map<String, Integer> getProductMap() {
		return productMap;
	}
	public void setProductMap(Map<String, Integer> productMap) {
		this.productMap = productMap;
	}

}
