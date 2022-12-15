package com.test.cart;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.data.Data;
import com.test.fashion.MainClass;
import com.test.item.Item;
import com.test.item.MemberItemService;
import com.test.login.Login;
import com.test.member.MemberService;

public class CartMenu {
	
	public static void cartMenu() {
		
		//dee38 s8m8Q3e3W6
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println();
		System.out.println("                          \r\n"
				+ "                                    (@*.@@,   \r\n"
				+ "                                  %@&.....@@*   \r\n"
				+ "                                &@%.........@@/   \r\n"
				+ "                              @@#.............@@#  \r\n"
				+ "                         @@@@@@@@@@@@@@@@@@@@@@@@@@@@@    \r\n"
				+ "                        ,@&*************************@@    \r\n"
				+ "                          *@#.....................@@    \r\n"
				+ "                           @@...(@,...(@....#@...,@%    \r\n"
				+ "                           *@#...@%...#@....@@...&@    \r\n"
				+ "                            @@...@@...#@...*@(...@@   \r\n"
				+ "                            *@#.................(@,    \r\n"
				+ "                             #@@@@@@@@@@@@@@@@@@@%           \r\n"
				+ "                                                             ");
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println();
		System.out.println("                               1. 장바구니 조회");
		System.out.println("                               2. 뒤로가기");
		System.out.println();
		System.out.println("            └─────────────────────────────────────────────────────┘");
		System.out.println();
		System.out.print("            ▶ 선택: ");
		
		int select = scan.nextInt();
		
		if (select == 1) {
			
			CartService.cartItemView();
			
			
		 } else {
			
			MemberService.memberMenu();
		}
	}

	public static void cartAdd(int itemCode) {
		
		Scanner scan = new Scanner(System.in);
		//7,하와이 레더 티셔츠,S,52,234000,2,상의,시티보이,마파람라온제나
		ArrayList<Item> itemlist = Data.searchItem(itemCode);
		Basket basket = new Basket();
		
		
		//2,dkzfva15,31,20,317000,난이든해
		basket.setBasketNum(Data.createBasketIndex());
		basket.setBasketId(Login.MemberId);
		basket.setBasketItemCode(itemCode);
		basket.setBasketItemCount(basket.getBasketItemCount() + 1);
		
		itemlist.stream().map(item -> item.getPrice()).forEach(price -> basket.setBasketItemPrice(price));
		itemlist.stream().map(item -> item.getShopName()).forEach(name -> basket.setBasketShopName(name));
		
		
		Data.basketList.add(basket);
		Data.update();
		
		System.out.println();
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println();
		System.out.println("                       장바구니 추가가 완료되었습니다.");
		System.out.println();
		System.out.println("                                 [메뉴 선택]");
		System.out.println();
		System.out.println("                      1. 장바구니 조회     2. 뒤로가기");
		System.out.println();
		System.out.println("            └─────────────────────────────────────────────────────┘");
		
		System.out.print("            ▶ 선택: ");            
		int select = scan.nextInt();
		
		if(select == 1) {
			
			CartService.cartItemView();
			
		} else if (select == 2) {
			
			MemberService.memberMenu();
			
		} else {
			System.out.println();
			
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println();
			System.out.println("                          올바른 번호를 입력해주세요.");
			System.out.println();
			System.out.println("            └─────────────────────────────────────────────────────┘");
			

		}
		
		
	}
}
