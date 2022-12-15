package com.test.member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.test.buyHistory.BuyHistory;
import com.test.cart.CartMenu;
import com.test.cart.LikeMenu;
import com.test.data.Data;
import com.test.fashion.MainClass;
import com.test.item.MemberItemService;
import com.test.item.RecommendItem;
import com.test.login.Login;
import com.test.posting.postService;
import com.test.shop.ShopMemberService;

public class MemberService {
	
	public static void memberMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("            ┌─────────────────────────────────────────────────────┐");
		System.out.println("                              1. 상품 또는 스타일 검색");
		System.out.println("                              2. 장바구니 목록");
		System.out.println("                              3. 찜 목록");
		System.out.println("                              4. 게시판");
		System.out.println("                              5. 상품 추천");
		System.out.println("                              6. 회원 정보 수정");
		System.out.println("                              7. 회원 탈퇴");
		System.out.println("                              8. 뒤로 가기");
		System.out.println("            └─────────────────────────────────────────────────────┘");	
		System.out.println();
		System.out.print("            ▶ 선택: ");

		int select = scan.nextInt();
		
		if (select == 1) {
			
			MemberItemService.begin();
			
		} else if (select == 2) {
			
			CartMenu.cartMenu();
			
		} else if (select == 3) {
			
			LikeMenu.likeMenu();
			
		} else if (select == 4) {
			
			postService.mainPostService();
			
		} else if (select == 5) {
			
			RecommendItem.begin();
			
		} else if (select == 6) {
			
			memberCorrection();
			
		} else if (select == 7) {
			
			memberRemove();
			
		} else if (select == 8) {
			
			Login.mainLogin();
			return;
			
		} else {
			
			System.out.println();
			System.out.println("            다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			memberMenu();
			
		}
		
	}

	private static void memberRemove() {
		
		boolean flag = false;
		MemberInfo member = new MemberInfo(null, null, null, 0, null, null, null, 0);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("            ======================================================");
		System.out.print("            아이디: ");
		
		String id = scan.nextLine();
		
		System.out.print("            비밀번호: ");
		
		String password = scan.nextLine();
		
		System.out.print("            전화번호: ");
		
		String tel = scan.nextLine();
		tel = tel.replace("-", "");
		
		System.out.println("            ======================================================");
		System.out.println();

		for (MemberInfo memberInfo : Data.memberInfoList) {
			
			if (memberInfo.getId().equals(Login.MemberId)) {
				
				if (memberInfo.getId().equals(id) && memberInfo.getPassword().equals(password) && memberInfo.getTel().equals(tel)) {
					
					flag = true;
					
					member = memberInfo;
					
					System.out.print("            정말 탈퇴하시겠습니까?(y/n): ");
					String select = scan.nextLine();
					
					if (select.equals("y")) {
						
						Data.memberInfoList.remove(member);
						
						System.out.println();
						System.out.println("            회원 탈퇴가 완료되었습니다.");
						MainClass.pause();
						System.out.println();
						
						Data.update();
						
						MainClass.main(null);
						
					} else {
						
						System.out.println();
						System.out.println("            회원 탈퇴를 취소합니다.");
						MainClass.pause();
						System.out.println();
						
						MemberService.memberMenu();
						
					}
					
				} else {
					
					System.out.println();
					System.out.println("            입력한 정보가 올바르지 않습니다.");
					MainClass.pause();
					System.out.println();
					
					memberRemove();
					
				}
				
			}
			
		}
		
		if (!flag) {
			
			System.out.println();
			System.out.println("            입력한 정보가 올바르지 않습니다.");
			MainClass.pause();
			System.out.println();
			
			memberRemove();
			
		}
		
	}

	private static void memberCorrection() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("            ======================================================");
		System.out.println("                                    1. 이름");
		System.out.println("                                    2. 성별");
		System.out.println("                                    3. 주소");
		System.out.println("                                   4. 전화번호");
		System.out.println("                                   5. 생년월일");
		System.out.println("                                   6. 뒤로가기");
		System.out.println("            ======================================================");
		System.out.println();
		System.out.print("            선택: ");

