package com.test.posting;

public class Comments {
	
//	7,4,우와 정말 사고 싶어요,pvdybl42
	
	private String commentIndex;
	private String postIndex;
	private String comment;
	private String id;
	
	public String getCommentIndex() {
		return commentIndex;
	}
	public void setCommentIndex(String commentIndex) {
		this.commentIndex = commentIndex;
	}
	public String getPostIndex() {
		return postIndex;
	}
	public void setPostIndex(String postIndex) {
		this.postIndex = postIndex;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Comments(String commentIndex, String postIndex, String comment, String id) {
		this.commentIndex = commentIndex;
		this.postIndex = postIndex;
		this.comment = comment;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Comments [commentIndex=" + commentIndex + ", postIndex=" + postIndex + ", comment=" + comment + ", id="
				+ id + "]";
	}

}
