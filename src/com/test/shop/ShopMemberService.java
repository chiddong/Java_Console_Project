package com.test.shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.test.data.Data;
import com.test.fashion.MainClass;
import com.test.item.ShopItemService;
import com.test.login.Login;
import com.test.member.MemberInfo;
import com.test.member.MemberService;

public class ShopMemberService {

	public static void shopMemberMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("            ======================================================");
		System.out.println("                                    1. 상품");
		System.out.println("                                 2. 뒤로 가기");
		System.out.println("            ======================================================");
		System.out.println();
		System.out.print("            선택: ");

		int select = scan.nextInt();
		
		if (select == 1) {
			
			ShopItemService.begin();
			
		}  else if (select == 2) {
			
			Login.mainLogin();
			return;
			
		} else {
			
			System.out.println();
			System.out.println("            다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			shopMemberMenu();
			
		}
		
	}

	public static void createShopMember() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("            ======================================================");
		System.out.print("            아이디: ");
		
		String id = scan.nextLine();
		
		System.out.print("            비밀번호: ");
		
		String password = scan.nextLine();
		
		System.out.print("            쇼핑몰 이름: ");
		
		String shopName = scan.nextLine();
		
		System.out.print("            사업자 번호: ");
		
		String businessNumber = scan.nextLine();
		businessNumber = businessNumber.replace("-", "");
		
		System.out.print("            고객센터 번호: ");
		
		String shopTel = scan.nextLine();
		shopTel = shopTel.replace("-", "");
		
		System.out.println("            스타일 목록");
		System.out.println("            (1.미니멀 2.아메카지 3.시티보이 4.캐주얼 5.스트릿 6.하이틴 7.로맨틱 8. 걸리쉬 9.스포티): ");
		
		System.out.print("            스타일1: ");
		int style1 = scan.nextInt();
		scan.nextLine();
		
		System.out.print("            스타일2: ");
		
		int style2 = scan.nextInt();
		scan.nextLine();
		
		System.out.print("            주소: ");
		
		String shopAddress = scan.nextLine();
		
		System.out.print("            대표 이름: ");
		
		String ceoName = scan.nextLine();
		
		System.out.println("            ======================================================");
		System.out.println();
		
		if (isShopValid(id, password, shopName, businessNumber, shopTel, style1, style2, shopAddress, ceoName)) {
			
			System.out.println();
			System.out.println("                                      선택");
			System.out.println("            ======================================================");
			System.out.println("                                  1. 가입하기");
			System.out.println("                                  2. 뒤로가기");
			System.out.println("            ======================================================");
			System.out.println();
			System.out.print("            선택: ");

			int select = scan.nextInt();
			
			if (select == 1) {
				
				Map<Integer,String> style = new HashMap<Integer,String>();
				
				style.put(1, "미니멀");
				style.put(2, "아메카지");
				style.put(3, "시티보이");
				style.put(4, "캐주얼");
				style.put(5, "스트릿");
				style.put(6, "하이틴");
				style.put(7, "로맨틱");
				style.put(8, "걸리쉬");
				style.put(9, "스포티");

				ShopMember shopMember = new ShopMember(id, password, shopName, businessNumber, shopTel, style.get(style1), style.get(style2), shopAddress, ceoName, 0);
				Data.shopMemberList.add(shopMember);
				
				System.out.println();
				System.out.println("            가입이 완료되었습니다.");
				MainClass.pause();
				System.out.println();

				Data.update();

				MainClass.main(null);
				
			} else if (select == 2) {
				
				MemberService.createMember();
				return;
				
			}  else {
				
				System.out.println();
				System.out.println("            다시 입력해주세요.");
				MainClass.pause();
				System.out.println();

				createShopMember();
				
			}
			
		} else {
			
			System.out.println();
			System.out.println("            가입에 실패했습니다.");
			MainClass.pause();
			System.out.println();

			MainClass.main(null);
			
		}
		
	}

	private static boolean isShopValid(String id, String password, String shopName, String businessNumber,
			String shopTel, int style1, int style2, String shopAddress, String ceoName) {
		
		String regex = ""; //정규식
		Pattern pattern = null; //정규식 객체
		Matcher matcher = null; //검사 결과 객체
		
		//아이디
		regex = "^[A-Za-z_][A-Za-z0-9_]{3,11}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(id);
		
		if (!matcher.find()) {
			
			System.out.println("            아이디는 4~12자 이내로 입력하세요.(영어/숫자/_ 조합, 숫자 시작 불가능)");
			
			return false;
			
		}
		
		for (ShopMember shopMember : Data.shopMemberList) {
			
			if (id.equals(shopMember.getId())) {
				
				System.out.println("            중복되는 아이디가 있습니다.");
				
				return false;
				
			}
			
		}
		
		//비밀번호
		regex = "^[A-Za-z0-9]{8,16}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(password);
		
		if (!matcher.find()) {
			
			System.out.println("            비밀번호는 8~16자 이내로 입력하세요.(영어/숫자 조합)");
			
			return false;
			
		}
		
		//쇼핑몰 이름
		regex = "^[가-힣A-Za-z]{2,10}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(shopName);
		
		if (!matcher.find()) {
			
			System.out.println("            쇼핑몰 이름은 2~10자 이내로 입력하세요.(한글/영어 입력 가능)");
			
			return false;
			
		}
		
		//사업자 번호
		regex = "^[0-9]{12}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(businessNumber);
		
		if (!matcher.find()) {
			
			System.out.println("            사업자번호는 숫자로 입력하세요.(12자리)");
			
			return false;
			
		}
		
		//고객센터 번호
		regex = "^[0-9]{8,13}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(shopTel.replace("-", ""));
		
		if (!matcher.find()) {
			
			System.out.println("            고객센터 번호는 숫자로 입력하세요.(8~13자리)");
			
			return false;
			
		}
		
		//스타일1
		regex = "^[0-9]$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(style1 + "");
		
		if (!matcher.find()) {
			
			System.out.println("            스타일은 숫자로 입력하세요.(1.미니멀 2.아메카지 3.시티보이 4.캐주얼 5.스트릿 6.하이틴 7.로맨틱 8. 걸리쉬 9.스포티)");
			
			return false;
			
		}
		
		//스타일2
		regex = "^[0-9]$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(style2 + "");
		
		if (!matcher.find()) {
			
			System.out.println("            스타일은 숫자로 입력하세요.(1.미니멀 2.아메카지 3.시티보이 4.캐주얼 5.스트릿 6.하이틴 7.로맨틱 8. 걸리쉬 9.스포티)");
			
			return false;
			
		}
		
		//주소
		regex = "^[가-힣0-9-\\s]+$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(shopAddress);
		
		if (!matcher.find()) {
			
			System.out.println("            주소는 한글/숫자/-만 사용하여 입력하세요.");
			
			return false;
			
		}
		
		//대표 이름
		regex = "^[가-힣]{2,5}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(ceoName);
		
		if (!matcher.find()) {
			
			System.out.println("            대표 이름은 2~5자 이내로 입력하세요.(한글만 입력 가능)");
			
			return false;
			
		}

		return true;

	}

}
