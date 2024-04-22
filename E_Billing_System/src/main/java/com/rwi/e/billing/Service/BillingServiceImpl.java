package com.rwi.e.billing.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rwi.e.billing.Entity.Bill_Entity;
import com.rwi.e.billing.dto.Customer;
import com.rwi.e.billing.repository.IBillRepository;

@Service
public class BillingServiceImpl implements IBillingService {

	@Autowired
	private IBillRepository billRepo;



	@Override
	public void SaveBillInfo(Customer customer) {
		 Bill_Entity entity=new Bill_Entity();
	       entity.setName(customer.getCustomerName());
	       entity.setContactNo(customer.getContactNumber());
	       entity.setEmail(customer.getEmail());
	       entity.setPaymentType(customer.getPaymentMode());
	       entity.setTotalAmount(customer.getTotalAmount());
	        billRepo.save(entity);
		
	}


}
