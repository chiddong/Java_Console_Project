package com.test.item;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.data.Data;
import com.test.fashion.MainClass;
import com.test.login.Login;

public class ShopItemService {

	static String shopName = Data.ShopName(Login.ShopMemberId);
	
	public static void begin() {
		
		boolean flag = true;

		Scanner scan = new Scanner(System.in);

		while (flag) {

			System.out.println("            ======================================================");
			System.out.println("                                   1. 상품 목록");
			System.out.println("                                   2. 상품 등록");
			System.out.println("                                   3. 상품 검색");
			System.out.println("                                   4. 뒤로가기");
			System.out.println("            ======================================================");
			System.out.println();
			System.out.print("            선택: ");
			
			int select = scan.nextInt();
			scan.nextLine();
			
			if (select == 1) {
				
				view();

			} else if (select == 2) {
				
				regist();
				
			} else if (select == 3) {
				
				search();
				
			} else if (select == 4) {
				
				flag = false;
				
			} else {
				
				System.out.println();
				System.out.println("            다시 입력해주세요.");
				MainClass.pause();
				System.out.println();
				
			}

	}
		
}

	private static void search() {

		boolean flag = true;

		Scanner scan = new Scanner(System.in);

		while (flag) {

			System.out.println("            ======================================================");
			System.out.println("                                 1. 상품명으로 검색");
			System.out.println("                                 2. 상품코드로 검색");
			System.out.println("                                    3. 뒤로가기");
			System.out.println("            ======================================================");
			System.out.println();
			System.out.print("            선택: ");

			int select = scan.nextInt();
			scan.nextLine();

			if (select == 1) {

				System.out.print("            상품명 입력: ");
				String word = scan.nextLine();

				ArrayList<Item> itemlist = Data.searchShopItemName(word, shopName);

				if (itemlist.size() != 0) {

					System.out.println();
					System.out.println();
					System.out.printf("            |%s| 판매 상품 목록\n",shopName);
					System.out.println("            ====================================================================================================================================");
					System.out.println("            [상품코드]\t[상품이름]\t\t\t\t[사이즈]\t[수량]\t[가격]\t\t[판매량]\t[카테고리]\t[스타일]");
					System.out.println("            ====================================================================================================================================");
					

					itemlist.stream().forEach(item -> System.out.printf("            %-8s\t%-27s\t%-2s\t\t%-2s\t%,-10d\t%-5s\t\t%-7s\t%-5s\n",
							item.getItemCode(), item.getItemName(), item.getSize(), item.getItemCount(), item.getPrice(),
							item.getSellCount(), item.getCategory(), item.getStyle(), item.getShopName()));
					System.out.println("            ====================================================================================================================================");


					
				} else {
					System.out.println("            검색한 상품이 없습니다.");
				}

				MainClass.pause();

			} else if (select == 2) {

				System.out.print("            상품코드 입력: ");
				int code = scan.nextInt();
				scan.nextLine();

				ArrayList<Item> itemlist = Data.searchShopItemCode(code, shopName);

				if (itemlist.size() != 0) {

					System.out.println();
					System.out.println();
					System.out.printf("            |%s| 판매 상품 목록\n",shopName);
					System.out.println("            ====================================================================================================================================");
					System.out.println("            [상품코드]\t[상품이름]\t\t\t\t[사이즈]\t[수량]\t[가격]\t\t[판매량]\t[카테고리]\t[스타일]");
					System.out.println("            ====================================================================================================================================");
					
					itemlist.stream().forEach(item -> System.out.printf("            %-8s\t%-27s\t%-2s\t\t%-2s\t%,-10d\t%-5s\t\t%-7s\t%-5s\n",
							item.getItemCode(), item.getItemName(), item.getSize(), item.getItemCount(), item.getPrice(),
							item.getSellCount(), item.getCategory(), item.getStyle(), item.getShopName()));
					
					
				} else {
					System.out.println("            검색한 상품이 없습니다.");
				}
				System.out.println("            ====================================================================================================================================");
				MainClass.pause();
				
			} else if (select == 3) {

				flag = false;

			} else {

				System.out.println();
				System.out.println("            다시 입력해주세요.");
				MainClass.pause();
				System.out.println();

			}

		}
		MainClass.pause();
		
	}


	private static void view() {

		
		//상품코드,상품이름,사이즈(S,M,L),수량,가격,판매량,카테고리,스타일,판매쇼핑몰
		System.out.println();
		System.out.println();
		System.out.printf("            |%s| 판매 상품 목록\n",shopName);
		System.out.println("            ====================================================================================================================================");
		System.out.println("            [상품코드]\t[상품이름]\t\t\t\t[사이즈]\t[수량]\t[가격]\t\t[판매량]\t[카테고리]\t[스타일]");
		System.out.println("            ====================================================================================================================================");
		
		for (Item item : Data.itemList) {
			if (item.getShopName().equals(shopName)) {
	
			System.out.printf("            %-8s\t%-27s\t%-2s\t\t%-2s\t%,-10d\t%-5s\t\t%-7s\t%-5s\n"
								, item.getItemCode()
								, item.getItemName()
								, item.getSize()
								, item.getItemCount()
								, item.getPrice()
								, item.getSellCount()
								, item.getCategory()
								, item.getStyle());
			}
			
		}
		System.out.println("            ====================================================================================================================================");
		
		pritntSelect();
	}
		
		

