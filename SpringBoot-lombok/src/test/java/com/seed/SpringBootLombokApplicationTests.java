package com.seed;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SpringBootLombokApplicationTests {

	@Autowired
	private Customer customer;

	@Test
	void contextLoads() {
	}

	@Test
	void testCustomerBeanCreation() {
		assertNotNull(customer);
	}
}
