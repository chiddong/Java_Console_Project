package com.test.posting;

public class Post {
	
	//10,내용,98,ieou46,171,시티보이
	
	private String postIndex;
	private String postContents;
	private int like;
	private String id;
	private int itemCode;
	private String style;
	
	public String getPostIndex() {
		return postIndex;
	}
	public void setPostIndex(String postIndex) {
		this.postIndex = postIndex;
	}
	public String getPostContents() {
		return postContents;
	}
	public void setPostContents(String postContents) {
		this.postContents = postContents;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
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
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	

	
	@Override
	public String toString() {
		return "Post [postIndex=" + postIndex + ", postContents=" + postContents + ", like=" + like + ", id=" + id
				+ ", itemCode=" + itemCode + ", style=" + style + "]";
	}

}
