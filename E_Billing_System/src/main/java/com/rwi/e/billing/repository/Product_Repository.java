package com.rwi.e.billing.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rwi.e.billing.Entity.Product_Entity;

public interface Product_Repository extends JpaRepository<Product_Entity, Integer>{
	Optional<Product_Entity> findById(int Id);
}
