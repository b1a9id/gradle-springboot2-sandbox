package com.example.sandbox.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.function.Supplier;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BrandRepositoryImplTest {

	@Autowired
	private BrandRepository brandRepository;

	@BeforeEach
	void beforeEach() {
		System.out.println("==========");
	}

	@AfterEach
	void afterEach() throws Exception {
		System.out.println("==========");
		Thread.sleep(3_000);
	}

	@RepeatedTest(value = 3, name = "{displayName} {currentRepetition}/{totalRepetitions}")
	@DisplayName("getBrandsキャッシュできるかな？")
	void getBrands(){
		time(() -> brandRepository.getBrands());
	}

	@ParameterizedTest(name = "[{index}] name = ''{0}''")
	@ValueSource(strings = {"STOF", "bedsidedrama", "Dulcamara", "sneeuw", "STOF", "BEDSIDEDRAMA"})
	@DisplayName("getBrandキャッシュできるかな？")
	void getBrand(String name) {
		System.out.println("Arg: [" + name + "]");
		time(() -> brandRepository.getByName(name));
	}

	private void time(Supplier supplier) {
		long start = System.currentTimeMillis();
		System.out.println(supplier.get());
		long end = System.currentTimeMillis();
		System.out.println(" [" + (end - start) + "] msec");
	}
}
