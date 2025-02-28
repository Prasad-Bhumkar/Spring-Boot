package com.seed.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "products") // Specifies table name
public class Product {

    @Id
    @Column(name = "product_code")
    private int code;

    @Column(name = "product_name", length = 50)
    private String name;

    @Column(name = "product_price")
    private double price;

    // Default constructor
    public Product() {
    }

    // Parameterized constructor
    public Product(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

 // toString Method
	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", price=" + price + "]";
	}

    
    
}

