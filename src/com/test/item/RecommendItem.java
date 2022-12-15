package com.test.item;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.buyHistory.BuyHistory;
import com.test.cart.CartMenu;
import com.test.cart.LikeMenu;
import com.test.data.Data;
import com.test.fashion.MainClass;
import com.test.login.Login;
import com.test.member.MemberService;
import com.test.ranking.Ranking;

public class RecommendItem {
	
	static String memberId = Login.MemberId;

	public static void begin() {
		
			String name = Data.memberName(memberId);

			BuyHistory buy = Data.getItemCode(memberId);

			if (buy != null) {
				
				Item item = Data.getItemStyle(buy.getItemCode());

				String style = item.getStyle();

				ArrayList<Item> stylelist = Data.searchStyle(style);
				
				if (stylelist.size() != 0) {

					System.out.println();
					System.out.printf("            %s님｜추천 상품 목록\n", name);
					System.out.println("            ====================================================================================");
					System.out.println("            [상품코드]\t[상품이름]\t\t\t\t[가격]\t\t[판매쇼핑몰]");
					System.out.println("            ====================================================================================");

					stylelist.stream().limit(5).forEach(i -> System.out.printf("            %-6d\t%-27s\t%,-10d\t%-10s\n",
							i.getItemCode(), i.getItemName(), i.getPrice(), i.getShopName()));

					System.out.println("            ====================================================================================");

					System.out.println();
					pritntSelect();

				} 
				
			} else {
				
				System.out.println("            최근 구매 내역이 존재하지 않습니다.");
				System.out.println();
				System.out.println("                                      쇼핑몰 랭킹");
				Ranking.main(null);
			}
						
		MainClass.pause();

	}

	private static void pritntSelect() {

		boolean flag = true;

		Scanner scan = new Scanner(System.in);

		while (true) {

			System.out.println("            ======================================================");
			System.out.println("                               1. 추천상품 구매하기");
			System.out.println("                                2. 장바구니 추가");
			System.out.println("                                 3. 찜 목록 추가");
			System.out.println("                                   4. 뒤로가기");
			System.out.println("            ======================================================");
			System.out.println();
			System.out.print("            선택: ");

			int select = scan.nextInt();
			scan.nextLine();

			if (select == 1) {

				System.out.println();
				System.out.println("            ======================================================");
				System.out.println("                         주문이 완료되었습니다! 감사합니다!");
				System.out.println("                              행복한 하루 보내세요!");
				System.out.println("            ======================================================");
				
				MainClass.pause();
				
				System.out.println();
				MemberService.memberMenu();

			} else if (select == 2) {

				//장바구니 추가
				CartMenu.cartMenu();

			} else if (select == 3) {

				//찜 목록 추가
				LikeMenu.likeMenu();
				
			} else if (select == 4) {

				MemberService.memberMenu();

			} else {

				System.out.println();
				System.out.println("            다시 입력해주세요.");
				MainClass.pause();
				System.out.println();

			}

		}
		
	}

}