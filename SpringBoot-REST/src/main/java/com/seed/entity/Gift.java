package com.seed.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gift_shop")
public class Gift {

	@Id
	@Column(name = "GIFTID")
	private int giftId;
	
	@Column(name = "GIFTNAME")
	private String giftName;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "price")
	private int price;

	public Gift() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gift(int giftId, String giftName, String category, int price) {
		super();
		this.giftId = giftId;
		this.giftName = giftName;
		this.category = category;
		this.price = price;
	}

	public int getGiftId() {
		return giftId;
	}

	public void setGiftId(int giftId) {
		this.giftId = giftId;
	}

	public String getGiftName() {
		return giftName;
	}

	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Gift [giftId=" + giftId + ", giftName=" + giftName + ", category=" + category + ", price=" + price
				+ "]";
	}
	
	
	
}
