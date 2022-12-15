package com.test.posting;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.cart.CartMenu;
import com.test.cart.LikeMenu;
import com.test.data.Data;
import com.test.fashion.MainClass;
import com.test.item.Item;
import com.test.login.Login;
import com.test.member.MemberService;

public class postService {

	public static void mainPostService() {
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("            ======================================================");
			System.out.println("                                 1. 게시물 목록보기");
			System.out.println("                                 2. 게시물 검색하기");
			System.out.println("                                 3. 게시물 작성하기");
			System.out.println("                                 4. 게시물 삭제하기");
			System.out.println("                                    5. 뒤로가기");
			System.out.println("            ======================================================");
			System.out.println();
			System.out.print("              번호 입력: ");
			String select = scan.nextLine();
			
			if(select.equals("1")) {
				
				//게시물 목록보기
				viewPost();
				
			} else if(select.equals("2")) {
				
				//게시물 검색하기
				searchPost();
				
			} else if(select.equals("3")) {
				
				//게시물 작성하기
				writePost();
				
			} else if(select.equals("4")) {
				
				//게시물 삭제하기
				deletePost();
				
			} else if(select.equals("5")) {
				
				//뒤로가기
				
				MemberService.memberMenu();

				
			} else {
				
				System.out.println();
				System.out.println("다시 입력해주세요.");
				System.out.println();
				MainClass.pause();
				mainPostService();
				
			}
		}
		
	}//mainPostService

	

