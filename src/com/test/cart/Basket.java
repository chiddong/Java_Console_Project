package com.test.cart;

public class Basket {
	//18,iqpmuw12,258,58,342000,맛조이다원
	
	private int basketNum;
	private String basketId;
	private int basketItemCode;
	private int basketItemCount;
	private int basketItemPrice;
	private String basketShopName;
	
	
	public int getBasketNum() {
		return basketNum;
	}
	public void setBasketNum(int basketNum) {
		this.basketNum = basketNum;
	}
	public String getBasketId() {
		return basketId;
	}
	public void setBasketId(String basketId) {
		this.basketId = basketId;
	}
	public int getBasketItemCode() {
		return basketItemCode;
	}
	public void setBasketItemCode(int basketItemCode) {
		this.basketItemCode = basketItemCode;
	}
	public int getBasketItemCount() {
		return basketItemCount;
	}
	public void setBasketItemCount(int basketItemCount) {
		this.basketItemCount = basketItemCount;
	}
	public int getBasketItemPrice() {
		return basketItemPrice;
	}
	public void setBasketItemPrice(int basketItemPrice) {
		this.basketItemPrice = basketItemPrice;
	}
	public String getBasketShopName() {
		return basketShopName;
	}
	public void setBasketShopName(String basketShopName) {
		this.basketShopName = basketShopName;
	}

	
}
