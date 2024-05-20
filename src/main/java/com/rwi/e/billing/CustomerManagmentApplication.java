package com.rwi.e.billing;

import java.sql.SQLException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rwi.e.billing.entity.Bill_Entity;
import com.rwi.e.billing.entity.Customer;
import com.rwi.e.billing.service.BillingServiceImpl;
import com.rwi.e.billing.service.IBillingService;

@SpringBootApplication
public class CustomerManagmentApplication {
  //  @Autowired
	//private static  ICustomerService     customerService;
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = SpringApplication.run(CustomerManagmentApplication.class, args);

		IBillingService billService = ctx.getBean("BillingService", BillingServiceImpl.class);
		
		//CustomerServiceImpl customerService = ctx.getBean("customerService", CustomerServiceImpl.class);

		
		  Customer customer = new Customer("Ganesh", "example@gamil.com", "7896528522");
		  Bill_Entity bill = new Bill_Entity("Cash", 1450.0, 4, customer);
		  billService.SaveBillInfo(bill);
		  System.out.println("---------------------------------------------------------");
		  List<Bill_Entity> bills=billService.getAllBills(); 
		  System.out.println(bills);
		 
    
		
		//List<Customer>  customer=customerService.getAllCustomer();
		System.out.println(customer);
	}

}
