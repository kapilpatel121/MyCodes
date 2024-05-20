package com.rwi.e.billing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rwi.e.billing.entity.Customer;
import com.rwi.e.billing.repo.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository custRepo;

	@Override
	public int SaveCustomerInfo(Customer customer) {
		try {
			return custRepo.save(customer).getId();

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> bill = new ArrayList<>();
		try {
			List<Customer> entityList = custRepo.findAll();
			// Returning success response with the list of DTOs
			return entityList;
		} catch (Exception e) {
			e.printStackTrace();
			// Returning error response
			return null;

		}
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return custRepo.getById(id);
	}
}