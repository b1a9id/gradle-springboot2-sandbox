package com.example.sandbox.repository;

import com.example.sandbox.entity.Brand;
import com.example.sandbox.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

	List<Brand> findByGender(Gender gender);
}
