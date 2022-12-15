package com.test.login;

import java.util.Scanner;

import com.test.data.Data;
import com.test.fashion.MainClass;
import com.test.member.MemberInfo;
import com.test.member.MemberService;
import com.test.shop.ShopMember;
import com.test.shop.ShopMemberService;
import com.test.system.SystemMemberService;

public class Login {
	
	public static String ShopMemberId = "";
	public static String MemberId = "";
	
	public static void mainLogin() {
		
		Scanner scan = new Scanner(System.in);
		
		while (true) {
	
			
			System.out.println();
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println("                               1. 회원 로그인                      ");
			System.out.println("                               2. 쇼핑몰 관리자 로그인             ");
			System.out.println("                               3. 시스템 관리자 로그인             ");
			System.out.println("                               4. 뒤로가기                         ");
			System.out.println("            └─────────────────────────────────────────────────────┘");			
			System.out.println();
			System.out.print("            ▶ 선택: ");
			System.out.print(" ");
			
			int select = scan.nextInt();
			scan.nextLine();
			
			if (select == 1) {
				
				memberLogin();
				
			} else if (select == 2) {
				
				ceoLogin();
				
			} else if (select == 3) {
				
				systemLogin();
				
			} else if (select == 4) {
				
				MainClass.printMainMenu();
				return;
				
			} else {
				
				System.out.println();
				System.out.println("            다시 입력해주세요.");
				MainClass.pause();
				System.out.println();

				mainLogin();
				
			}
			
		}
		
	}

	private static void memberLogin() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println("                                   1. 로그인");
		System.out.println("                                   2. 뒤로가기");
		System.out.println("            └─────────────────────────────────────────────────────┘");			
		System.out.print("            ▶ 선택: ");
		System.out.print(" ");
		
		int select = scan.nextInt();
		scan.nextLine();
		
