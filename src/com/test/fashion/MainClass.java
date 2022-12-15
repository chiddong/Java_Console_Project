package com.test.fashion;

import java.util.Scanner;

import com.test.data.Data;
import com.test.idPassword.Find;
import com.test.item.UserItemService;
import com.test.login.Login;
import com.test.member.MemberService;
import com.test.ranking.Ranking;

public class MainClass {
	
	public static void main(String[] args) {
		
		Data.load();

		boolean flag = true;
		
		while (flag) {
			
			Scanner scan = new Scanner(System.in);
			
			printMainMenu();
			
			while (flag) {
				
				getMainMenu(scan);
				
			}
			
		}
		
		Data.update();
		
	}

	public static void getMainMenu(Scanner scan) {
		
		int select = scan.nextInt();
		scan.nextLine();
		
		if (select == 1) {
			
			Login.mainLogin();

		} else if (select == 2) {
			
			UserItemService.begin();
			
		} else if (select == 3) {
			
			Ranking.main(null);
			
		} else if (select == 4) {
			
			Find.finding();			

		} else if (select == 5) {
			
			MemberService.createMember();
			
		} else if (select == 6) {
			
			System.out.println();
			System.out.println();
			System.out.println( "                       @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@               \r\n"
					+ "                     @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@                \r\n"
					+ "                   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@               \r\n"
					+ "                 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@                \r\n"
					+ "                @@@@@@@@@@@@@@/**@//#@@@@@(/#@**(@@@@@@@@@@@@@@                \r\n"
					+ "               @@@@@@@@@@@@******@@/////////@#****/(@@@@@@@@@@@@                \r\n"
					+ "               @@@@@@@@(/(@********@@&///@@*******/(@//@@@@@@@@@                \r\n"
					+ "               @@@@@@////(@***********************/(@/////@@@@@@                \r\n"
					+ "               @@@///////(@***********************/(@///////&@@@                \r\n"
					+ "               @@@@@/////(@*******@@@#************/(@/////%@@@@@                \r\n"
					+ "               @@@@@@@@@@#@****@@#    /@&****/***//(@%@@@@@@@@@@                \r\n"
					+ "               @@@@@@@@@@@@*******@@&@***********//(@@@@@@@@@@@@                \r\n"
					+ "               @@@@@@@@@@@@*********************///(@@@@@@@@@@@@                \r\n"
					+ "                @@@@@@@@@@@*************@@@****////(@@@@@@@@@@@                \r\n"
					+ "                 @@@@@@@@@@***********@@*  &@%/////(@@@@@@@@@@                \r\n"
					+ "                   @@@@@@@@*************&@@////////(@@@@@@@@                \r\n"
					+ "                    @@@@@@@************////////////(@@@@@@@                \r\n"
					+ "                      @@@@@/**/////////////////////&@@@@@    \r\n"
					+  "                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@               \r\n");
			System.out.println();		
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println("                                      .      　。　　　　•　    　\r\n"
					+ "              　　.　　　.　　　  　　.　　　　　。　　   。　.\r\n"
					+ "                 　.　　  。　            ඞ   。　    .    •\r\n"
					+ "                 •           감사합니다 또 오세요! 　 。　.\r\n"
					+ "              　 　　。　　ﾟ　            　　.　　　　　.\r\n"
					+ "            　　　　　　. \r\n"
					+ "            ,　　　　.　 .　　       .               。");
			System.out.println("            └─────────────────────────────────────────────────────┘");
			
		} else {
			
			System.out.println();
			System.out.println("            다시 입력해주세요.");
			pause();
			System.out.println();
			printMainMenu();
			getMainMenu(scan);
			
		}
	}

	public static void printMainMenu() {
		
		System.out.println();
		System.out.println();
		System.out.println( "                       @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@               \r\n"
				+ "                     @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@                \r\n"
				+ "                   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@               \r\n"
				+ "                 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@                \r\n"
				+ "                @@@@@@@@@@@@@@/**@//#@@@@@(/#@**(@@@@@@@@@@@@@@                \r\n"
				+ "               @@@@@@@@@@@@******@@/////////@#****/(@@@@@@@@@@@@                \r\n"
				+ "               @@@@@@@@(/(@********@@&///@@*******/(@//@@@@@@@@@                \r\n"
				+ "               @@@@@@////(@***********************/(@/////@@@@@@                \r\n"
				+ "               @@@///////(@***********************/(@///////&@@@                \r\n"
				+ "               @@@@@/////(@*******@@@#************/(@/////%@@@@@                \r\n"
				+ "               @@@@@@@@@@#@****@@#    /@&****/***//(@%@@@@@@@@@@                \r\n"
				+ "               @@@@@@@@@@@@*******@@&@***********//(@@@@@@@@@@@@                \r\n"
				+ "               @@@@@@@@@@@@*********************///(@@@@@@@@@@@@                \r\n"
				+ "                @@@@@@@@@@@*************@@@****////(@@@@@@@@@@@                \r\n"
				+ "                 @@@@@@@@@@***********@@*  &@%/////(@@@@@@@@@@                \r\n"
				+ "                   @@@@@@@@*************&@@////////(@@@@@@@@                \r\n"
				+ "                    @@@@@@@************////////////(@@@@@@@                \r\n"
				+ "                      @@@@@/**/////////////////////&@@@@@    \r\n"
				+  "                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@               \r\n");
		System.out.println();		
//		System.out.println("            =======================================================");
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println("                               1. 로그인                          ");
		System.out.println("                               2. 비회원 로그인                   ");
		System.out.println("                               3. 랭킹조회                        ");
		System.out.println("                               4. 아이디/비밀번호 찾기            ");
		System.out.println("                               5. 회원가입                        ");
		System.out.println("                               6. 프로그램 종료                   ");
		System.out.println("            └─────────────────────────────────────────────────────┘");
		System.out.println();
		System.out.print("            ▶ 선택: ");
		System.out.print(" ");
	}
	
	public static void pause() {
		
		System.out.println();
		System.out.println("            ▶ 계속하시려면 엔터를 입력하세요.");
		
		Scanner scan = new Scanner(System.in);
		
		scan.nextLine();
		
		System.out.println();
		
	}

}
