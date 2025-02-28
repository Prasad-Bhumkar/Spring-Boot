package com.seed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootLombokApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootLombokApplication.class, args);
		
		//address varible and passing values using context getbean to constructor
		Address address = context.getBean(Address.class);
		address.setCity("Bangalore");
		address.setState("KA");	
		System.out.println(address);

		//mydate
		MyDate dob = context.getBean(MyDate.class);
		dob.setDay(10);
		dob.setMonth(10);
		dob.setYear(1990);
		System.out.println(dob);

		//
		Customer customer = context.getBean(Customer.class);
		customer.setAddress(address);
		customer.setDateOfBirth(dob);
		customer.setCustomerId(1001);
		customer.setCustomerName("Raj");
		
		System.out.println(customer);

		
	}

}