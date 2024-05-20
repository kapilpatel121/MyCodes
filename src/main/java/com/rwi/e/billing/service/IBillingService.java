package com.rwi.e.billing.service;

import java.util.List;

import com.rwi.e.billing.entity.Bill_Entity;

public interface IBillingService {

	public int SaveBillInfo(Bill_Entity Bill);
	public List<Bill_Entity> getAllBills() ;

}