		if (select == 1) {
			
			memberCheck();
			
		} else if (select == 2) {
			
			return;
			
		} else {
			
			System.out.println();
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println("                               다시 입력해주세요.");
			System.out.println("            └─────────────────────────────────────────────────────┘");			
			MainClass.pause();
			System.out.println();
			
			memberLogin();
			
		}
		
	}

	private static void memberCheck() {
		
		boolean flag = false;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println();
		System.out.print("                            🖋 아이디: ");
		
		String id = scan.nextLine();

		System.out.print("                            🖋 비밀번호: ");
		
		String password = scan.nextLine();
		System.out.println();
		
		System.out.println("            └─────────────────────────────────────────────────────┘");			
		System.out.println();
		
		String memberName = Data.memberName(id);
		
		for (MemberInfo memberInfo : Data.memberInfoList) {
			
			if (memberInfo.getId().equals(id)) {
			
				if (memberInfo.getPassword().equals(password)) {
					
					System.out.println();
					System.out.println("            ┌─────────────────────────────────────────────────────┐");
					System.out.println("                              ❤ 𝙒 𝙀 𝙇 𝘾 𝙊 𝙈 𝙀 ❤");
					
					System.out.println();
					System.out.printf("                             %s님 환영합니다!\n", memberName);					
					System.out.println("                           로그인이 완료되었습니다!");
					System.out.println("            └─────────────────────────────────────────────────────┘");			
					MainClass.pause();
					System.out.println();
					
					MemberId = id;
					
					flag = true;
					
					MemberService.memberMenu();
					
				} else {
					
					System.out.println();
					System.out.println("            ┌─────────────────────────────────────────────────────┐");
					System.out.println();
					System.out.println("                              비밀번호가 틀립니다.");
					System.out.println("                               다시 입력해주세요!");
					System.out.println();
					System.out.println("            └─────────────────────────────────────────────────────┘");			
					MainClass.pause();
					System.out.println();
					
					memberCheck();
					
				}

			}
			
		}

		if (!flag) {
			
			System.out.println();					
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println();
			System.out.println("                        아이디 또는 비밀번호가 틀립니다.");
			System.out.println("                               다시 입력해주세요!");
			System.out.println();
			System.out.println("            └─────────────────────────────────────────────────────┘");			
			MainClass.pause();
			System.out.println();
			
			memberCheck();
			
		}
		
	}

	private static void systemLogin() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println("                                   1. 로그인");
		System.out.println("                                   2. 뒤로가기");
		System.out.println("            └─────────────────────────────────────────────────────┘");			
		System.out.print("            ▶ 선택: ");
		System.out.print(" ");
		
		int select = scan.nextInt();
		scan.nextLine();
		
		if (select == 1) {
			
			sysyemMemberCheck();
			
		} else if (select == 2) {
			
			return;
			
		} else {
			
			System.out.println();
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println("                               다시 입력해주세요.");
			System.out.println("            └─────────────────────────────────────────────────────┘");			
			MainClass.pause();
			System.out.println();
			
			systemLogin();
			
		}
		
	}

	private static void sysyemMemberCheck() {
		
		boolean flag = false;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println();
		System.out.print("                            🖋 아이디: ");
		
		String id = scan.nextLine();

		System.out.print("                            🖋 비밀번호: ");
		
		String password = scan.nextLine();
		System.out.println();
		
		System.out.println("            └─────────────────────────────────────────────────────┘");			
		System.out.println();
		
		if (id.equals("asdf1234")) {
			
			if (password.equals("asdf1234")) {
				
				System.out.println();
				System.out.println("            ┌─────────────────────────────────────────────────────┐");
				System.out.println("                              ❤ 𝙒 𝙀 𝙇 𝘾 𝙊 𝙈 𝙀 ❤");
				System.out.println();
				System.out.println("                           로그인이 완료되었습니다!");
				System.out.println("            └─────────────────────────────────────────────────────┘");			
				MainClass.pause();
				System.out.println();
				
				flag = true;
				
				SystemMemberService.systemMemberMenu();
				
			} else {
				
				System.out.println();
				System.out.println("            ┌─────────────────────────────────────────────────────┐");
				System.out.println();
				System.out.println("                              비밀번호가 틀립니다.");
				System.out.println("                               다시 입력해주세요!");
				System.out.println();
				System.out.println("            └─────────────────────────────────────────────────────┘");			
				MainClass.pause();
				System.out.println();
				
				sysyemMemberCheck();
				
			}
			
		}
		
		if (!flag) {
			
			System.out.println();					
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println();
			System.out.println("                        아이디 또는 비밀번호가 틀립니다.");
			System.out.println("                               다시 입력해주세요!");
			System.out.println();
			System.out.println("            └─────────────────────────────────────────────────────┘");			
			MainClass.pause();
			System.out.println();
			
			sysyemMemberCheck();
			
		}
		
	}

	private static void ceoLogin() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println("                                   1. 로그인");
		System.out.println("                                   2. 뒤로가기");
		System.out.println("            └─────────────────────────────────────────────────────┘");			
		System.out.print("            ▶ 선택: ");
		System.out.print(" ");
		
		int select = scan.nextInt();
		scan.nextLine();
		
		if (select == 1) {
			
			shopMemberCheck();
			
		} else if (select == 2) {
			
			return;
			
		} else {
			
			System.out.println();
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println("                               다시 입력해주세요.");
			System.out.println("            └─────────────────────────────────────────────────────┘");			
			MainClass.pause();
			System.out.println();
			
			ceoLogin();
			
		}

	}

	private static void shopMemberCheck() {
		
		boolean flag = false;
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println();
		System.out.print("                            🖋 아이디: ");
		
		String id = scan.nextLine();

		System.out.print("                            🖋 비밀번호: ");
		
		String password = scan.nextLine();
		System.out.println();
		
		System.out.println("            └─────────────────────────────────────────────────────┘");			
		System.out.println();
		
		String shopName = Data.ShopName(id);
		
		
		for (ShopMember shopMember : Data.shopMemberList) {
			
			if (shopMember.getId().equals(id)) {
			
				if (shopMember.getPassword().equals(password)) {
					
					System.out.println();
					System.out.println("            ┌─────────────────────────────────────────────────────┐");
					System.out.println("                              ❤ 𝙒 𝙀 𝙇 𝘾 𝙊 𝙈 𝙀 ❤");
					System.out.println();
					System.out.printf("                             %s님 환영합니다!\n", shopName);	
					System.out.println("                           로그인이 완료되었습니다!");
					System.out.println("            └─────────────────────────────────────────────────────┘");			
					MainClass.pause();
					System.out.println();
					
					flag = true;
					
					ShopMemberId = id;
					
					ShopMemberService.shopMemberMenu();
					
				} else {
					
					System.out.println();
					System.out.println("            ┌─────────────────────────────────────────────────────┐");
					System.out.println();
					System.out.println("                              비밀번호가 틀립니다.");
					System.out.println("                               다시 입력해주세요!");
					System.out.println();
					System.out.println("            └─────────────────────────────────────────────────────┘");			
					MainClass.pause();
					System.out.println();
					
					memberCheck();
					
				}

			}
			
		}

		if (!flag) {
			
			System.out.println();					
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println();
			System.out.println("                        아이디 또는 비밀번호가 틀립니다.");
			System.out.println("                               다시 입력해주세요!");
			System.out.println();
			System.out.println("            └─────────────────────────────────────────────────────┘");			
			MainClass.pause();
			System.out.println();
			
			shopMemberCheck();
			
		}
		
	}

}
