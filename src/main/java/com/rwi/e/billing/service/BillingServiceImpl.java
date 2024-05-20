package com.rwi.e.billing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rwi.e.billing.entity.Bill_Entity;
import com.rwi.e.billing.entity.Customer;
import com.rwi.e.billing.repo.BillingRepository;

@Service("BillingService")
public class BillingServiceImpl implements IBillingService {

	@Autowired
	private BillingRepository billRepo;

	@Override
	public int SaveBillInfo(Bill_Entity bill) {
		try {
			return billRepo.save(bill).getId();

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public List<Bill_Entity> getAllBills() {
		List<Customer> bill = new ArrayList<>();
		try {
			List<Bill_Entity> entityList = billRepo.findAll();
			// Returning success response with the list of DTOs
			return entityList;
		} catch (Exception e) {
			e.printStackTrace();
			// Returning error response
			return null;

		}
	}
}