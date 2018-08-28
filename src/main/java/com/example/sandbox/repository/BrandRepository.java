package com.example.sandbox.repository;

import com.example.sandbox.entity.Brand;

import java.util.List;

public interface BrandRepository {

	Brand getByName(String name);

	List<Brand> getBrands();
}
