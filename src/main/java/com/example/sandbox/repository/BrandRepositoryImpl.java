package com.example.sandbox.repository;

import com.example.sandbox.entity.Brand;
import com.example.sandbox.model.Gender;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BrandRepositoryImpl implements BrandRepository {

	@Override
	@Cacheable("brands")
	public Brand getByName(String name) {
		simulateSlowService();
		return Brand.builder().id(1).name(name).gender(Gender.UNISEX).build();
	}

	@Override
	@Cacheable("brandList")
	public List<Brand> getBrands() {
		simulateSlowService();
		return Arrays.asList(
				Brand.builder().id(1).name("STOF").gender(Gender.UNISEX).build(),
				Brand.builder().id(2).name("bedsidedrama").gender(Gender.UNISEX).build(),
				Brand.builder().id(3).name("Dulcamara").gender(Gender.UNISEX).build(),
				Brand.builder().id(4).name("sneeuw").gender(Gender.UNISEX).build(),
				Brand.builder().id(5).name("Portaille").gender(Gender.UNISEX).build(),
				Brand.builder().id(1).name("ETHOSENS").gender(Gender.UNISEX).build()
		);
	}

	private void simulateSlowService() {
		try {
			long time = 3000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
}
