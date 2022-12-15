package com.test.cart;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.data.Data;
import com.test.login.Login;
import com.test.member.MemberService;

public class LikeService {

	static String memberId = Login.MemberId;
	
	public static void wishItemView() {
		
		Scanner scan = new Scanner(System.in);
		
		WishList wish = Data.getWishList(memberId);
		String memberName = Data.memberName(memberId);
		
		ArrayList<WishList> wlist = Data.searchWish(memberId);
		
		if(wlist.size() != 0) {
			
			//4,idn86,291,381000,마파람라온제나
			System.out.println();
			System.out.printf("            ╰┈➤ %s님의 찜 목록 \n", memberName);
			System.out.println("          ┌────────────────────────────────────────────────────────────────────────────────────────────────────┐");
			
			System.out.println("            [상품코드]\t\t\t[상품명]\t\t\t[가격]\t\t[판매쇼핑몰]");
			System.out.println("          └────────────────────────────────────────────────────────────────────────────────────────────────────┘");
			wlist.stream().forEach(w -> System.out.printf("            %9d\t\t%-25s\t%,-10d\t%-10s\n",
															w.getLikeItemCode(), Data.getItemName(w.getLikeItemCode()), w.getLikeItemPrice(), w.getLikeShopName()));

			System.out.println("            ==================================================================================================");

			System.out.println();
			
			printLikeSelect();
			
		} else {
			
			System.out.println();
			System.out.printf("            ╰┈➤ %s님의 찜 목록 \n", memberName);
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println();
			System.out.println("                        찜 목록이 비어있습니다 ( ᴗ_ᴗ̩̩ )");
			System.out.println();
			System.out.println("            └─────────────────────────────────────────────────────┘");
			System.out.println();
			
			System.out.println();
			System.out.println("            ▶ 계속하시려면 엔터를 입력하세요.");
			
			scan.nextLine();
			
			LikeMenu.likeMenu();
			
		}
		
		
	}

	private static void printLikeSelect() {
		
		Scanner scan = new Scanner(System.in);
		
		boolean flag = true;
		
		while(flag) {
			System.out.println();
			System.out.println("            ┌─────────────────────────────────────────────────────┐");
			System.out.println();
			System.out.println("                              1. 장바구니 추가하기");
			System.out.println("                              2. 삭제하기");
			System.out.println("                              3. 뒤로가기");
			System.out.println();
			System.out.println("            └─────────────────────────────────────────────────────┘");
			System.out.println();
			System.out.print("            ▶ 선택: ");

			int select = scan.nextInt();
			scan.nextLine();
			
			if (select == 1) {
				
				wishListToCart();
				
			} else if (select == 2) {
				
				
				wishListDelete();
				
			} else {
				
				LikeMenu.likeMenu();
				
			}
		}
		
	}

	private static void wishListDelete() {
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
				
				System.out.print("            ▶ 원하시는 상품코드를 입력해주세요:  ");
				int sel = scan.nextInt();

				boolean flag = Data.deleteWish(sel);
				
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
					
					wishItemView();
					
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
					
					Data.wishList = Data.allDeleteWishList(memberId);
					
						System.out.println();
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
					System.out.println();
					System.out.println("            ┌─────────────────────────────────────────────────────┐");
					System.out.println();
					System.out.println("                             삭제를 취소하였습니다.");
					System.out.println("                        계속하시려면 엔터를 입력하세요.");
					System.out.println();
					System.out.println("            └─────────────────────────────────────────────────────┘");
					scan = new Scanner(System.in);
					
					scan.nextLine();
					
					wishItemView();
					
				} else {
					System.out.println("            ▶ y 또는 n을 입력해주세요.");
					return;
				}
			} else {
				LikeMenu.likeMenu();
			}
		}		
		
	}

	private static void wishListToCart() {
		
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println();
		System.out.print("             ▶ 추가할 상품 코드를 입력하세요: ");
		
		int itemCode = scan.nextInt();
		
		
		System.out.println();
		System.out.println("            └─────────────────────────────────────────────────────┘");
		System.out.println();
		
		Data.deleteWish(itemCode);
		
		CartMenu.cartAdd(itemCode);
		
		
	}

}

