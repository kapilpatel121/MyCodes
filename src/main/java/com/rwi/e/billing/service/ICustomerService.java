package com.rwi.e.billing.service;

import java.util.List;

import com.rwi.e.billing.entity.Customer;

public interface ICustomerService {

	public int SaveCustomerInfo(Customer customer);
	public List<Customer> getAllCustomer() ;
	public Customer getCustomerById(int id);

}
