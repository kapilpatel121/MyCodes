package com.rwi.e.billing.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rwi.e.billing.entity.Bill_Entity;

public interface BillingRepository extends JpaRepository<Bill_Entity, Integer> {

}
