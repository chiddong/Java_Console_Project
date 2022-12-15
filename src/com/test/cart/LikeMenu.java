package com.test.cart;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.data.Data;
import com.test.fashion.MainClass;
import com.test.item.Item;
import com.test.item.MemberItemService;
import com.test.login.Login;
import com.test.member.MemberService;

public class LikeMenu {

	public static void likeMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("                                      \r\n"
				+ "                                               &*@           \r\n"
				+ "                                              @. .#          \r\n"
				+ "                                            .@   &,          \r\n"
				+ "                                           @.   #*           \r\n"
				+ "                                         /%     &/**,,,,.    \r\n"
				+ "                         .@%%%%%%%%%%@ /%                #,  \r\n"
				+ "                         (#((((((((((&%                 %&   \r\n"
				+ "                         (#((((((((((&,                 .@   \r\n"
				+ "                         (#((((((((((&,                  #,  \r\n"
				+ "                         (#((((((((((&,                ./@   \r\n"
				+ "                         (#((((((((((&,               ,#@    \r\n"
				+ "                         *@(((((((((#@    .,*/*,.            \r\n"
				+ "                                                             \r\n"
				+ "                                                            ");
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println();
		System.out.println("                                 1. 찜목록 조회");
		System.out.println("                                 2. 뒤로가기");
		System.out.println();
		System.out.println("            └─────────────────────────────────────────────────────┘");
		System.out.println();
		System.out.print("           ▶ 선택: ");
		
		int select = scan.nextInt();

		if (select == 1) {
			
			LikeService.wishItemView();
	
		} else {
			
			MemberService.memberMenu();
			
		}
	}

	public static void wishAdd(int itemCode) {
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Item> itemlist = Data.searchItem(itemCode);
		WishList wish = new WishList();
		
		
		//2,dkzfva15,31,20,317000,난이든해
		wish.setLikeNum(Data.createWishIndex());
		wish.setLikeId(Login.MemberId);
		wish.setLikeItemCode(itemCode);
		
		itemlist.stream().map(item -> item.getPrice()).forEach(price -> wish.setLikeItemPrice(price));
		itemlist.stream().map(item -> item.getShopName()).forEach(name -> wish.setLikeShopName(name));
		
		
		Data.wishList.add(wish);
		Data.update();
		
		System.out.println();
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println();
		System.out.println("                         찜목록 추가가 완료되었습니다.");
		System.out.println();
		System.out.println("                                  [메뉴 선택]");
		System.out.println();
		System.out.println("                       1. 찜 목록 조회     2. 뒤로가기");
		System.out.println();
		System.out.println("            └─────────────────────────────────────────────────────┘");
		
		System.out.print("            ▶ 선택: ");            
		int select = scan.nextInt();
		
		if(select == 1) {
			
			LikeService.wishItemView();
			
		} else if (select == 2) {
			
			MemberItemService.begin();
			
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
