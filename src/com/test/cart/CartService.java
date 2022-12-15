package com.test.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.test.buy.BuyMenu;
import com.test.data.Data;
import com.test.item.Item;
import com.test.login.Login;
import com.test.member.MemberService;

public class CartService {
	
	static String memberId = Login.MemberId;

	public static void cartItemView() {
		
		Scanner scan = new Scanner(System.in);
		
		Basket b = Data.getBasketItemCode(memberId);
//		Item item = Data.getItem(b.getBasketItemCode());
		String memberName = Data.memberName(memberId);
		
		List<Basket> cartList = Data.searchBasket(memberId);     
		
		
		if (cartList.size() != 0) {
			// %6d\t%-6s\t\t%-3d\t\t%,-10d\t%-10s\n
			

			
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
			
			printBasketSelect();
			
		} else {
			
			System.out.println();
			System.out.printf("            ╰┈➤ %s님의 장바구니 목록  \n", memberName);
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println();
			System.out.println("                       장바구니가 비어있습니다 ( ᴗ_ᴗ̩̩ )");
			System.out.println();
			System.out.println("            └─────────────────────────────────────────────────────┘");
			System.out.println();
			
			System.out.println();
			System.out.println("           ▶ 계속하시려면 엔터를 입력하세요.");
			
			scan.nextLine();
			
			CartMenu.cartMenu();
			
		}
		
	}


	private static void printBasketSelect() {
		
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		
		
		while(flag) {
			
			System.out.println();
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println();
			System.out.println("                                 1. 구매하기");
			System.out.println("                                 2. 삭제하기");
			System.out.println("                                 3. 뒤로가기");
			System.out.println();
			System.out.println("            └─────────────────────────────────────────────────────┘");
			System.out.println();
			System.out.print("            ▶ 선택: ");

			int select = scan.nextInt();
			scan.nextLine();
			
			if (select == 1) {
				
				BuyMenu.buyMenu();
				
			} else if (select == 2) {
				
				
				basketDelete();
				
			} else {
				
				CartMenu.cartMenu();
				
			}
		}
	}

	private static void basketDelete() {
		Scanner scan = new Scanner(System.in);
		boolean loop = true;

		while (loop) {
			System.out.println();
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println();
			System.out.println("                               	   1. 상품선택");
			System.out.println("                                   2. 전체삭제");
			System.out.println("                                   3. 뒤로가기");
			System.out.println();
			System.out.println("            └─────────────────────────────────────────────────────┘");
			System.out.println();
			System.out.print("            ▶ 선택: ");

			int select = scan.nextInt();
			scan.nextLine();

			if (select == 1) {
				
				scan = new Scanner(System.in);
				
				System.out.print("            ▶ 원하시는 상품코드를 입력해주세요: ");
				
				int itemCode = scan.nextInt();
				System.out.println();
				boolean flag = Data.deleteBasket(itemCode);
				
				if(flag) {

					System.out.println();
					System.out.println("            ┌─────────────────────────────────────────────────────┐");
					System.out.println();
					System.out.println("                    선택하신 상품의 삭제가 완료되었습니다.");
					System.out.println("                         계속하시려면 엔터를 입력하세요.");
					System.out.println();
					System.out.println("            └─────────────────────────────────────────────────────┘");
					scan = new Scanner(System.in);
					
					scan.nextLine();
					Data.update();
					
					cartItemView();
					
				}

			} else if (select == 2) {
				scan = new Scanner(System.in);
				
				System.out.println();
				System.out.println("            ┌─────────────────────────────────────────────────────┐");
				System.out.println();
				System.out.println("                          전체 상품을 삭제하시겠습니까?");
				System.out.println("                                      (y / n)");			
				System.out.println();
				System.out.println("            └─────────────────────────────────────────────────────┘");
				System.out.println();
				System.out.print("            ▶ 선택: ");

				String answer = scan.nextLine();
				
				if (answer.equals("y") || answer.equals("Y")) {
					
					Data.basketList = Data.allDeleteBasket(memberId);
					
						System.out.println("            ┌─────────────────────────────────────────────────────┐");
						System.out.println();
						System.out.println("                          전체 상품을 삭제하였습니다.");
						System.out.println("                        계속하시려면 엔터를 입력하세요.");
						System.out.println();
						System.out.println("            └─────────────────────────────────────────────────────┘");
						System.out.println();
						scan = new Scanner(System.in);

						scan.nextLine();
						
						MemberService.memberMenu();
					
				} else if (answer.equals("n") || answer.equals("N")) {
					System.out.println("            ┌─────────────────────────────────────────────────────┐");
					System.out.println();
					System.out.println("                             삭제를 취소하였습니다.");
					System.out.println("                        계속하시려면 엔터를 입력하세요.");
					System.out.println();
					System.out.println("            └─────────────────────────────────────────────────────┘");
					scan = new Scanner(System.in);
					
					scan.nextLine();
					
					cartItemView();
					
				} else {
					System.out.println("           ▶ y 또는 n을 입력해주세요.");
					return;
				}
			} else {
				CartMenu.cartMenu();
			}
		}		
	}

	private static void basketPurchase() {
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;

		while (loop) {
			System.out.println();
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println();
			System.out.println("                               	   1. 상품선택");
			System.out.println("                                   2. 전체구매");
			System.out.println("                                   3. 뒤로가기");
			System.out.println();
			System.out.println("            └─────────────────────────────────────────────────────┘");
			System.out.println();
			System.out.print("           ▶ 선택: ");

			int select = scan.nextInt();
			scan.nextLine();

			if (select == 1) {
				
				scan = new Scanner(System.in);
				
				System.out.println("            ┌─────────────────────────────────────────────────────┐");
				System.out.println();
				System.out.println("             원하시는 상품코드를 입력해주세요");
				System.out.print("             ▶ 상품 선택: ");
	
				int itemCode = scan.nextInt();
				
				System.out.println();
				System.out.println("            └─────────────────────────────────────────────────────┘");
				System.out.println();
				System.out.println("             계속하시려면 엔터를 입력하세요.");
				
				scan = new Scanner(System.in);
				scan.nextLine(); 
				
				boolean flag = Data.basketPurchase(itemCode);
				
				if(flag) {
					
					System.out.println();
					
					Data.purchase(itemCode);
					Data.update();
				
				}

			} else if (select == 2) {
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
				
				if (answer.equals("y") || answer.equals("Y")) {
					
					Data.allPurchase(memberId);
					
				} else if (answer.equals("n") || answer.equals("N")) {
					System.out.println("            ┌─────────────────────────────────────────────────────┐");
					System.out.println();
					System.out.println("                            구매를 취소하였습니다.");
					System.out.println("                        계속하시려면 엔터를 입력하세요.");
					System.out.println();
					System.out.println("            └─────────────────────────────────────────────────────┘");
					scan = new Scanner(System.in);
					
					scan.nextLine();
					
					cartItemView();
					
				} else {
					System.out.println("            ▶  y 또는 n을 입력해주세요.");
					return;
				}
			} else {
				CartMenu.cartMenu();
			}
			
			
		} //while
	}
	
	


	
}
