package com.test.item;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.data.Data;
import com.test.fashion.MainClass;
import com.test.member.MemberService;
import com.test.shop.ShopMember;

public class UserItemService {

	public static void begin() {

		boolean flag = true;

		Scanner scan = new Scanner(System.in);

		while (flag) {

			System.out.println("            ======================================================");
			System.out.println("                                   1. 상품 검색");
			System.out.println("                                   2. 스타일 검색");
			System.out.println("                                    3. 뒤로가기");
			System.out.println("            ======================================================");
			System.out.println();
			System.out.print("            선택: ");

			int select = scan.nextInt();
			scan.nextLine();

			if (select == 1) {

				itemSearch();

			} else if (select == 2) {

				styleSearch();

			} else if (select == 3) {

				flag = false;
				MainClass.main(null);

			} else {

				System.out.println();
				System.out.println("            다시 입력해주세요.");
				MainClass.pause();
				System.out.println();

			}

		}
	}

	private static void styleSearch() {


		Scanner scan = new Scanner(System.in);
		
		System.out.print("            스타일 입력: ");
		String word = scan.nextLine();

		ArrayList<Item> stylelist = Data.searchStyle(word);

		if (stylelist.size() != 0) {
			
			System.out.println();
			System.out.printf("            |%s| 검색결과\n",word);
			System.out.println("            =========================================================================================");
			System.out.println("            [상품코드]\t[상품이름]\t\t\t\t[가격]\t\t[쇼핑몰이름]");
			System.out.println("            =========================================================================================");
			
			
			stylelist.stream().forEach(item -> System.out.printf("            %-3d\t\t%-27s\t%,-7d\t\t%-8s\n"
																	, item.getItemCode()
																	, item.getItemName()
																	, item.getPrice()
																	, item.getShopName()));
			
			System.out.println("            =========================================================================================");
			
			System.out.println();
			pritntSelect();
			
		} else {
			System.out.println("            검색한 상품이 없습니다.");
		}
		MainClass.pause();

	}

	private static void itemSearch() { 

		Scanner scan = new Scanner(System.in);

		System.out.print("            상품명 입력: ");
		String word = scan.nextLine();

		ArrayList<Item> itemlist = Data.searchItem(word);

		if (itemlist.size() != 0) {

			System.out.println();
			System.out.printf("            |%s| 검색결과\n",word);
			System.out.println("            ====================================================================================================================================");
			System.out.println("            [상품코드]\t[상품이름]\t\t\t\t[사이즈]\t[가격]\t\t[카테고리]\t[스타일]\t[쇼핑몰이름]");
			System.out.println("            ====================================================================================================================================");
			

			itemlist.stream().forEach(item -> System.out.printf("            %-8s\t%-27s\t%-2s\t\t%,-10d\t%-7s\t%-5s\t%-10s\n",
					item.getItemCode(), item.getItemName(), item.getSize(), item.getPrice(),item.getCategory(), item.getStyle(), item.getShopName()));
			System.out.println("            ====================================================================================================================================");

			System.out.println();
			pritntSelect();
			
			
		} else {
			System.out.println("            검색한 상품이 없습니다.");
		}

		MainClass.pause();

	}

	private static void pritntSelect() {

		boolean flag = true;

		Scanner scan = new Scanner(System.in);

		while (flag) {

			System.out.println("                                         ======================================================");
			System.out.println("                                                              1. 구매하기");
			System.out.println("                                                              2. 뒤로가기");
			System.out.println("                                         ======================================================");
			System.out.println();
			System.out.print("                                         선택: ");

			int select = scan.nextInt();
			scan.nextLine();

			if (select == 1) {
				
				System.out.println();
				System.out.println("                                         ======================================================");
				System.out.println("                                                   주문이 완료되었습니다! 감사합니다!");
				System.out.println("                                                          행복한 하루 보내세요!");
				System.out.println("                                         ======================================================");
				
				MainClass.pause();
				
				System.out.println();
				MemberService.memberMenu();

			} else if (select == 2) {

				flag = false;

			} else {

				System.out.println();
				System.out.println("                                         다시 입력해주세요.");
				MainClass.pause();
				System.out.println();

			}

		}
	}

}