	private static void pritntSelect() {

		boolean flag = true;

		Scanner scan = new Scanner(System.in);

		while (flag) {

			System.out.println();
			System.out.println("                                         ==========================================================");
			System.out.println("                                                                 1. 상품 삭제");
			System.out.println("                                                                 2. 상품 수정");
			System.out.println("                                                                 3. 뒤로가기");
			System.out.println("                                         ==========================================================");
			System.out.println();
			System.out.print("                                         선택: ");
			
			int select = scan.nextInt();
			scan.nextLine();
			
			if (select == 1) {
				
				System.out.print("            삭제할 상품코드: ");
				int deleteSel = scan.nextInt();
				
				boolean result = Data.deleteItem(deleteSel);
				
				if (result) {
					System.out.println("            상품을을 삭제했습니다.");
					Data.update();
				} else {
					System.out.println("            다시 입력해주세요.");
				}
				
			} else if (select == 2) {
				
				System.out.print("            수정할 상품코드: ");
				int editSel = scan.nextInt();
				scan.nextLine();
				
				System.out.println();

				Item i = Data.getItem(editSel);
				
				
				System.out.println();
				System.out.println("                      ┌─────────────────────────────┐");
				System.out.println("                         상품명: " + i.getItemName()); 
				System.out.println("                         가격: " + i.getPrice());		  
				System.out.println("                         수량: " + i.getItemCount());  
				System.out.println("                      └─────────────────────────────┘");
				
				System.out.println();
				System.out.println();
				
				System.out.println("            ∞∞수정할 데이터를 입력해주세요. 값을 유지하고싶다면 엔터를 눌러주세요∞∞");
				System.out.println("            ======================================================");
				System.out.print("            상품명: ");
				String itemName = scan.nextLine();
				
				System.out.print("            가격: ");
				String itemPrice = scan.nextLine();
				
				System.out.print("            수량: ");
				String itemCount = scan.nextLine();
				
				if (!itemName.equals("")) {
					i.setItemName(itemName);
				}
				
				if (!itemPrice.equals("")) {
					i.setPrice(Integer.parseInt(itemPrice));
				}
				
				if (!itemCount.equals("")) {
					i.setItemCount(Integer.parseInt(itemCount));
				}
				
				System.out.println("            ======================================================");
				System.out.println("            상품 정보를 수정했습니다.");
				System.out.println();
				System.out.println("                      ┌─────────────────────────────┐");
				System.out.println("                         상품명: " + i.getItemName()); 
				System.out.println("                         가격: " + i.getPrice());		  
				System.out.println("                         수량: " + i.getItemCount());  
				System.out.println("                      └─────────────────────────────┘");
				System.out.println();
				MainClass.pause();
				
			} else if (select == 3) {
				
				flag = false;
						
			} else {
				
				System.out.println();
				System.out.println("            다시 입력해주세요.");
				MainClass.pause();
				System.out.println();
				
			}
			
	}
		
	}

	private static void regist() {
		
		String shopName = Data.ShopName(Login.ShopMemberId);
		
		// 상품코드,상품이름,사이즈(S,M,L),수량,가격,판매량,카테고리,스타일,판매쇼핑몰
		
		Scanner scan = new Scanner(System.in);
		
		int seq = Data.createSeq();
		
		System.out.println();
		System.out.println("            ===============================================================================================");
		System.out.println();
		System.out.print("            상품명: ");
		String itemName = scan.nextLine();
		System.out.print("            사이즈(S, M, L): ");
		String size = scan.nextLine();
		System.out.print("            수량: ");
		int itemCount = scan.nextInt();
		System.out.print("            가격: ");
		int price = scan.nextInt();
		scan.nextLine();
		System.out.print("            카테고리(상의, 하의, 스커트, 아우터, 신발, 악세사리): ");
		String category = scan.nextLine();
		System.out.print("            스타일(미니멀, 아메카지, 시티보이, 캐주얼, 스트릿, 하이틴, 로맨틱, 걸리쉬, 스포티): ");
		String style = scan.nextLine();
		System.out.println();
		System.out.println("            ===============================================================================================");
		
		System.out.print("            등록하시겠습니까?(y/n): ");
		
		String word = scan.nextLine();
		word.toLowerCase();
		
		System.out.println();
		
		if (word.equals("y")) {
			Item item = new Item(seq, itemName, size, itemCount, price, 0, category, style, shopName);

			
			Data.itemList.add(item);
			Data.update();
			System.out.println("            상품이 등록되었습니다.");
			System.out.println();
			System.out.println("            ===================================");
			System.out.println("            상품코드: " + item.getItemCode()); 
			System.out.println("            상품명: " + item.getItemName()); 
			System.out.println("            사이즈: " + item.getSize()); 
			System.out.println("            수량: " + item.getItemCount());  
			System.out.println("            가격: " + item.getPrice());		  
			System.out.println("            카테고리: " + item.getCategory());		  
			System.out.println("            스타일: " + item.getStyle());		  
			System.out.println("            ===================================");
			System.out.println();
			MainClass.pause();
			
		} else if (word.equals("n")) {
			
			MainClass.pause();
			
		} else {
			
			System.out.println("다시 입력해주세요.");
			MainClass.pause();
		}
		
	}
			
}