package com.rwi.e.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rwi.e.billing.Entity.Bill_Entity;

public interface IBillRepository extends JpaRepository<Bill_Entity, Integer> {

}
