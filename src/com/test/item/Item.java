package com.test.item;

import com.test.cart.Basket;

public class Item {
	
	//7,하와이 레더 티셔츠,S,52,234000,2,상의,시티보이,마파람라온제나
	// 상품코드,상품이름,사이즈(S,M,L),수량,가격,판매량,카테고리,스타일,판매쇼핑몰
	
	private int itemCode;
	private String itemName;
	private String size;
	private int itemCount;
	private int price;
	private int sellCount;
	private String category;
	private String style;
	private String shopName;
	
	public int getItemCode() {
		return itemCode;
	}
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSellCount() {
		return sellCount;
	}
	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	public Item(int itemCode, String itemName, String size, int itemCount, int price, int sellCount, String category,
			String style, String shopName) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.size = size;
		this.itemCount = itemCount;
		this.price = price;
		this.sellCount = sellCount;
		this.category = category;
		this.style = style;
		this.shopName = shopName;
	}
	
	public String info() {
	      String array = String.format("%s%s%s%s%s%s%s%s%s%s\n"
					, itemCode
					, itemName
					, size
					, itemCount
					, price
					, sellCount
					, category
					, style
					, shopName);
	      
	      return array +"\r\n";
	   }
		
	public String getItemName(int itemCode) {

		return itemName;
	}
	
//	@Override
//	public String toString() {
//		return "Item [itemCode=" + itemCode + ", itemName=" + itemName + ", size=" + size + ", itemCount=" + itemCount
//				+ ", price=" + price + ", sellCount=" + sellCount + ", category=" + category + ", style=" + style
//				+ ", shopName=" + shopName + "]";
//	}

}
