package com.test.shop;

public class ShopMember {
	
	//mui88,g5r7M8m0Q4,느루벼리,442316257,01085503833,로맨틱,걸리쉬,서울시 동작구 역삼동 475번지,우재연,2
	
	private String id;
	private String password;
	private String shopName;
	private String businessNumber;
	private String shopTel;
	private String style1;
	private String style2;
	private String shopAddress;
	private String ceoName;
	private int shopPenalty;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getBusinessNumber() {
		return businessNumber;
	}
	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}
	public String getShopTel() {
		return shopTel;
	}
	public void setShopTel(String shopTel) {
		this.shopTel = shopTel;
	}
	public String getStyle1() {
		return style1;
	}
	public void setStyle1(String style1) {
		this.style1 = style1;
	}
	public String getStyle2() {
		return style2;
	}
	public void setStyle2(String style2) {
		this.style2 = style2;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public String getCeoName() {
		return ceoName;
	}
	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}
	public int getShopPenalty() {
		return shopPenalty;
	}
	public void setShopPenalty(int shopPenalty) {
		this.shopPenalty = shopPenalty;
	}
	public ShopMember(String id, String password, String shopName, String businessNumber, String shopTel, String style1,
			String style2, String shopAddress, String ceoName, int shopPenalty) {
		this.id = id;
		this.password = password;
		this.shopName = shopName;
		this.businessNumber = businessNumber;
		this.shopTel = shopTel;
		this.style1 = style1;
		this.style2 = style2;
		this.shopAddress = shopAddress;
		this.ceoName = ceoName;
		this.shopPenalty = shopPenalty;
	}
	
	@Override
	public String toString() {
		return "ShopMember [id=" + id + ", password=" + password + ", shopName=" + shopName + ", businessNumber="
				+ businessNumber + ", shopTel=" + shopTel + ", style1=" + style1 + ", style2=" + style2
				+ ", shopAddress=" + shopAddress + ", ceoName=" + ceoName + ", shopPenalty=" + shopPenalty + "]";
	}

}
