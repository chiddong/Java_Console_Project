package com.test.buy;

import java.util.List;
import java.util.Scanner;

import com.test.cart.Basket;
import com.test.cart.CartService;
import com.test.data.Data;
import com.test.fashion.MainClass;
import com.test.login.Login;
import com.test.member.MemberService;

public class BuyMenu {
	
	static String memberId = Login.MemberId;
	
	public static void buyMenu() {
		
		Scanner scan = new Scanner(System.in);	
		
		Basket b = Data.getBasketItemCode(memberId);

		String memberName = Data.memberName(memberId);
		
		List<Basket> cartList = Data.searchBasket(memberId);     
		
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println();
		System.out.println("                               1. 구매할 상품 선택");
		System.out.println("                               2. 전체 구매");
		System.out.println("                               3. 뒤로가기");
		System.out.println();
		System.out.println("            └─────────────────────────────────────────────────────┘");
		System.out.println();
		System.out.print("            ▶ 선택: ");
		
		int sel = scan.nextInt();
		
		if (sel == 1) {
			
			buySelect();
			
		} else if (sel == 2) {
			
			scan = new Scanner(System.in);
			
			System.out.println();
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println();
			System.out.println("                          전체 상품을 구매하시겠습니까?");
			System.out.println("                                      (y / n)");			
			System.out.println();
			System.out.println("            └─────────────────────────────────────────────────────┘");
			System.out.println();
			System.out.print("            ▶ 선택: ");
			
			String answer = scan.nextLine();

			System.out.printf("            ▶ 선택한 상품 총 %d개\n", Data.getItemCount(memberId));
			System.out.printf("            ▶ 총 금액: %,d원\n", Data.getAllPrice(memberId));
			System.out.println();
			System.out.println("           ▶ 계속 진행하려면 엔터를 입력하세요.");
			System.out.println();
			scan.nextLine();
			
			if (answer.equals("y") || answer.equals("Y")) {
				
				Data.basketList = Data.allDeleteBasket(memberId);
				
				System.out.println();
				System.out.println("                              ┌─────────────────────────────────────────────────────┐");
				System.out.println();
				System.out.println("                                       주문이 완료되었습니다! 감사합니다!");
				System.out.println("                                          행복한 하루 보내세요(*˘◡˘*)");
				System.out.println();
				System.out.println("                              └─────────────────────────────────────────────────────┘");
				System.out.println();

				System.out.println();
				System.out.printf("              ╰┈➤ %s님의 구매 내역  \n", memberName);
				System.out.println("          ┌───────────────────────────────────────────────────────────────────────────────────────────────────┐");
				System.out.println("            [상품코드]\t\t\t[상품명]\t\t[수량]\t\t[가격]\t\t[판매쇼핑몰]");
				System.out.println("          └───────────────────────────────────────────────────────────────────────────────────────────────────┘");
				cartList.stream()
						.forEach(c -> System.out.printf("            %10d\t\t%-10s\t\t%-3d\t\t%,-10d\t%-10s\n",
								c.getBasketItemCode(), Data.getItemName(c.getBasketItemCode()), c.getBasketItemCount(),
								c.getBasketItemPrice(), c.getBasketShopName()));

				System.out.println("            ==================================================================================================");
				System.out.printf("             ꯁꯁꯁꯁꯁ൱ 총 금액: %,d원\n", Data.getAllPrice(memberId));
				System.out.println();
				
				MainClass.pause();
				
				MemberService.memberMenu();


			} else if (answer.equals("n") || answer.equals("N")) {
				System.out.println("            ┌─────────────────────────────────────────────────────┐");
				System.out.println();
				System.out.println("                             구매를 취소하였습니다.");
				System.out.println("                        계속하시려면 엔터를 입력하세요.");
				System.out.println();
				System.out.println("            └─────────────────────────────────────────────────────┘");
				scan = new Scanner(System.in);
				
				scan.nextLine();
				return;
			
			} else {
				MemberService.memberMenu();
			}
			
		}
	}

	private static void buySelect() {
		
		Scanner scan = new Scanner(System.in);
		
		Basket b = Data.getBasketItemCode(memberId);

		String memberName = Data.memberName(memberId);
		
		List<Basket> cartList = Data.searchBasket(memberId);     
		
		
			System.out.println();
			System.out.printf("              ╰┈➤ %s님의 장바구니 목록  \n", memberName);
			System.out.println("          ┌───────────────────────────────────────────────────────────────────────────────────────────────────┐");
			System.out.println("            [상품코드]\t\t\t[상품명]\t\t[수량]\t\t[가격]\t\t[판매쇼핑몰]");
			System.out.println("          └───────────────────────────────────────────────────────────────────────────────────────────────────┘");
			cartList.stream().forEach(c -> System.out.printf("            %10d\t\t%-10s\t\t%-3d\t\t%,-10d\t%-10s\n",
											c.getBasketItemCode(), Data.getItemName(c.getBasketItemCode()), c.getBasketItemCount(), c.getBasketItemPrice(), c.getBasketShopName()));

			System.out.println("            ==================================================================================================");
			System.out.printf("             ꯁꯁꯁꯁꯁ൱ 총 금액: %,d원\n", Data.getAllPrice(memberId));
			System.out.println();
			scan = new Scanner(System.in);
			
			System.out.print("            ▶ 원하시는 상품코드를 입력해주세요: ");
			int sel = scan.nextInt();
			System.out.println();
			System.out.println("            ─────────────────────────────────────────────");
			System.out.printf("            ▶ 선택 상품: '%s'\n", Data.buySelectItem(memberId, sel));
			System.out.println("           계속 진행하려면 엔터를 입력하세요.");
			System.out.println();
			
			scan = new Scanner(System.in);
			
			scan.nextLine();
			
			Data.deleteBasket(sel);
			
			System.out.println();
			System.out.println("                              ┌─────────────────────────────────────────────────────┐");
			System.out.println();
			System.out.println("                                       주문이 완료되었습니다! 감사합니다!");
			System.out.println("                                          행복한 하루 보내세요(*˘◡˘*)");
			System.out.println();
			System.out.println("                              └─────────────────────────────────────────────────────┘");
			System.out.println();
			System.out.println();
			System.out.printf("              ╰┈➤ %s님의 구매 내역  \n", memberName);
			System.out.println("          ┌───────────────────────────────────────────────────────────────────────────────────────────────────┐");
			System.out.println("            [상품코드]\t\t\t[상품명]\t\t[수량]\t\t[가격]\t\t[판매쇼핑몰]");
			System.out.println("          └───────────────────────────────────────────────────────────────────────────────────────────────────┘");
			
			System.out.printf("            %10d\t\t%-10s\t\t%-3d\t\t%,-10d\t%-10s\n",
					sel, Data.buySelectItem(memberId, sel), 1, Data.getItemPirce(sel), Data.getShopName(sel));

			System.out.println("            ==================================================================================================");
			System.out.printf("             ꯁꯁꯁꯁꯁ൱ 총 금액: %,d원\n", Data.getItemPirce(sel));
			System.out.println();
			
			Data.update();
			MainClass.pause();
			
			MemberService.memberMenu();
			
			
	}



}
