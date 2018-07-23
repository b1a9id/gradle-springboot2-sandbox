package com.example.sandbox.repository;

import com.example.sandbox.entity.Brand;
import com.example.sandbox.model.Gender;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class BrandRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private BrandRepository brandRepository;

	@BeforeEach
	void beforeEach() {
		entityManager.persist(createBrand("STOF", Gender.UNISEX));
		entityManager.persist(createBrand("ETHOSENS", Gender.MAN));
	}

	@Test
	void findByGender() {
		Assertions.assertThat(brandRepository.findByGender(Gender.MAN))
				.hasSize(1);
	}

	private Brand createBrand(String name, Gender gender) {
		Brand brand = new Brand();
		brand.setName(name);
		brand.setGender(gender);
		return brand;
	}

}