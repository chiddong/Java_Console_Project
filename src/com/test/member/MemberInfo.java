package com.test.member;

public class MemberInfo {
	
	//oydrii07,q2g7J4t2T8,김연형,2,19620903,01060204026,서울시 송파구 역삼동 77번지,2
	
	private String id;
	private String password;
	private String name;
	private int gender;
	private String birth;
	private String tel;
	private String address;
	private int memberPenalty;
	
	public int getMemberPenalty() {
		return memberPenalty;
	}
	public void setMemberPenalty(int memberPenalty) {
		this.memberPenalty = memberPenalty;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public MemberInfo(String id, String password, String name, int gender, String birth, String tel, String address,
			int memberPenalty) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.tel = tel;
		this.address = address;
		this.memberPenalty = memberPenalty;
	}
	
	@Override
	public String toString() {
		return "MemberInfo [id=" + id + ", password=" + password + ", name=" + name + ", gender=" + gender + ", birth="
				+ birth + ", tel=" + tel + ", address=" + address + ", memberPenalty=" + memberPenalty + "]";
	}

}
