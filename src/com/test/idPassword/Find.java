package com.test.idPassword;

import java.util.Scanner;

import com.test.data.Data;
import com.test.fashion.MainClass;
import com.test.member.MemberInfo;
import com.test.member.MemberService;
import com.test.shop.ShopMember;

public class Find {
	
	public static void finding() {
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println();
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println("                                 1. 아이디 찾기");
		System.out.println("                                 2. 비밀번호 찾기");
		System.out.println("                                 3. 뒤로가기");
		System.out.println("            └─────────────────────────────────────────────────────┘");
		System.out.print("            ▶ 선택: ");
		
		int select = scan.nextInt();
		scan.nextLine();
		
		if (select == 1) {
			
			idFinding();
			
		} else if (select == 2) {
			
			pwFinding();
			
		} else {
			
			MainClass.main(null);
		}
		
	}

	private static void pwFinding() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println("                                 1. 개인 회원");
		System.out.println("                                 2. 쇼핑몰 회원");
		System.out.println("                                 3. 뒤로가기");
		System.out.println("            └─────────────────────────────────────────────────────┘");
		System.out.print("            ▶ 선택: ");
		
		int select = scan.nextInt();
		scan.nextLine();
		
		if (select == 1) {
			
			memberPasswordCheck();
			
		} else if (select == 2) {
			
			shopPasswordCheck();
			
		} else {
			
			finding();
			
		}
		
	}

	private static void shopPasswordCheck() {
boolean flag = false;
		
		Scanner scan = new Scanner(System.in);
		System.out.println();
		
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println();
		System.out.print("                🖋 아이디: ");
		String id = scan.nextLine();

		System.out.print("                🖋 쇼핑몰 대표 번호: ");
		String shopTel = scan.nextLine();
		System.out.println();
		System.out.println("            └─────────────────────────────────────────────────────┘");
		System.out.println();
		
		for (ShopMember shopMember : Data.shopMemberList) {
			
			if(shopMember.getId().equals(id)) {
				
				shopTel = shopTel.replace("-", "");
				
				if (shopMember.getShopTel().equals(shopTel)) {
					
					System.out.println();
					System.out.println("            ┌─────────────────────────────────────────────────────┐");
					System.out.println();
					System.out.printf("                     %s 비밀번호는 %s 입니다.\n", shopMember.getShopName(), shopMember.getPassword());
					System.out.println();
					System.out.println("            └─────────────────────────────────────────────────────┘");
					
					MainClass.pause();
					System.out.println();
					
					flag = true;
					
					MainClass.printMainMenu();
					
				} else {
					
					System.out.println();
					System.out.println("            ┌─────────────────────────────────────────────────────┐");
					System.out.println();
					System.out.println("                             대표번호가 틀렸습니다.");
					System.out.println("                                다시 입력해주세요!");
					System.out.println();
					System.out.println("            └─────────────────────────────────────────────────────┘");
					MainClass.pause();
					System.out.println();
					
					shopIdCheck();
				}
			} 
		}
		
		if(!flag) {
			
			System.out.println();
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println();
			System.out.println("                         아이디 혹은 대표번호가 틀렸습니다.");
			System.out.println("                                다시 입력해주세요!");
			System.out.println();
			System.out.println("            └─────────────────────────────────────────────────────┘");
			MainClass.pause();
			System.out.println();
			
			shopIdCheck();
			
		}		
	}

	private static void memberPasswordCheck() {
		
		boolean flag = false;
		
		Scanner scan = new Scanner(System.in);
		System.out.println();
		
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println();
		System.out.print("                🖋 아이디: ");
		String id = scan.nextLine();

		System.out.print("                🖋 전화번호: ");
		String tel = scan.nextLine();
		System.out.println();
		System.out.println("            └─────────────────────────────────────────────────────┘");
		System.out.println();
		
		for (MemberInfo memberInfo : Data.memberInfoList) {
			
			if(memberInfo.getId().equals(id)) {
				
				tel = tel.replace("-", "");
				
				if (memberInfo.getTel().equals(tel)) {
					
					System.out.println();
					System.out.println("            ┌─────────────────────────────────────────────────────┐");
					System.out.println();
					System.out.printf("                     %s의 비밀번호는 %s 입니다.\n", memberInfo.getName(), memberInfo.getPassword());
					System.out.println();
					System.out.println("            └─────────────────────────────────────────────────────┘");

					System.out.println();
					MainClass.pause();
					System.out.println();
					
					flag = true;
					
					MainClass.printMainMenu();
					
				} else {
					
					System.out.println();
					System.out.println("            ┌─────────────────────────────────────────────────────┐");
					System.out.println();
					System.out.println("                             전화번호가 틀렸습니다. ");
					System.out.println("                               다시 입력해주세요!");
					System.out.println();
					System.out.println("            └─────────────────────────────────────────────────────┘");
					System.out.println();
					MainClass.pause();
					System.out.println();
					
					memberPasswordCheck();
				}
			} 
		}
		
		if(!flag) {
			
			System.out.println();
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println();
			System.out.println("                         아이디 또는 전화번호가 틀립니다. ");
			System.out.println("                               다시 입력해주세요!");
			System.out.println();
			System.out.println("            └─────────────────────────────────────────────────────┘");
			System.out.println();
			MainClass.pause();
			System.out.println();
			
			memberPasswordCheck();
			
		}
		
		
	}

	private static void idFinding() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println("                                 1. 개인 회원");
		System.out.println("                                 2. 쇼핑몰 회원");
		System.out.println("                                 3. 뒤로가기");
		System.out.println("            └─────────────────────────────────────────────────────┘");
		System.out.print("            ▶ 선택: ");
		
		int select = scan.nextInt();
		scan.nextLine();
		
		if (select == 1) {
			
			memberIdCheck();
			
		} else if (select == 2) {
			
			shopIdCheck();
			
		} else {
			
			finding();
			
		}
		
		
	}

	private static void shopIdCheck() {
		
		boolean flag = false;
		
		

		
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println();
		System.out.print("                🖋 쇼핑몰 이름: ");
		String name = scan.nextLine();

		System.out.print("                🖋 사업자 번호: ");	
		String businessNumber = scan.nextLine();
		System.out.println();
		System.out.println("            └─────────────────────────────────────────────────────┘");
		System.out.println();
		
		for (ShopMember shopMember : Data.shopMemberList) {
			
			if(shopMember.getShopName().equals(name)) {
				
				businessNumber = businessNumber.replace("-", "");
				
				if (shopMember.getBusinessNumber().equals(businessNumber)) {
					
					System.out.println();
					System.out.println("            ┌─────────────────────────────────────────────────────┐");
					System.out.println();
					System.out.printf("                      %s의 아이디는 %s 입니다.\n", shopMember.getShopName(), shopMember.getId());
					System.out.println();
					System.out.println("            └─────────────────────────────────────────────────────┘");
					System.out.println();
					MainClass.pause();
					System.out.println();
					
					flag = true;
					
					MainClass.printMainMenu();
					
				} else {
					
					System.out.println();
					System.out.println("            ┌─────────────────────────────────────────────────────┐");
					System.out.println();
					System.out.println("                            사업자 번호가 틀렸습니다. ");
					System.out.println("                               다시 입력해주세요!");
					System.out.println();
					System.out.println("            └─────────────────────────────────────────────────────┘");
					System.out.println();
					MainClass.pause();
					System.out.println();
					
					shopIdCheck();
				}
			} 
		}
		
		if(!flag) {
			
			System.out.println();
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println();
			System.out.println("                    쇼핑몰 이름 또는 사업자번호가 틀립니다.");
			System.out.println("                               다시 입력해주세요!");
			System.out.println();
			System.out.println("            └─────────────────────────────────────────────────────┘");
			System.out.println();
			MainClass.pause();
			System.out.println();
			
			shopIdCheck();
			
		}
		
	}

	private static void memberIdCheck() {
		
		boolean flag = false;
		
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println();
		System.out.print("                🖋 이름: ");
		String name = scan.nextLine();

		System.out.print("                🖋 생년월일(8자리): ");
		String birth = scan.nextLine();
		System.out.println();
		System.out.println("            └─────────────────────────────────────────────────────┘");
		System.out.println();
		
		for (MemberInfo memberInfo : Data.memberInfoList) {
			
			if(memberInfo.getName().equals(name)) {
				
				if (memberInfo.getBirth().equals(birth)) {

					System.out.println();
					System.out.println("            ┌─────────────────────────────────────────────────────┐");
					System.out.println();
					System.out.printf("                      %s님의 아이디는 %s 입니다.\n", memberInfo.getName(), memberInfo.getId());
					System.out.println();
					System.out.println("            └─────────────────────────────────────────────────────┘");
					System.out.println();
					MainClass.pause();
					System.out.println();
					
					flag = true;
					
					MainClass.printMainMenu();
					
				} else {
					
					System.out.println();
					System.out.println("            ┌─────────────────────────────────────────────────────┐");
					System.out.println();
					System.out.println("                             생년월일이 틀렸습니다.");
					System.out.println("                               다시 입력해주세요!");
					System.out.println();
					System.out.println("            └─────────────────────────────────────────────────────┘");
					System.out.println();
					MainClass.pause();
					System.out.println();
					
					memberIdCheck();
				}
			} 
		}
		
		if(!flag) {

			System.out.println();
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println();
			System.out.println("                        이름 또는 생년월일이 틀립니다.");
			System.out.println("                               다시 입력해주세요!");
			System.out.println();
			System.out.println("            └─────────────────────────────────────────────────────┘");
			System.out.println();
			MainClass.pause();
			System.out.println();
			
			memberIdCheck();
			
		}
	}
}



















