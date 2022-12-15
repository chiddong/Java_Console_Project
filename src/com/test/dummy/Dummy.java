package com.test.dummy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

import com.test.buyHistory.BuyHistory;
import com.test.member.MemberService;

public class Dummy {

	public static void main(String[] args) {
		
		try {
			//member();
			//shopMember();
			//item();
			//postItem();
			//buyList();
			//comment();
			//apply();
			//student();
			consult();
			//random1();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void random1() {
		// TODO Auto-generated method stub
		// insert into tblInterview values (1, , );
		
		for (int i=1; i<=20; i++) {
			System.out.printf("insert into tblInterview values (%d, 5, %d);\n", i+80, i+80); 
		}
		
	}

	private static void consult() {
		// TODO Auto-generated method stub
		Random rnd = new Random();
		//insert into tblSchedule values(스케줄번호, 스케줄상태, 과목번호, 과정번호, 과목기간, 강의실번호, 과정기간, 교육생등록인원, 교사번호);
		

			
			//insert into tblGrade values(1, exam_seq, i, grade_score);

		String[] attitude = {"상", "중", "하"} ;
		String[] state = {"강의중", "강의 예정", "대기중"};
		
		String[] grade = {"A", "B", "C", "B", "B", "C", "D"};
		
				//22/07/25	23/01/03	1	(디지털컨버젼스)AWS 클라우드 활용 자바(Java) Full-Stack 개발자 양성 과정(G)
		for(int i=1; i<=25 ; i++) {
			
		String data = String.format("insert into tblGrade values(%d, 13, %d, '%s');",
						i+50,
						i,
						grade[rnd.nextInt(grade.length)]);
		
		System.out.println(data);
		
	}

		
		String[] name1 = { "김", "이", "박", "정", "최", "손", "유", "홍", "채", "우", "현" };
		String[] name2 = { "우", "찬", "서", "유", "빈", "지", "신", "석", "효", "정", "섭", "현", "진", "재", "형", "민", "성", "림",
				"나", "연", "영" };
		

		String[] major = {"전공", "비전공", "관련전공"};
		
		String[] content1 = {"자바", "오라클", "공부", "취업", "DB", 
							"네트워크", "자료구조", "HTML", "데이터베이스", "파이썬", 
							"C언어", "C++", "정보처리기사", "자격증", "C#", "SQL", "컴활", "MySQL", "프로그래밍"};
		
		String[] content2 = {"부족", "보충 필요", "우수", "미흡", "매우 잘함", "힘들어함", "어려워함", "진도를 못따라옴", 
							"복습이 필요함", "추가 과제 필요", "과제 미흡", "태도 불량", "수업태도 좋음"};
		
		String[] way = {"대면", "비대면"};
		
		String[] emp = {"취업", "미취업"};
		
//		String[] temp1 = {"수업", "진도", "강의", "필기", "쉬는시간", "교재", "프로젝트", "과제", "자바", "오라클", "코딩", "네트워크",
//		"공부", "취업", "DB", "자료구조", "HTML", "데이터베이스", "파이썬", 
//		"C언어", "C++", "정보처리기사", "자격증", "C#", "SQL", "컴활", "MySQL", "프로그래밍"};
//
//String[] temp2 = {"빨라요", "천천히 설명해주세요", "너무 느려요", "자세히 설명해주세요.", "부족해요", "감사해요", "도움이 많이 됐어요.", "늘려주세요.", "힘들어요", "없애주세요.", "어려워요.", "시간이 부족해요.", "이해가 잘돼요"};


String[] temp1 = {"수업", "커리큘럼", "관리자", "시설", "교통", "강의", "강의실", "정수기", "종이컵", "사물함", "동기"};

String[] temp2 = {"매우 좋아요", "좋아요", "보통이에요", "낫배드", "별로에요", "매우 별로에요"};
	

		
		
	}

	private static void student() {
		// TODO Auto-generated method stub
		
		Random rnd = new Random();
		
		String[] name1 = { "김", "이", "박", "정", "최", "손", "유", "홍", "채", "우", "현" };
		String[] name2 = { "우", "찬", "서", "유", "빈", "지", "신", "석", "효", "정", "섭", "현", "진", "재", "형", "민", "성", "림",
				"나", "연", "영" };
		
		//String[] date1 = {"2022-07-25', '2022-08-01', '2022-08-18',	'2022-08-29', '2022-09-05',	'2022-09-26'};
		
		//insert into tblStudent values(1, 'name', 'tel', 'ssn', 'regisdate', 1);
		for(int i=1; i<=25 ; i++) {
		String data = String.format("insert into tblStudent values(%d, '%s', '%s', '%s', '2022-09-26', 1);",
						i+125,									
						name1[rnd.nextInt(name1.length)]   
						+ name2[rnd.nextInt(name2.length)]
						+ name2[rnd.nextInt(name2.length)],
						String.format("010-%d-%d", rnd.nextInt(9000)+1000, rnd.nextInt(9000)+1000),
						String.format("%d%d", rnd.nextInt(2)+1, rnd.nextInt(900000)+100000)
									);
		
		System.out.println(data);
		
	}
		
		
		
		
	}

	private static void apply() {
		// TODO Auto-generated method stub
		
		Random rnd = new Random();
	
		String[] name1 = { "김", "이", "박", "정", "최", "손", "유", "홍", "채", "우", "현" };
		String[] name2 = { "우", "찬", "서", "유", "빈", "지", "신", "석", "효", "정", "섭", "현", "진", "재", "형", "민", "성", "림",
				"나", "연", "영" };
		
		String[] gender = {"남자", "여자"};
		String[] major = {"전공", "비전공", "관련전공"};
		
		String[] home = {"서울", "수원", "천안", "인천", "성남", "하남", "제주", "안성", "평택", "광주", "파주", "오산", "화성", "안산", "시흥", "동두천", "포천", "화천", "춘천"};
					
		// seq, 이름, 전화번호, 성별, 생년월일, 전공, 거주지
		
		for(int i=1; i<=100 ; i++) {
		String data = String.format("insert into tblApply values(%d, '%s', '%s', '%s', '%s', '%s', '%s');",
						i,									
						name1[rnd.nextInt(name1.length)]   
						+ name2[rnd.nextInt(name2.length)]
						+ name2[rnd.nextInt(name2.length)],
						String.format("010-%d-%d", rnd.nextInt(9000)+1000, rnd.nextInt(9000)+1000),
						gender[rnd.nextInt(gender.length)],
						String.format("9%d%02d%02d", rnd.nextInt(10), rnd.nextInt(12)+1, rnd.nextInt(28)+1),
						major[rnd.nextInt(major.length)],
						home[rnd.nextInt(home.length)]
									);
		
		System.out.println(data);
		
	}
}

	private static void comment() throws Exception {
		
		// 5.댓글
		// 댓글번호,게시물번호,댓글내용,작성자ID
		
		Random rnd = new Random();
		
		BufferedReader reader = new BufferedReader(new FileReader(".\\dat\\member.txt"));
		FileWriter writer = new FileWriter(".\\dat\\comments.txt");
		
		String[] comments = {"좋아요", "유익한 내용이네요", "잘 보고 갑니다", "우와 정말 사고 싶어요", "너무 예쁘네요", "최고예요", "장바구니각", "귀여워요", "알잘딱깔센"};
		
		int commentIndex = 1;
		
		String[] id = new String[100];
		
		int index = 0;
		
		String line = null;
		
		while ((line = reader.readLine()) != null) {
			
			String[] temp = line.split(",");
			
			id[index] = temp[0];
			
			index++;
		}
		
		for (int i=0; i<100; i++) {
			
			String data = String.format("%d,%d,%s,%s"
					, commentIndex
					, rnd.nextInt(50) + 1
					, comments[rnd.nextInt(comments.length)]
					, id[rnd.nextInt(id.length)]);

			commentIndex++;
			writer.write(data + "\r\n");
			System.out.println(data);
			
		}
		
		writer.close();

	}

	private static void buyList(String id) throws Exception {

		//10.구매내역
		//구매자아이디,상품코드,수량,쇼핑몰이름
		Random rnd = new Random();
		
		BufferedReader readId = new BufferedReader(new FileReader(".\\dat\\member.txt"));
		BufferedReader readItemCode = new BufferedReader(new FileReader(".\\dat\\item.txt"));
		BufferedReader readShop = new BufferedReader(new FileReader(".\\dat\\shopMember.txt"));
		
		FileWriter writer = new FileWriter(".\\dat\\buyList.txt");
		
		String line = null;
		
		String[] idList = new String[100];
		
		int index = 0;
		
		while ((line = readId.readLine()) != null) {
			
			String[] temp = line.split(",");
			
			idList[index] = temp[0];
			
			index++;
		}
		
		index = 0;
		
		String[] itemCodeList = new String[300];
		
		while ((line = readItemCode.readLine()) != null) {
			
			String[] temp = line.split(",");
			
			itemCodeList[index] = temp[0];
			
			index++;
		}
		
		
		index = 0;
		String[] shopList = new String[30];
		
		while ((line = readShop.readLine()) != null) {
			
			String[] temp = line.split(",");
			
			shopList[index] = temp[2];
			index++;
			 
		}
		
		for (int i=0; i<100; i++) {
			
		//구매자아이디,상품코드,수량,쇼핑몰이름
		String data = String.format("%s,%s,%d,%s"
									, idList[rnd.nextInt(idList.length)]
									, itemCodeList[rnd.nextInt(itemCodeList.length)]
									, rnd.nextInt(5) + 1
									, shopList[rnd.nextInt(shopList.length)]);
		
		System.out.println(data);
		
		writer.write(data + "\r\n");
		
		}
		writer.close();
		
	}

	private static void postItem() throws Exception {

		// 4.게시물
		// 게시물번호,게시물내용,좋아요수,게시자ID,상품태그,스타일태그,작성날짜
		
		ArrayList<String> buyItemCode = new ArrayList<String>();
		
		Random rnd = new Random();
		int postCode = 1;
		
		String[] contents1 = { "가을 운동을 효과적으로 돕는 아우터 열 가지.\t", "운동할 때 찬 기운을 막기 위해 선택하는 아이템 아우터.\t", "울마크 컴퍼니의 원사로 만든 니트를  입고 소비하는 이들과 이야기를 나눴다.\t", "수채화처럼 맑고 투명하게 물든 뷰티 룩.\t" , "새로운 시작 새로운 스타일.\t" };
		String[] contents2 = { "개강 시즌이 돌아왔다!\t", "좀 더 즐겁고 활기찬 캠퍼스 생활을 북돋아 줄 ‘힙’한 스타일을 준비했다\t", "기분 좋은 설렘으로 가득한 9월.\t", "그 시작을 함께할 경쾌한 무드의 룩을 제안한다.\t", "간편하면서 멋스러운 코디 어디 없을까?\t", "고민스러울 땐 내셔널지오그래픽의 트레이닝 셋업이 정답이다.\t", "다양한 컬러에 소매에 자리한 탈부착 로고 와펜이 멋스러운 모습이다.\t", "여기에 부드러운 촉감의 원단과 밴딩 팬츠로 편안함까지 갖추었으니 두말할 것도 없다.\t", "방수와 발수 방풍 그리고 투습 기능까지 갖춘 재킷.\t", "살갗을 파고들던 뜨거운 볕이 잠잠해졌다.\t", "서늘한 바람이 기분 좋게 불어오는 9월엔 한풀 차분한 옷들을 꺼내 보자.\t", "여기에 스타일까지 톡톡히 챙긴다면 그야말로 금상첨화 아닌가?\t", "꾸민 듯 안 꾸민 듯한 스타일링을 보여주며 일상에서 캐주얼하지만 충분히 스타일리시한 존재감을 완성해주는 아이템을 제안한다.\t", "생활 방수 기능까지 갖춰 실용성을 더했다.\t", "유 있는 핏으로 완성해 두꺼운 이너 아이템을 함께 매치해도 편하게 입을 수 있다.\t" };
		
		String[] style = { "미니멀", "아메카지", "시티보이", "캐주얼", "스트릿", "하이틴", "로맨틱", "걸리쉬", "스포티" };
		
		BufferedReader read = new BufferedReader(new FileReader(".\\dat\\member.txt"));
		FileWriter writer = new FileWriter(".\\dat\\post.txt");
		
		String line = null;
		
		String[] idList = new String[100];
		
		int index = 0;
		
		while ((line = read.readLine()) != null) {
			
			String[] temp = line.split(",");
			
			idList[index] = temp[0];
			
			index++;
			
		}
		
//		ArrayList<BuyHistory> buyHistory = new ArrayList<BuyHistory>();
//		
//		for (String id : idList) {
//			
//			buyHistory = MemberService.getBuyList(id);
//
//		}
		
		for (int i=0; i<50; i++) {
			
			String id = idList[rnd.nextInt(idList.length)];
			
			ArrayList<BuyHistory> buyHistory = new ArrayList<BuyHistory>();
			
			buyHistory = MemberService.getBuyList(id);
			
			int itemCode;
			
			if (buyHistory.size() != 0) {
				
				itemCode = buyHistory.get(rnd.nextInt(buyHistory.size())).getItemCode();
				
			} else {
				
				itemCode = 0;
				
			}
				

			// 게시물번호,게시물내용,좋아요수,게시자ID,상품태그,스타일태그
			String data = String.format("%d,%s,%d,%s,%d,%s"
										, postCode
										, contents1[rnd.nextInt(contents1.length)] + contents2[rnd.nextInt(contents2.length)] + contents2[rnd.nextInt(contents2.length)]
										, rnd.nextInt(101)
										, id
										, itemCode
										, style[rnd.nextInt(style.length)]);
			
			
			postCode++;
			
			writer.write(data + "\r\n");
			System.out.println(data);
	
		}

		writer.close();
		
	}

	private static void item() throws Exception {

		// 3.상품
		// 상품코드,상품이름,사이즈(S,M,L),수량,가격,판매량,카테고리,스타일,판매쇼핑몰
		
		Random rnd = new Random();
		int itemCode = 1; //상품코드
		
		String[] itemName1 = { "뉴욕", "파리", "도쿄", "켈리포니아", "하와이", "벤쿠버", "프라하", "방콕", "비엔나", "할리우드", "시드니", "영국", "런던", "서울", "LA", "시카고" };
		String[] itemName2 = { "배색", "스트라이프", "라운드", "스트릿", "코튼", "레더", "셔링", "스티치", "트위드", "데님", "플라워", "시스루", "노카라", "카라", "코듀로이" };
		String[] topItem = { "티셔츠", "블라우스", "셔츠"};
		String[] outerItem = { "가디건", "자켓", "코트" };
		String[] pantsItem = { "일자바지", "슬랙스팬츠", "반바지" };
		String[] skirtItem = { "미니스커트", "미디스커트", "롱스커트" };
		String[] shoesItem = { "운동화", "구두", "슬리퍼" };
		String[] accItem = { "모자", "시계", "선글라스" };
		
		String[] size = { "S", "M", "L" };
		String[] style = { "미니멀", "아메카지", "시티보이", "캐주얼", "스트릿", "하이틴", "로맨틱", "걸리쉬", "스포티" };
		
		FileWriter writer = new FileWriter(".\\dat\\item.txt");
		BufferedReader read = new BufferedReader(new FileReader(".\\dat\\shopMember.txt"));
		
		String line = null;
		String[] shop = new String[30];
		int index = 0;
		
		while ((line = read.readLine()) != null) {
			
			String[] temp = line.split(",");
			
			shop[index] = temp[2];
			index++;
			 
		}
		
		for (int i=0; i<50; i++) {
			
			// 상품코드,상품이름,사이즈(S,M,L),수량,가격,판매량,카테고리,스타일,판매쇼핑몰
			String data = String.format("%d,%s,%s,%d,%d,%d,%s,%s,%s"
											, itemCode
											, itemName1[rnd.nextInt(itemName1.length)] + " " + itemName2[rnd.nextInt(itemName2.length)] + " " + topItem[rnd.nextInt(topItem.length)]
											, size[rnd.nextInt(size.length)]
											, rnd.nextInt(91) + 10
											, (rnd.nextInt(499) + 1)* 1000
											, rnd.nextInt(101)
											, "상의"
											, style[rnd.nextInt(style.length)]
											, shop[rnd.nextInt(shop.length)]);
			itemCode++;
			writer.write(data + "\r\n");
			System.out.println(data);
		}
		
		for (int i=0; i<50; i++) {
			
			// 상품코드,상품이름,사이즈(S,M,L),수량,가격,판매량,카테고리,스타일,판매쇼핑몰
			String data = String.format("%d,%s,%s,%d,%d,%d,%s,%s,%s"
											, itemCode
											, itemName1[rnd.nextInt(itemName1.length)] + " " + itemName2[rnd.nextInt(itemName2.length)] + " " + pantsItem[rnd.nextInt(pantsItem.length)]
											, size[rnd.nextInt(size.length)]
											, rnd.nextInt(91) + 10
											, (rnd.nextInt(499) + 1)* 1000
											, rnd.nextInt(101)
											, "하의"
											, style[rnd.nextInt(style.length)]
											, shop[rnd.nextInt(shop.length)]);
			itemCode++;
			
			writer.write(data + "\r\n");
			System.out.println(data);
		}
		
		for (int i=0; i<50; i++) {
			
			// 상품코드,상품이름,사이즈(S,M,L),수량,가격,판매량,카테고리,스타일,판매쇼핑몰
			String data = String.format("%d,%s,%s,%d,%d,%d,%s,%s,%s"
											, itemCode
											, itemName1[rnd.nextInt(itemName1.length)] + " " + itemName2[rnd.nextInt(itemName2.length)] + " " + shoesItem[rnd.nextInt(shoesItem.length)]
											, size[rnd.nextInt(size.length)]
											, rnd.nextInt(91) + 10
											, (rnd.nextInt(499) + 1)* 1000
											, rnd.nextInt(101)
											, "신발"
											, style[rnd.nextInt(style.length)]
											, shop[rnd.nextInt(shop.length)]);
			itemCode++;
			
			writer.write(data + "\r\n");
			System.out.println(data);
		}
		
		for (int i=0; i<50; i++) {
			
			// 상품코드,상품이름,사이즈(S,M,L),수량,가격,판매량,카테고리,스타일,판매쇼핑몰
			String data = String.format("%d,%s,%s,%d,%d,%d,%s,%s,%s"
											, itemCode
											, itemName1[rnd.nextInt(itemName1.length)] + " " + itemName2[rnd.nextInt(itemName2.length)] + " " + outerItem[rnd.nextInt(outerItem.length)]
											, size[rnd.nextInt(size.length)]
											, rnd.nextInt(91) + 10
											, (rnd.nextInt(499) + 1)* 1000
											, rnd.nextInt(101)
											, "아우터"
											, style[rnd.nextInt(style.length)]
											, shop[rnd.nextInt(shop.length)]);
			itemCode++;
			
			writer.write(data + "\r\n");
			System.out.println(data);
		}
		
		for (int i=0; i<50; i++) {
			
			// 상품코드,상품이름,사이즈(S,M,L),수량,가격,판매량,카테고리,스타일,판매쇼핑몰
			String data = String.format("%d,%s,%s,%d,%d,%d,%s,%s,%s"
											, itemCode
											, itemName1[rnd.nextInt(itemName1.length)] + " " + itemName2[rnd.nextInt(itemName2.length)] + " " + skirtItem[rnd.nextInt(skirtItem.length)]
											, size[rnd.nextInt(size.length)]
											, rnd.nextInt(91) + 10
											, (rnd.nextInt(499) + 1)* 1000
											, rnd.nextInt(101)
											, "스커트"
											, style[rnd.nextInt(style.length)]
											, shop[rnd.nextInt(shop.length)]);
			itemCode++;
			
			writer.write(data + "\r\n");
			System.out.println(data);
		}
		
		for (int i=0; i<50; i++) {
			
			// 상품코드,상품이름,사이즈(S,M,L),수량,가격,판매량,카테고리,스타일,판매쇼핑몰
			String data = String.format("%d,%s,%s,%d,%d,%d,%s,%s,%s"
											, itemCode
											, itemName1[rnd.nextInt(itemName1.length)] + " " + itemName2[rnd.nextInt(itemName2.length)] + " " + accItem[rnd.nextInt(accItem.length)]
											, size[rnd.nextInt(size.length)]
											, rnd.nextInt(91) + 10
											, (rnd.nextInt(499) + 1)* 1000
											, rnd.nextInt(101)
											, "악세사리"
											, style[rnd.nextInt(style.length)]
											, shop[rnd.nextInt(shop.length)]);
			itemCode++;
			
			writer.write(data + "\r\n");
			System.out.println(data);
		}
		writer.close();
		
	}

	private static void shopMember() throws Exception {

		// 2.쇼핑몰
		// 아이디,비밀번호,쇼핑몰이름,사업자번호,고객센터번호,스타일1,스타일2,주소,대표자명,패널티누적수
		
		Random rnd = new Random();
		
		String[] style = { "미니멀", "아메카지", "시티보이", "캐주얼", "스트릿", "하이틴", "로맨틱", "걸리쉬", "스포티" };
		
		String[] name1 = { "김", "이", "박", "정", "최", "손", "유", "홍", "채", "우", "현" };
		String[] name2 = { "우", "찬", "서", "유", "빈", "지", "신", "석", "효", "정", "섭", "현", "진", "재", "형", "민", "성", "림",
				"나", "연", "영" };
		
		String[] address1 = { "강남구", "동작구", "관악구", "광진구", "송파구", "강동구" };
		String[] address2 = { "대치동", "역삼동", "세곡동", "도곡동", "개포동", "송파동", "화양동", "오금동", "삼성동", "뉴욕동", "청담동", "도쿄동" };
		
		String[] shopName = { "가온길", "고운", "그린나래", "꼬리별", "그루잠", "나르샤", "난이", "누리봄", "늘품", "느루", "다소니", "다온", "다원" ,"달보드레" ,"든해", "라라", "라미", "루리", "라온제나", "라온하제", "모아", "마파람","맛조이", "미리내", "미투리", "미르", "바론", "별하", "벼리", "보미" };

		FileWriter writer = new FileWriter(".\\dat\\shopMember.txt");
		
       
		
		for (int i=0; i<30; i++) {
			
			//아이디
			char id1 = (char) ((int) (Math.random() * 26) + 97);
			int num = (int) (Math.random() * 4);

			String id = "";
			id += id1;
			for (int j = 0; j < 2 + num; j++) {
				id += (char) ((int) (Math.random() * 26) + 97);
			}

			id += (int) (Math.random() * 9);
			id += (int) (Math.random() * 9);

			
			//비밀번호
			char pw1 = (char) ((int) (Math.random() * 26) + 97); // 소문자
			char pw2 = (char) ((int) (Math.random() * 26) + 65); // 대문자
			num = (int) (Math.random() * 4);

			String pw = "";
			pw += pw1;
			for (int j = 0; j < 2 + num; j++) {
				if (num % 2 == 0) {
					pw += (int) (Math.random() * 9);
				}
				if ((j + 1) % 2 == 0) {
					pw += (char) ((int) (Math.random() * 26) + 65);
				} else
					pw += (char) ((int) (Math.random() * 26) + 97);

			}
			pw += (int) (Math.random() * 9);

			// 아이디,비밀번호,쇼핑몰이름,사업자번호,고객센터번호,스타일1,스타일2,주소,대표자명,패널티누적수
			String data = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%d"
										, id
										, pw
										, String.format("%s%s"
															, shopName[i]
															, shopName[rnd.nextInt(shopName.length)])
										, String.format("%d%02d%04d" //사업자번호
															, rnd.nextInt(521) + 100
															, rnd.nextInt(85) + 1
															, rnd.nextInt(9999) + 1)
										, String.format("010%d%d" //연락처
															, rnd.nextInt(9000) + 1000
															, rnd.nextInt(9000) + 1000)
										, String.format("%s", style[rnd.nextInt(style.length)]) //스타일1
										, String.format("%s", style[rnd.nextInt(style.length)]) //스타일2
										, String.format("서울시 %s %s %d번지" //주소
														, address1[rnd.nextInt(address1.length)]
														, address2[rnd.nextInt(address2.length)]
														, rnd.nextInt(500) + 100)
										, name1[rnd.nextInt(name1.length)] // 대표자명
													+ name2[rnd.nextInt(name2.length)]
													+ name2[rnd.nextInt(name2.length)]
										, rnd.nextInt(3));
			
			System.out.println(data);
			
			writer.write(data + "\r\n");

		}
		writer.close();
	}

