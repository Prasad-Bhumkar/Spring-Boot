package com.seed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootApplication2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootApplication2Application.class, args);
        Product product = context.getBean(Product.class);
        System.out.println(product);

        //this is how we can pass values to the constructor from here like code, name, price, and myDate
		Product product1 = context.getBean("product", Product.class);
		product1.setCode(101);
		product1.setName("Laptop");
		product1.setPrice(45000);
		product1.getMyDate().setDay(10);
		product1.getMyDate().setMonth(10);
		product1.getMyDate().setYear(2021);
		System.out.println(product1);

        Product product2 = context.getBean("product", Product.class);
		product2.setCode(102);
		product2.setName("Mobile");
		product2.setPrice(30000);
		product2.getMyDate().setDay(20);
		product2.getMyDate().setMonth(10);
		product2.getMyDate().setYear(2021);
		System.out.println(product2);
        

        context.close();
    }
}