		int select = scan.nextInt();
		scan.nextLine();
		
		if (select == 1) {
			
			System.out.print("            새로 입력: ");
			String reName = scan.nextLine();
			
			for (MemberInfo memberInfo : Data.memberInfoList) {
				
				if (memberInfo.getId().equals(Login.MemberId)) {
					
					memberInfo.setName(reName);
					
					System.out.println();
					System.out.printf("            정보 수정이 완료되었습니다.");
					MainClass.pause();
					System.out.println();
					
					Data.update();
					
					memberMenu();
	
				}

			}

		} else if (select == 2) {
			
			System.out.print("            새로 입력(1.남자 2.여자 3.알수없음): ");
			int reGender = scan.nextInt();
			scan.nextLine();
			
			for (MemberInfo memberInfo : Data.memberInfoList) {
				
				if (memberInfo.getId().equals(Login.MemberId)) {
					
					memberInfo.setGender(reGender);
					
					System.out.println();
					System.out.printf("            정보 수정이 완료되었습니다.");
					MainClass.pause();
					System.out.println();
					
					Data.update();
					
					memberMenu();
	
				}

			}
			
		} else if (select == 3) {
			
			System.out.print("            새로 입력: ");
			String reAddress = scan.nextLine();
			
			for (MemberInfo memberInfo : Data.memberInfoList) {
				
				if (memberInfo.getId().equals(Login.MemberId)) {
					
					memberInfo.setAddress(reAddress);
					
					System.out.println();
					System.out.printf("            정보 수정이 완료되었습니다.");
					MainClass.pause();
					System.out.println();
					
					Data.update();
					
					memberMenu();
	
				}

			}
			
		} else if (select == 4) {
			
			System.out.print("            새로 입력: ");
			String reTel = scan.nextLine();
			
			for (MemberInfo memberInfo : Data.memberInfoList) {
				
				if (memberInfo.getId().equals(Login.MemberId)) {
					
					memberInfo.setTel(reTel);
					
					System.out.println();
					System.out.printf("            정보 수정이 완료되었습니다.");
					MainClass.pause();
					System.out.println();
					
					Data.update();
					
					memberMenu();
	
				}

			}
			
		} else if (select == 5) {
			
			System.out.print("            새로 입력(8자리): ");
			String reBirth = scan.nextLine();
			
			if (reBirth.length() != 8) {
				
				System.out.println("            생년월일은 8자리로 입력해주세요.");
				
				memberCorrection();
				
			}
			
			for (MemberInfo memberInfo : Data.memberInfoList) {
				
				if (memberInfo.getId().equals(Login.MemberId)) {
					
					memberInfo.setBirth(reBirth);
					
					System.out.println();
					System.out.printf("            정보 수정이 완료되었습니다.");
					MainClass.pause();
					System.out.println();
					
					Data.update();
					
					memberMenu();
	
				}

			}
			
		} else if (select == 6) {

			memberMenu();
			return;
			
		} else {
			
			System.out.println();
			System.out.println("            다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			memberCorrection();
			
		}
	
	}

	public static ArrayList<BuyHistory> getBuyList(String id) {

		try {
			
			//wble83,192,1,달보드레느루

			ArrayList<BuyHistory> list = new ArrayList<BuyHistory>();
			BufferedReader read = new BufferedReader(new FileReader(".\\dat\\buyList.txt"));
			
			String line = null;
			
			while ((line = read.readLine()) != null) {
				
				String[] temp = line.split(",");
			
				if (temp[0].equals(id)) {
			
					BuyHistory buyHistory = new BuyHistory(id, Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), temp[3]);
					
					list.add(buyHistory);
				
				}
				
			}
			
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	}

