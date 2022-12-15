package com.test.system;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.data.Data;
import com.test.fashion.MainClass;
import com.test.login.Login;
import com.test.member.MemberInfo;
import com.test.posting.Comments;
import com.test.posting.Post;
import com.test.shop.ShopMember;

public class SystemMemberService {

	public static void systemMemberMenu() {

		Scanner scan = new Scanner(System.in);

		System.out.println("            ======================================================");
		System.out.println("                             	  1. 회원 관리");
		System.out.println("                                  2. 쇼핑몰 관리");
		System.out.println("                                 3. 커뮤니티 관리");
		System.out.println("                                  4. 뒤로가기");
		System.out.println("            ======================================================");
		System.out.println();
		System.out.print("            선택: ");

		int select = scan.nextInt();

		if (select == 1) {

			memberManagement();

		} else if (select == 2) {

			shopMemberManagement();

		} else if (select == 3) {

			communityMangement();

		} else if (select == 4) {

			Login.mainLogin();
			return;

		} else {

			System.out.println();
			System.out.println("            다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			systemMemberMenu();

		}

	}

	private static void communityMangement() {

		Scanner scan = new Scanner(System.in);

		System.out.println("            ======================================================");
		System.out.println("                                1. 게시글 관리");
		System.out.println("                                  2. 뒤로가기");
		System.out.println("            ======================================================");
		System.out.println();
		System.out.print("            선택: ");

		int select = scan.nextInt();

		if (select == 1) {

			postMangement();

		} else if (select == 2) {

			systemMemberMenu();
			return;

		} else {

			System.out.println();
			System.out.println("            다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			communityMangement();

		}

	}

	private static void postMangement() {

		Scanner scan = new Scanner(System.in);

		System.out.println("            ======================================================");
		System.out.println("                                1. 게시글 목록 출력");
		System.out.println("                                   2. 댓글 출력");
		System.out.println("                                  3. 게시물 삭제");
		System.out.println("                                   4. 댓글 삭제");
		System.out.println("                                   5. 뒤로 가기");
		System.out.println("            ======================================================");
		System.out.println();
		System.out.print("              선택: ");

		int select = scan.nextInt();

		if (select == 1) {

			// 게시글 목록 출력
			systemMangePost();

		} else if (select == 2) {

			// 댓글 출력
			systemManageComment();

		} else if (select == 3) {

			// 게시물 삭제
			systemPostDelete();

		} else if (select == 4) {

			// 댓글 삭제
			systemCommentDelete();

		} else if (select == 5) {

			communityMangement();
			return;

		} else {

			System.out.println();
			System.out.println("            다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			postMangement();

		}

	}

	private static void systemPostDelete() {
		
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("            ====================================================================================================================");
		System.out.println("            [no]\t[작성자]\t[내용]");

		for(Post post : Data.postList) {
			
			String[] temp = post.getPostContents().split("\t");
			
			System.out.printf("            %s\t\t%-10s\t%-20s\n", post.getPostIndex(), post.getId(), temp[0] +  " ..." );
		
	}
	
		System.out.println("            ====================================================================================================================");
		System.out.println();
		
		System.out.println();
		System.out.println("            ====================================================================================================================");
		System.out.print("            삭제할 게시물 번호 입력: ");
		String postIndex = scan.nextLine();
		
		System.out.println("            ====================================================================================================================");

		boolean result = Data.deletePost(postIndex);
		
		if(result) {
			
			System.out.println();
			System.out.println("            게시물을 삭제했습니다.");
			
		} else {
			
			System.out.println();
			System.out.println("            문제가 발생했습니다. 다시 시도해주세요.");
			
		}
		
		MainClass.pause();
		postMangement();
		
	}

	private static void systemCommentDelete() {

		System.out.println();

		Scanner scan = new Scanner(System.in);

		System.out.println("            ===============================================================");
		System.out.println("            [no]\t[작성자]\t[내용]");

		for (Comments comment : Data.commentsList) {

			System.out.printf("            %-8s\t%-8s\t%-8s\n", comment.getCommentIndex(), comment.getId(), comment.getComment());

		}

		System.out.println("            ================================================================");

		System.out.println();
		System.out.println("            ================================================================");
		System.out.print("            삭제할 댓글 번호 입력: ");
		String CommentIndex = scan.nextLine();

		System.out.println("            ================================================================");

		boolean result = Data.deleteComment(CommentIndex);

		if (result) {

			System.out.println();
			System.out.println("            댓글을 삭제했습니다.");

		} else {

			System.out.println();
			System.out.println("            문제가 발생했습니다. 다시 시도해주세요.");

		}

		MainClass.pause();
		postMangement();
		
	}


	private static void systemManageComment() {

		System.out.println();

		Scanner scan = new Scanner(System.in);

		System.out.println("            ===============================================================");
		System.out.println("            [no]\t[작성자]\t[내용]");

		for (Comments comment : Data.commentsList) {

			System.out.printf("            %-8s\t%-8s\t%-8s\n", comment.getCommentIndex(), comment.getId(), comment.getComment());

		}

		System.out.println("            ================================================================");

		MainClass.pause();
		postMangement();

	}

	private static void systemMangePost() {

		System.out.println();

		Scanner scan = new Scanner(System.in);

		System.out.println("            ====================================================================================================================");
		System.out.println("            [no]\t[작성자]\t\t[내용]");
		
		for(Post post : Data.postList) {
		
			String[] temp = post.getPostContents().split("\t");
			
				System.out.printf("            %s\t\t%-10s\t\t%-20s\n", post.getPostIndex(), post.getId(), temp[0] +  " ..." );
			
		}

		System.out.println("            ====================================================================================================================");
		System.out.println();

		MainClass.pause();
		postMangement();

	}

	private static void shopMemberManagement() {

		Scanner scan = new Scanner(System.in);

		System.out.println("            ======================================================");
		System.out.println("                                1. 전체 쇼핑몰 조회");
		System.out.println("                                  2. 뒤로가기");
		System.out.println("            ======================================================");
		System.out.println();
		System.out.print("            선택: ");

		int select = scan.nextInt();

		if (select == 1) {

			showAllShopMember();

		} else if (select == 2) {

			systemMemberMenu();
			return;

		} else {

			System.out.println();
			System.out.println("            다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			systemMemberMenu();

		}

	}

	private static void showAllShopMember() {

		Scanner scan = new Scanner(System.in);

		System.out.println("            ==========================================================================================================================================================");
		System.out.println("            [ID]\t[PW]\t\t[쇼핑몰 이름]\t[사업자 번호]\t[고객센터번호]\t[스타일1]\t[스타일2]\t[주소]\t\t\t\t[대표이름]");

		for (ShopMember shopMember : Data.shopMemberList) {

			System.out.printf("            %-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\n", shopMember.getId(),
					shopMember.getPassword(), shopMember.getShopName(), shopMember.getBusinessNumber(),
					shopMember.getShopTel(), shopMember.getStyle1(), shopMember.getStyle2(),
					shopMember.getShopAddress(), shopMember.getCeoName());

		}

		System.out.println("            ==========================================================================================================================================================");
		System.out.println();
		System.out.println("                                                                  선택");
		System.out.println("                                         ======================================================");
		System.out.println("                                                             1. 쇼핑몰 수정");
		System.out.println("                                                              2. 뒤로가기");
		System.out.println("                                         ======================================================");
		System.out.println();
		System.out.print("                                         선택: ");

		int select = scan.nextInt();

		if (select == 1) {

			shopMemberCorrection();

		} else if (select == 2) {

			shopMemberManagement();
			return;

		} else {

			System.out.println();
			System.out.println("                                         다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			showAllShopMember();

		}

	}

	private static void shopMemberCorrection() {

		Scanner scan = new Scanner(System.in);

		System.out.println("                                         ======================================================");
		System.out.println("                                                              1. 패널티 관리");
		System.out.println("                                                             2. 블랙리스트 관리");
		System.out.println("                                                                3. 뒤로가기");
		System.out.println("                                         ======================================================");
		System.out.println();
		System.out.print("                                         선택: ");

		int select = scan.nextInt();

		if (select == 1) {

			shopPenaltyManagement();

		} else if (select == 2) {

			shopBlacklistManagement();

		} else if (select == 3) {

			showAllShopMember();
			return;

		} else {

			System.out.println();
			System.out.println("                                         다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			shopMemberCorrection();

		}

	}

	private static void shopBlacklistManagement() {

		Scanner scan = new Scanner(System.in);

		System.out.println("                                         ======================================================");
		System.out.println("                                                          1. 블랙리스트 목록");
		System.out.println("                                                             2. 뒤로가기");
		System.out.println("                                         ======================================================");
		System.out.println();
		System.out.print("                                         선택: ");

		int select = scan.nextInt();

		if (select == 1) {

			showShopBlacklist();

		} else if (select == 2) {

			shopMemberCorrection();
			return;

		} else {

			System.out.println();
			System.out.println("                                         다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			shopBlacklistManagement();

		}

	}

	private static void showShopBlacklist() {

		boolean flag = false;
		ArrayList<ShopMember> black = new ArrayList<ShopMember>();

		Scanner scan = new Scanner(System.in);

		System.out.println("            ==========================================================================================================================================================");
		System.out.println("            [ID]\t[PW]\t\t[쇼핑몰 이름]\t[사업자 번호]\t[고객센터번호]\t[스타일1]\t[스타일2]\t[주소]\t\t\t\t[대표이름]");
		for (ShopMember shopMember : Data.shopMemberList) {

			if (shopMember.getShopPenalty() >= 3) {

				System.out.printf("            %-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\n",
						shopMember.getId(), shopMember.getPassword(), shopMember.getShopName(),
						shopMember.getBusinessNumber(), shopMember.getShopTel(), shopMember.getStyle1(),
						shopMember.getStyle2(), shopMember.getShopAddress(), shopMember.getCeoName());

				black.add(shopMember);
				flag = true;
			}

		}

		if (!flag) {

			System.out.println("            검색된 쇼핑몰이 없습니다.");

		}

		System.out.println("            ==========================================================================================================================================================");
		System.out.println();
		System.out.println("                                                                  선택");
		System.out.println("                                         ======================================================");
		System.out.println("                                                          1. 블랙리스트 삭제");
		System.out.println("                                                              2. 뒤로가기");
		System.out.println("                                         ======================================================");
		System.out.println();
		System.out.print("                                         선택: ");

		int select = scan.nextInt();
		scan.nextLine();

		boolean blackFlag = false;

		if (select == 1) {

			System.out.println();
			System.out.print("                                         아이디: ");

			String id = scan.nextLine();

			for (ShopMember shopMember : black) {

				if (shopMember.getId().equals(id)) {

					shopMember.setShopPenalty(0);
					blackFlag = true;

					System.out.println();
					System.out.printf("                                         %s님의 쇼핑몰 %s을(를) 블랙리스트에서 삭제했습니다.", id, shopMember.getShopName());
					MainClass.pause();
					System.out.println();

					Data.update();

					systemMemberMenu();

				}

			}

			if (!blackFlag) {

				System.out.println();
				System.out.println("                                         검색된 회원이 없습니다.");
				System.out.println();
				MainClass.pause();
				System.out.println();

				showShopBlacklist();

			}

		} else if (select == 2) {

			shopBlacklistManagement();
			return;

		} else {

			System.out.println();
			System.out.println("                                         다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			showShopBlacklist();

		}

	}

	private static void shopPenaltyManagement() {

		Scanner scan = new Scanner(System.in);

		System.out.println("                                         ======================================================");
		System.out.println("                                                          1. 쇼핑몰 아이디 검색");
		System.out.println("                                                               2. 뒤로가기");
		System.out.println("                                         ======================================================");
		System.out.println();
		System.out.print("                                         선택: ");

		int select = scan.nextInt();

		if (select == 1) {

			penaltyShopId();

		} else if (select == 2) {

			shopMemberCorrection();
			return;

		} else {

			System.out.println();
			System.out.println("                                         다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			shopPenaltyManagement();

		}

	}

	private static void penaltyShopId() {

		boolean flag = false;

		ShopMember penaltyShop = new ShopMember(null, null, null, null, null, null, null, null, null, 0);

		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.print("                                         아이디: ");

		String id = scan.nextLine();

		System.out.println();
		System.out.println("            ==========================================================================================================================================================");
		System.out.println("            [ID]\t[PW]\t\t[쇼핑몰 이름]\t[사업자 번호]\t[고객센터번호]\t[스타일1]\t[스타일2]\t[주소]\t\t\t\t[대표이름]");
		
		for (ShopMember shopMember : Data.shopMemberList) {

			if (shopMember.getId().equals(id)) {

				System.out.printf("            %-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\n",
						shopMember.getId(), shopMember.getPassword(), shopMember.getShopName(),
						shopMember.getBusinessNumber(), shopMember.getShopTel(), shopMember.getStyle1(),
						shopMember.getStyle2(), shopMember.getShopAddress(), shopMember.getCeoName());

				flag = true;
				penaltyShop = shopMember;
				break;

			}

		}

		if (!flag) {

			System.out.println("            검색된 쇼핑몰이 없습니다.");

		}

		System.out.println("            ==========================================================================================================================================================");

		System.out.println();
		System.out.println("                                                                  선택");
		System.out.println("                                         ======================================================");
		System.out.println("                                                            1. 패널티 추가");
		System.out.println("                                                              2. 뒤로가기");
		System.out.println("                                         ======================================================");
		System.out.println();
		System.out.print("                                         선택: ");

		int select = scan.nextInt();

		if (select == 1) {

			penaltyShop.setShopPenalty(penaltyShop.getShopPenalty() + 1);

			System.out.println();
			System.out.printf("                                         %s님의 쇼핑몰 %s에게 패널티를 추가하였습니다.", penaltyShop.getId(),
					penaltyShop.getShopName());
			MainClass.pause();
			System.out.println();

			Data.update();

			systemMemberMenu();

		} else if (select == 2) {

			shopPenaltyManagement();
			return;

		} else {

			System.out.println();
			System.out.println("                                         다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			penaltyShopId();

		}

	}

	private static void memberManagement() {

		Scanner scan = new Scanner(System.in);

		System.out.println("            ======================================================");
		System.out.println("                             	1. 전체 회원 조회");
		System.out.println("                                  2. 뒤로가기");
		System.out.println("            ======================================================");
		System.out.println();
		System.out.print("            선택: ");

		int select = scan.nextInt();

		if (select == 1) {

			showAllMember();

		} else if (select == 2) {

			systemMemberMenu();
			return;

		} else {

			System.out.println();
			System.out.println("            다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			systemMemberMenu();

		}

	}

	private static void showAllMember() {

		Scanner scan = new Scanner(System.in);

		System.out.println("            =============================================================================================================================");
		System.out.println("            [ID]\t[PW]\t\t[이름]\t\t[성별]\t\t[생년월일]\t[전화번호]\t[주소]");

		for (MemberInfo memberInfo : Data.memberInfoList) {

			System.out.printf("            %-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\n", memberInfo.getId(),
					memberInfo.getPassword(), memberInfo.getName(),
					memberInfo.getGender() == 1 ? "남자" : (memberInfo.getGender() == 2 ? "여자" : "알수없음"),
					memberInfo.getBirth(), memberInfo.getTel(), memberInfo.getAddress());

		}

		System.out.println("            =============================================================================================================================");
		System.out.println();
		System.out.println("                                                                      선택");
		System.out.println("                                         ==========================================================");
		System.out.println("                                                                 1. 회원 수정");
		System.out.println("                                                                  2. 뒤로가기");
		System.out.println("                                         ==========================================================");
		System.out.println();
		System.out.print("                                         선택: ");

		int select = scan.nextInt();

		if (select == 1) {

			memberCorrection();

		} else if (select == 2) {

			memberManagement();
			return;

		} else {

			System.out.println();
			System.out.println("                                         다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			showAllMember();

		}

	}

	private static void memberCorrection() {

		Scanner scan = new Scanner(System.in);

		System.out.println("                                         ======================================================");
		System.out.println("                             	                             1. 패널티 관리");
		System.out.println("                                                           2. 블랙리스트 관리");
		System.out.println("                                                               3. 뒤로가기");
		System.out.println("                                         ======================================================");
		System.out.println();
		System.out.print("                                         선택: ");

		int select = scan.nextInt();

		if (select == 1) {

			penaltyManagement();

		} else if (select == 2) {

			blacklistManagement();

		} else if (select == 3) {

			showAllMember();
			return;

		} else {

			System.out.println();
			System.out.println("                                         다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			memberCorrection();

		}

	}

	private static void blacklistManagement() {

		Scanner scan = new Scanner(System.in);

		System.out.println("                                         ======================================================");
		System.out.println("                                                           1. 블랙리스트 목록");
		System.out.println("                                                               2. 뒤로가기");
		System.out.println("                                         ======================================================");
		System.out.println();
		System.out.print("                                         선택: ");

		int select = scan.nextInt();

		if (select == 1) {

			showBlacklist();

		} else if (select == 2) {

			memberCorrection();
			return;

		} else {

			System.out.println();
			System.out.println("                                         다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			blacklistManagement();

		}

	}

	private static void showBlacklist() {

		boolean flag = false;
		ArrayList<MemberInfo> black = new ArrayList<MemberInfo>();

		Scanner scan = new Scanner(System.in);

		System.out.println("            =============================================================================================================================");
		System.out.println("            [ID]\t[PW]\t\t[이름]\t\t[성별]\t\t[생년월일]\t[전화번호]\t[주소]");

		for (MemberInfo memberInfo : Data.memberInfoList) {

			if (memberInfo.getMemberPenalty() >= 3) {

				System.out.printf("            %-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\n", memberInfo.getId(),
						memberInfo.getPassword(), memberInfo.getName(),
						memberInfo.getGender() == 1 ? "남자" : (memberInfo.getGender() == 2 ? "여자" : "알수없음"),
						memberInfo.getBirth(), memberInfo.getTel(), memberInfo.getAddress());

				black.add(memberInfo);
				flag = true;
			}

		}

		if (!flag) {

			System.out.println("                                         검색된 회원이 없습니다.");

		}

		System.out.println("            =============================================================================================================================");
		System.out.println();
		System.out.println("                                                                   선택");
		System.out.println("                                         ======================================================");
		System.out.println("                                                            1. 블랙리스트 삭제");
		System.out.println("                                                                2. 뒤로가기");
		System.out.println("                                         ======================================================");
		System.out.println();
		System.out.print("                                         선택: ");

		int select = scan.nextInt();
		scan.nextLine();

		boolean blackFlag = false;

		if (select == 1) {

			System.out.println();
			System.out.print("                                         아이디: ");

			String id = scan.nextLine();

			for (MemberInfo memberInfo : black) {

				if (memberInfo.getId().equals(id)) {

					memberInfo.setMemberPenalty(0);
					blackFlag = true;

					System.out.println();
					System.out.printf("                                         %s님을 블랙리스트에서 삭제했습니다.", id);
					MainClass.pause();
					System.out.println();

					Data.update();

					systemMemberMenu();

				}

			}

			if (!blackFlag) {

				System.out.println();
				System.out.println("                                         검색된 회원이 없습니다.");
				System.out.println();
				MainClass.pause();
				System.out.println();

				showBlacklist();

			}

		} else if (select == 2) {

			blacklistManagement();
			return;

		} else {

			System.out.println();
			System.out.println("                                         다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			showBlacklist();

		}

	}

	private static void penaltyManagement() {

		Scanner scan = new Scanner(System.in);

		System.out.println("                                         ======================================================");
		System.out.println("                             	                             1. 아이디 검색");
		System.out.println("                                                              2. 뒤로가기");
		System.out.println("                                         ======================================================");
		System.out.println();
		System.out.print("                                         선택: ");

		int select = scan.nextInt();

		if (select == 1) {

			penaltyId();

		} else if (select == 2) {

			memberCorrection();
			return;

		} else {

			System.out.println();
			System.out.println("                                         다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			penaltyManagement();

		}

	}

	private static void penaltyId() {

		boolean flag = false;
		MemberInfo penaltyMember = new MemberInfo(null, null, null, 0, null, null, null, 0);

		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.print("                                         아이디: ");

		String id = scan.nextLine();

		System.out.println();
		System.out.println("            =============================================================================================================================");
		System.out.println("            [ID]\t[PW]\t\t[이름]\t\t[성별]\t\t[생년월일]\t[전화번호]\t[주소]");

		for (MemberInfo memberInfo : Data.memberInfoList) {

			if (memberInfo.getId().equals(id)) {

				System.out.printf("            %-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\n", memberInfo.getId(),
						memberInfo.getPassword(), memberInfo.getName(),
						memberInfo.getGender() == 1 ? "남자" : (memberInfo.getGender() == 2 ? "여자" : "알수없음"),
						memberInfo.getBirth(), memberInfo.getTel(), memberInfo.getAddress());

				flag = true;
				penaltyMember = memberInfo;
				break;

			}

		}

		if (!flag) {

			System.out.println("                                         검색된 회원이 없습니다.");

		}

		System.out.println("            =============================================================================================================================");

		System.out.println();
		System.out.println("                                                                  선택");
		System.out.println("                                         ======================================================");
		System.out.println("                                                             1. 패널티 추가");
		System.out.println("                                                               2. 뒤로가기");
		System.out.println("                                         ======================================================");
		System.out.println();
		System.out.print("                                         선택: ");

		int select = scan.nextInt();

		if (select == 1) {

			penaltyMember.setMemberPenalty(penaltyMember.getMemberPenalty() + 1);

			System.out.println();
			System.out.printf("                                         %s님에게 패널티를 추가하였습니다.", penaltyMember.getId());
			MainClass.pause();
			System.out.println();

			Data.update();

			systemMemberMenu();

		} else if (select == 2) {

			penaltyManagement();
			return;

		} else {

			System.out.println();
			System.out.println("                                         다시 입력해주세요.");
			MainClass.pause();
			System.out.println();

			penaltyId();

		}

	}

}