private static void viewPost() {
		
		//목록보기
		Scanner scan = new Scanner(System.in);
						
		System.out.println();
		
		System.out.println("            ====================================================================================================================");
		System.out.println("            [no]\t[작성자]\t\t[내용]");
		
		for(Post post : Data.postList) {
		
			String[] temp = post.getPostContents().split("\t");
			
				System.out.printf("            %s\t\t%-10s\t\t%-20s\n", post.getPostIndex(), post.getId(), temp[0] +  " ..." );
			
		}
		
		System.out.println("            ====================================================================================================================");
		System.out.println();
		System.out.print("            조회할 게시물 선택(번호, 그냥 엔터(나기기)): ");
		
		
		String postIndex = scan.nextLine();
		
		if(!postIndex.equals("")) {
			
			//특정 게시물 자세히 보기
			Post post = Data.getPost(postIndex);
			
			String[] temp = post.getPostContents().split("\t");
			
			System.out.println();
			System.out.println("            ====================================================================================================================");
			System.out.println("            [작성자: " + post.getId() + "]");
			System.out.println();
			
			for (int i=0; i<temp.length; i++) {
                System.out.println("            " +temp[i]);
			}
			System.out.println();
			System.out.println();
			
			for(Item item : Data.itemList) {
				
				if(item.getItemCode() == post.getItemCode()) {
					
					System.out.println("            착용 상품(상품코드): " + item.getItemName() + "(" + post.getItemCode() + ")");
				}
				
			}
			
			System.out.println("            스타일: " + post.getStyle());
			System.out.println("            ---------------------------------------------------------------------------------------------------------------------");
			System.out.println("                                                                   [댓글]");
			//댓글나오게
								
			for(Comments comment : Data.commentsList) {
					
				if(comment.getPostIndex().equals(postIndex)) {
						
					System.out.println("            " + comment.getId() +"님: " + comment.getComment());

				}
			}
			
			System.out.println("            ====================================================================================================================");
			System.out.println();
			System.out.println("                                         ==========================================================");
			System.out.println("                                                                 1. 구매하기");
			System.out.println("                                                              2. 장바구니 추가");
			System.out.println("                                                               3. 찜목록 추가");
			System.out.println("                                                                 4. 뒤로가기");
			System.out.println("                                         ==========================================================");
			System.out.println();
			
			System.out.print("            번호 입력:");
			String number = scan.nextLine();
			
			if(number.equals("1")) {
				
				//구매하기
		         System.out.println();
		         System.out.println("            ======================================================");
		         System.out.println("                         주문이 완료되었습니다! 감사합니다!");
		         System.out.println("                              행복한 하루 보내세요!");
		         System.out.println("            ======================================================");
		         
		         MainClass.pause();
		         
		         System.out.println();
		         MemberService.memberMenu();
				
			} else if(number.equals("2")) {
				
				//장바구니 추가
				CartMenu.cartMenu();
				
			} else if(number.equals("3")) {
				
				//찜목록 추가
				LikeMenu.likeMenu();
				
			} else if(number.equals("4")) {
				
				viewPost();
				
			} else {
				
				System.out.println("다시 입력해주세요.");
				return;
			}
		}
		
		MainClass.pause();
		
	}//viewPost
	
	private static void searchPost() {
		
		
		//검색하기
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("            ==========================================================================================================================================================");
		
		System.out.println("                                         " + "스타일 선택 ( 미니멀, 아메카지, 시티보이, 캐주얼, 스트릿, 하이틴, 로맨틱, 걸리쉬, 스포티)");
		System.out.println("            ==========================================================================================================================================================");
		System.out.print("             선택: ");
		String style = scan.nextLine();
		System.out.println();
		
		//완전 검색 or 부분 검색
		ArrayList<Post> plist = Data.searchPost(style);
		
		if(plist.size() != 0) {
			
			System.out.println("             [no]\t[작성자]\t[좋아요수]\t[상품태그]\t[스타일태그]\t[내용]");
			
			for(Post post : plist) {
				String[] temp = post.getPostContents().split("\t");
				
				System.out.printf("             %3s\t%-12s\t%d\t\t%d\t\t%s\t\t%s\n", post.getPostIndex(), post.getId(), post.getLike(), post.getItemCode(), post.getStyle(), temp[0] + " ...");
			}
						
		} else {
			
			System.out.println("              검색한 스타일의 게시글이 없습니다.");
		}
		
		System.out.println();
		System.out.println("            ==========================================================================================================================================================");
		
		MainClass.pause();
		
		
	}//searchPost

	private static void writePost() {
		
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		while(loop) {
		System.out.println("            ======================================================");
		System.out.println("                             1. 게시물 내용 입력");
		System.out.println("                                2. 뒤로 가기");		
		System.out.println("            ======================================================");
		System.out.print("             번호 입력: ");
		
		String select = scan.nextLine();
		
		if(select.equals("1")) { //게시물 작성
			
			String postIndex = Data.createPostIndex();
			
			String id = Login.MemberId; //아이디 저장?
			
			System.out.println();

			System.out.println("            ==========================================================================================================================================================");
			System.out.print("            게시물 내용: ");
			String postContents = scan.nextLine();
			
			System.out.print("            상품 태그: ");
			int itemCode = scan.nextInt();
			scan.nextLine();
			
			System.out.print("            스타일 태그(미니멀, 아메카지, 시티보이, 캐주얼, 스트릿, 하이틴, 로맨틱, 걸리쉬, 스포티): ");
			String style = scan.nextLine();
			
			Post post = new Post();
			
			post.setPostIndex(postIndex);
			post.setPostContents(postContents);
			post.setItemCode(itemCode);
			post.setStyle(style);
			post.setId(id);
		
			System.out.println("            ==========================================================================================================================================================");
			System.out.println();
			System.out.print("            계속하시겠습니까?(y / n): " );
			String input = scan.nextLine();
			
			if(input.equals("y")) {
				
				Data.postList.add(post);
				writePost();
				
				
			} else if (input.equals("n")){
				
				return;
			}
			
		} else if(select.equals("2")) {
			
			loop = false;
		
		} else {
			
			System.out.println();
			System.out.println("            다시 입력해주세요.");
			System.out.println();
			MainClass.pause();
			writePost();
			
			}
		}
		
		
	}//writePost
	

	private static void deletePost() {
		//merdi82,zsOe1
		//삭제하기
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
		
	}//deletePost
	
	
}