	public static void createMember() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("            ======================================================");
		System.out.println("                                  1. 개인 회원 가입");
		System.out.println("                                 2. 쇼핑몰 회원 가입");
		System.out.println("                                   3. 뒤로가기");
		System.out.println("            ======================================================");
		System.out.println();
		System.out.print("            선택: ");

		int select = scan.nextInt();
		scan.nextLine();
		
		if (select == 1) {
			
			createPersonMember();
			
		} else if (select == 2) {
			
			ShopMemberService.createShopMember();
			
		} else if (select == 3) {
			
			MainClass.main(null);
			return;
	
		} else {
			
			System.out.println();
			System.out.println("            다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			createMember();
			
		}
	
	}

	private static void createPersonMember() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("            ======================================================");
		System.out.print("            아이디: ");
		
		String id = scan.nextLine();
		
		System.out.print("            비밀번호: ");
		
		String password = scan.nextLine();
		
		System.out.print("            이름: ");
		
		String name = scan.nextLine();
		
		System.out.print("            성별(1.남자 2.여자 3.알수없음): ");
		
		int gender = scan.nextInt();
		scan.nextLine();
		
		System.out.print("            생년월일(8자리): ");
		
		String birth = scan.nextLine();
		
		System.out.print("            전화번호: ");
		
		String tel = scan.nextLine();
		tel = tel.replace("-", "");
		
		System.out.print("            주소: ");
		
		String address = scan.nextLine();
		
		System.out.println("            ======================================================");
		System.out.println();
		
		if (isMemberValid(id, password, name, gender, birth, tel, address)) {
			
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
				
				MemberInfo memberInfo = new MemberInfo(id, password, name, gender, birth, tel, address, 0);
				Data.memberInfoList.add(memberInfo);
				
				System.out.println();
				System.out.println("            가입이 완료되었습니다.");
				MainClass.pause();
				System.out.println();

				Data.update();

				MainClass.main(null);
				
			} else if (select == 2) {
				
				createMember();
				return;
				
			}  else {
				
				System.out.println();
				System.out.println("            다시 입력해주세요.");
				MainClass.pause();
				System.out.println();

				createPersonMember();
				
			}
			
		} else {
			
			System.out.println();
			System.out.println("            가입에 실패했습니다.");
			MainClass.pause();
			System.out.println();

			MainClass.main(null);
			
		}
		
	}
	
	private static boolean isMemberValid(String id, String password, String name, int gender, String birth, String tel, String address) {
		
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
		
		for (MemberInfo memberInfo : Data.memberInfoList) {
			
			if (id.equals(memberInfo.getId())) {
				
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
		
		//성별
		regex = "^[1-3]$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(gender + "");
		
		if (!matcher.find()) {
			
			System.out.println("            성별은 숫자로 입력하세요.(1.남자 2.여자 3.알수없음)");
			
			return false;
			
		}
		
		//생년월일
		regex = "^[0-9]{8}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(birth);
		
		if (!matcher.find()) {
			
			System.out.println("            생년월일은 숫자로 입력하세요.(8자리)");
			
			return false;
			
		}
		
		//이름
		regex = "^[가-힣]{2,5}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(name);
		
		if (!matcher.find()) {
			
			System.out.println("            이름은 2~5자 이내로 입력하세요.(한글만 입력 가능)");
			
			return false;
			
		}
		
		//전화번호
		regex = "^01[01][0-9]{4}[0-9]{4}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(tel.replace("-", ""));
		
		if (!matcher.find()) {
			
			System.out.println("            전화번호는 010 또는 011 포함 11자로 입력하세요.(숫자만 입력 가능)");
			
			return false;
			
		}
		
		//주소
		regex = "^[가-힣0-9-\\s]+$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(address);
		
		if (!matcher.find()) {
			
			System.out.println("            주소는 한글/숫자/-만 사용하여 입력하세요.");
			
			return false;
			
		}

		return true;
		
	}
	
}
