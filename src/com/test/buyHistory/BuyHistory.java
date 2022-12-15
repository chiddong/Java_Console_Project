package com.test.buyHistory;

public class BuyHistory {
	
	//wble83,192,1,달보드레느루
	
	private String id;
	private int itemCode;
	private int itemCount;
	private String shopName;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getItemCode() {
		return itemCode;
	}
	
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
	
	public int getItemCount() {
		return itemCount;
	}
	
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	
	public String getShopName() {
		return shopName;
	}
	
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	public BuyHistory(String id, int itemCode, int itemCount, String shopName) {
		this.id = id;
		this.itemCode = itemCode;
		this.itemCount = itemCount;
		this.shopName = shopName;
	}

	@Override
	public String toString() {
		return "BuyHistory [id=" + id + ", itemCode=" + itemCode + ", itemCount=" + itemCount + ", shopName=" + shopName
				+ "]";
	}

}