	private static void member() throws Exception {

		// 1.회원
		// 아이디,비밀번호,이름,성별,생년월일,전화번호,주소,패널티누적수

		Random rnd = new Random();

		String[] name1 = { "김", "이", "박", "정", "최", "손", "유", "홍" };
		String[] name2 = { "우", "찬", "서", "유", "빈", "지", "신", "석", "효", "정", "섭", "현", "진", "재", "형", "민", "성", "림",
				"나", "연", "영" };

		String[] address1 = { "강남구", "동작구", "관악구", "광진구", "송파구", "강동구" };
		String[] address2 = { "대치동", "역삼동", "세곡동", "도곡동", "개포동", "송파동", "화양동", "오금동", "삼성동", "뉴욕동", "청담동", "도쿄동" };

		
		FileWriter writer = new FileWriter(".\\dat\\member.txt");

		
		for (int i = 1; i <= 100; i++) {

			//아이디
			char id1 = (char) ((int) (Math.random() * 26) + 97);
			int num = (int) (Math.random() * 4);

			String id = "";
			id += id1;
			for (int j = 0; j < 2 + num; j++) {
				id += (char) ((int) (Math.random() * 26) + 97);
			}

			id += (int) (Math.random() * 9);
			id += (int) (Math.random() * 9);

			
			//비밀번호
			char pw1 = (char) ((int) (Math.random() * 26) + 97); // 소문자
			char pw2 = (char) ((int) (Math.random() * 26) + 65); // 대문자
			num = (int) (Math.random() * 4);

			String pw = "";
			pw += pw1;
			for (int j = 0; j < 2 + num; j++) {
				if (num % 2 == 0) {
					pw += (int) (Math.random() * 9);
				}
				if ((j + 1) % 2 == 0) {
					pw += (char) ((int) (Math.random() * 26) + 65);
				} else
					pw += (char) ((int) (Math.random() * 26) + 97);

			}
			pw += (int) (Math.random() * 9);

			// 아이디,비밀번호,이름,성별,생년월일,전화번호,주소,패널티누적수
			String data = String.format("%s,%s,%s,%d,%s,%s,%s,%d"
					
					, id
					, pw
					, name1[rnd.nextInt(name1.length)] // 이름
							+ name2[rnd.nextInt(name2.length)]
							+ name2[rnd.nextInt(name2.length)]
					, rnd.nextInt(3) + 1 // 성별(1.남자 2.여자 3.선택안함)
					, String.format("%d%02d%02d", rnd.nextInt(73)+1950, rnd.nextInt(12)+1, rnd.nextInt(28)+1)
					, String.format("010%d%d" //연락처
													, rnd.nextInt(9000) + 1000
													, rnd.nextInt(9000) + 1000)
					, String.format("서울시 %s %s %d번지" //주소
									, address1[rnd.nextInt(address1.length)]
									, address2[rnd.nextInt(address2.length)]
									, rnd.nextInt(100) + 1)
					, rnd.nextInt(3));
					
			
			System.out.println(data);

			// 파일 기록
			writer.write(data + "\r\n");

		}
		writer.close();

	}

}
