package com.rwi.e.billing.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rwi.e.billing.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer ,Integer> {

}
