package com.test.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.test.buyHistory.BuyHistory;
import com.test.cart.Basket;
import com.test.cart.CartService;
import com.test.cart.WishList;
import com.test.fashion.MainClass;
import com.test.item.Item;
import com.test.member.MemberInfo;
import com.test.member.MemberService;
import com.test.posting.Comments;
import com.test.posting.Post;
import com.test.shop.ShopMember;

public class Data {
	
	private final static String BUYLIST;
	private final static String COMMENTS;
	private final static String ITEM;
	private final static String MEMBER;
	private final static String POST;
	private final static String SHOPMEMBER;
	private final static String BASKET;
	private final static String WISHLIST;
	
	public static ArrayList<BuyHistory> buyHistoryList;
	public static ArrayList<Comments> commentsList;
	public static ArrayList<Item> itemList;
	public static ArrayList<MemberInfo> memberInfoList;
	public static ArrayList<Post> postList;
	public static ArrayList<ShopMember> shopMemberList;
	public static ArrayList<Basket> basketList;
	public static ArrayList<WishList> wishList;
	
	static {
		
		BUYLIST = ".\\dat\\buyList.txt";
		COMMENTS = ".\\dat\\comments.txt";
		ITEM = ".\\dat\\item.txt";
		MEMBER = ".\\dat\\member.txt";
		POST = ".\\dat\\post.txt";
		SHOPMEMBER = ".\\dat\\shopMember.txt";
		BASKET = ".\\dat\\basket.txt";
		WISHLIST = ".\\dat\\wishList.txt";
		
		buyHistoryList = new ArrayList<BuyHistory>();
		commentsList = new ArrayList<Comments>();
		itemList = new ArrayList<Item>();
		memberInfoList = new ArrayList<MemberInfo>();
		postList = new ArrayList<Post>();
		shopMemberList = new ArrayList<ShopMember>();
		basketList = new ArrayList<Basket>();
		wishList = new ArrayList<WishList>();

	}
	
	public static void load() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(BUYLIST));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				//구매자아이디,상품코드,수량,쇼핑몰이름
				//String id, int itemCode, int itemCount, String shopName
				BuyHistory buyHistory = new BuyHistory(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), temp[3]);
				
				buyHistoryList.add(buyHistory);
				
			}
			
			reader.close();
			
			reader = new BufferedReader(new FileReader(WISHLIST));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				

				WishList wish = new WishList();

				//3,uhyfss18,125,490000,느루벼리
				wish.setLikeNum(Integer.parseInt(temp[0]));
				wish.setLikeId(temp[1]);
				wish.setLikeItemCode(Integer.parseInt(temp[2]));
				wish.setLikeItemPrice(Integer.parseInt(temp[3]));
				wish.setLikeShopName(temp[4]);
				
				wishList.add(wish);
				
			}
			
			reader.close();
			
			reader = new BufferedReader(new FileReader(BASKET));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				

				Basket basket = new Basket();

				basket.setBasketNum(Integer.parseInt(temp[0]));
				basket.setBasketId(temp[1]);
				basket.setBasketItemCode(Integer.parseInt(temp[2]));
				basket.setBasketItemCount(Integer.parseInt(temp[3]));
				basket.setBasketItemPrice(Integer.parseInt(temp[4]));
				basket.setBasketShopName(temp[5]);
				
				basketList.add(basket);
				
			}
			
			reader.close();
			
			
			reader = new BufferedReader(new FileReader(COMMENTS));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				// 댓글번호,게시물번호,댓글내용,작성자ID
				//String commentIndex, String postIndex, String comment, String id
				Comments comments = new Comments(temp[0], temp[1], temp[2], temp[3]);
				
				commentsList.add(comments);
				
			}
			
			reader.close();
			
			
			reader = new BufferedReader(new FileReader(ITEM));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				// 상품코드,상품이름,사이즈(S,M,L),수량,가격,판매량,카테고리,스타일,판매쇼핑몰
				//int itemCode, String itemName, String size, int itemCount, int price, int sellCount, String category, String style, String shopName
				
				Item item = new Item(Integer.parseInt(temp[0]), temp[1], temp[2], Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), temp[6], temp[7], temp[8]);
				
				itemList.add(item);
				
			}
			
			reader.close();
			
			
			reader = new BufferedReader(new FileReader(MEMBER));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				// 아이디,비밀번호,이름,성별,생년월일,전화번호,주소,패널티누적수
				//String id, String password, String name, int gender, String birth, String tel, String address, int memberPenalty
				MemberInfo member = new MemberInfo(temp[0], temp[1], temp[2], Integer.parseInt(temp[3]), temp[4], temp[5], temp[6], Integer.parseInt(temp[7]));
				
				memberInfoList.add(member);
				
			}
			
			reader.close();
			
			
			reader = new BufferedReader(new FileReader(POST));

			line = null;

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				// 게시물번호,게시물내용,좋아요수,게시자ID,상품태그,스타일태그
				// int postIndex, String postContents, int like, String id, int itemCode, String style
				Post post = new Post();

				post.setPostIndex(temp[0]);
				post.setPostContents(temp[1]);
				post.setLike(Integer.parseInt(temp[2]));
				post.setId(temp[3]);
				post.setItemCode(Integer.parseInt(temp[4]));
				post.setStyle(temp[5]);

				postList.add(post);

			}

			reader.close();
			
			
			reader = new BufferedReader(new FileReader(SHOPMEMBER));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				//String id, String password, String shopName, String businessNumber, String shopTel, String style1, String style2, String shopAddress, String ceoName, int shopPenalty
				ShopMember shopMember = new ShopMember(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], Integer.parseInt(temp[9]));
				
				shopMemberList.add(shopMember);
				
			}
			
			reader.close();	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void update() {
		
		try {
			
			FileWriter writer = new FileWriter(BUYLIST);
			
			for (BuyHistory buyHistory : buyHistoryList) {
				
				//String id, int itemCode, int itemCount, String shopName
				String data = String.format("%s,%d,%d,%s"
						, buyHistory.getId()
						, buyHistory.getItemCode()
						, buyHistory.getItemCount()
						, buyHistory.getShopName());
				
				writer.write(data + "\r\n");

			}
			
			writer.close();
			
			writer = new FileWriter(WISHLIST);
			
			for (WishList wish : wishList) {
				
				//4,idn86,291,381000,마파람라온제나
				String data = String.format("%d,%s,%d,%d,%s"
						, wish.getLikeNum()
						, wish.getLikeId()
						, wish.getLikeItemCode()
						, wish.getLikeItemPrice()
						, wish.getLikeShopName());
				
				writer.write(data + "\r\n");

			}
			
			writer.close();

			writer = new FileWriter(BASKET);
			
			for (Basket basket : basketList) {
				
				//9,xliv18,267,8,28000,느루벼리
				String data = String.format("%d,%s,%d,%d,%d,%s"
						, basket.getBasketNum()
						, basket.getBasketId()
						, basket.getBasketItemCode()
						, basket.getBasketItemCount()
						, basket.getBasketItemPrice()
						, basket.getBasketShopName());
				
				writer.write(data + "\r\n");

			}
			
			writer.close();
			
			
			writer = new FileWriter(COMMENTS);
			
			for (Comments comments : commentsList) {
				
				//int commentIndex, String postIndex, String comment, String id
				String data = String.format("%s,%s,%s,%s"
						, comments.getCommentIndex()
						, comments.getPostIndex()
						, comments.getComment()
						, comments.getId());
				
				writer.write(data + "\r\n");

			}
			
			writer.close();
			
			
			writer = new FileWriter(ITEM);
			
			for (Item item : itemList) {
				
				//int itemCode, String itemName, String size, int itemCount, int price, int sellCount, String category, String style, String shopName
				String data = String.format("%d,%s,%s,%d,%d,%d,%s,%s,%s"
						, item.getItemCode()
						, item.getItemName()
						, item.getSize()
						, item.getItemCount()
						, item.getPrice()
						, item.getSellCount()
						, item.getCategory()
						, item.getStyle()
						, item.getShopName());
				
				writer.write(data + "\r\n");

			}
			
			writer.close();
			
			
			writer = new FileWriter(MEMBER);
			
			for (MemberInfo member : memberInfoList) {
				
				//String id, String password, String name, int gender, String birth, String tel, String address, int memberPenalty
				String data = String.format("%s,%s,%s,%d,%s,%s,%s,%d"
						, member.getId()
						, member.getPassword()
						, member.getName()
						, member.getGender()
						, member.getBirth()
						, member.getTel()
						, member.getAddress()
						, member.getMemberPenalty());
				
				writer.write(data + "\r\n");

			}
			
			writer.close();
			
			
			writer = new FileWriter(POST);
			
			for (Post post : postList) {
				
				//int postIndex, String postContents, int like, String id, int itemCode, String style
				String data = String.format("%s,%s,%d,%s,%d,%s"
						, post.getPostIndex()
						, post.getPostContents()
						, post.getLike()
						, post.getId()
						, post.getItemCode()
						, post.getStyle());
				
				writer.write(data + "\r\n");

			}
			
			writer.close();
			
			
			writer = new FileWriter(SHOPMEMBER);
			
			for (ShopMember shopMember : shopMemberList) {
				
				//String id, String password, String shopName, String businessNumber, String shopTel, String style1,
				//String style2, String shopAddress, String ceoName, int shopPenalty
				String data = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%d"
						, shopMember.getId()
						, shopMember.getPassword()
						, shopMember.getShopName()
						, shopMember.getBusinessNumber()
						, shopMember.getShopTel()
						, shopMember.getStyle1()
						, shopMember.getStyle2()
						, shopMember.getShopAddress()
						, shopMember.getCeoName()
						, shopMember.getShopPenalty());
				
				writer.write(data + "\r\n");

			}
			
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static String ShopName(String shopId) {
		
		for (ShopMember shopmember : shopMemberList) {
			if (shopmember.getId().equals(shopId)) {
				
				return shopmember.getShopName();
			}
		}
		return null;
		
	}
	
	public static String memberName(String memberId) {
		
		for (MemberInfo member : memberInfoList) {
			if (member.getId().equals(memberId)) {
				
				return member.getName();
			}
		}
		return null;
		
	}
	
	public static int createSeq() {
		
		return (itemList.get(itemList.size() - 1).getItemCode()) + 1;
		
	}
	public static ArrayList<WishList> searchWish(String id){
		ArrayList<WishList> wlist = new ArrayList<WishList>();
		
		for (WishList wish : wishList) {
			
			if(wish.getLikeId().equals(id)) {
				wlist.add(wish);
			}	
		}
		
		return wlist;
		
	}
	public static ArrayList<Basket> searchBasket(String id){
		
		ArrayList<Basket> cartList = new ArrayList<Basket>();
		
		for(Basket basket : basketList) {
			
			if(basket.getBasketId().equals(id)) {
				cartList.add(basket);
			}
		}
		
		return cartList;
		
	}
	

	public static ArrayList<Item> searchStyle(String word) {

		ArrayList<Item> stylelist = new ArrayList<Item>();
		
		for (Item item : itemList) {
			
			if (item.getStyle().contains(word) || item.getStyle().equals(word)) {
				
				stylelist.add(item);
			}
		}
		return stylelist;
		
	}
	
	public static ArrayList<Item> searchItem(String word) {

		ArrayList<Item> itemlist = new ArrayList<Item>();
		
		for (Item i : itemList) {
			
			if (i.getItemName().contains(word)) {
				
				itemlist.add(i);
			}
		}
		
		return itemlist;
		
	}
	
	public static ArrayList<Item> searchItem(int itemCode) {

		ArrayList<Item> itemlist = new ArrayList<Item>();
		
		for (Item i : itemList) {
			
			if (i.getItemCode() == itemCode) {
				
				itemlist.add(i);
			}
		}
		
		return itemlist;
		
	}
	
	public static ArrayList<Item> searchShopItemName(String word, String shopName) {

		ArrayList<Item> itemlist = new ArrayList<Item>();
		
		for (Item i : itemList) {
			
			if (i.getShopName().equals(shopName)) {
				if (i.getItemName().contains(word)) {
					
					itemlist.add(i);
				}
			}
		}
		
		return itemlist;
		
	}
	
	public static ArrayList<Item> searchShopItemCode(int code, String shopName) {

		ArrayList<Item> itemlist = new ArrayList<Item>();
		
		for (Item i : itemList) {
			
			if (i.getShopName().equals(shopName)) {
				if (i.getItemCode() == code) {
					
					itemlist.add(i);
				}
			}
		}
		
		return itemlist;
		
	}
	
	
	public static boolean deleteItem(int code) {
		
		for (Item item : itemList) {
			
			if (item.getItemCode() == code) {
				
				return itemList.remove(item);
			}
		}
		
		return false;
	}
	
	
	public static Item getItem(int code) {
		
		for (Item item : itemList) {
			
			if (item.getItemCode() == code) {
				
				return item;
			}
			
		}
		
		return null;
}

	public static BuyHistory getItemCode(String id) {

		for (BuyHistory buy : buyHistoryList) {

			if (buy.getId().equals(id)) {

				return buy;
			}

		}

		return null;

	}
	

	public static String getItemName(int itemCode) {

		for (Item item : itemList) {
			
			if(item.getItemCode() == itemCode) {				
				String itemName = item.getItemName(itemCode);
				
				return itemName;
			}
		}
			
		return null;
	}
	
	public static int getBasketItemCode(int itemNum) {
		
		for(Basket basket : basketList) {
			
			if(basket.getBasketNum() == itemNum) {
				return basket.getBasketItemCode();
			}
		}
		
		return 0;
	}
	
	public static int getWishListItemCode(int itemNum) {
		
		for(WishList wish : wishList) {
			
			if(wish.getLikeNum() == itemNum) {
				return wish.getLikeItemCode();
			}
		}
		
		return 0;
	}
	public static WishList getWishList(String id) {
		
		for (WishList wish : wishList) {
			
			if (wish.getLikeId().equals(id)) {
				return wish;
			}
		}
		
		return null;
	}
	
	
	public static Basket getBasketItemCode(String id) {
		
		for (Basket basket : basketList) {
			
			if (basket.getBasketId().equals(id)) {
				return basket;
			}
		}
		return null;
	}

	public static Item getItemStyle(int itemCode) {

		for (Item item : itemList) {
			
			if (item.getItemCode() == itemCode) {
				
				return item;
			}
		}
		
		return null;
		
	}	
	public static Post getPost(String postIndex) {

		for (Post post : postList) {

			if (post.getPostIndex().equals(postIndex)) {

				return post;
			}
		}
		return null;
	}

	public static String createPostIndex() {

		// post.txt > 가장 번호가 큰 학생의 번호
		int max = 0;

		for (Post post : postList) {

			if (Integer.parseInt(post.getPostIndex()) > max) {

				max = Integer.parseInt(post.getPostIndex());
			}
		}

		return max + 1 + "";
	}
	
	public static int createBasketIndex() {
		
		int max = 0;
		
		for (Basket basket : basketList) {
			
			if (basket.getBasketNum() > max) {
				max = basket.getBasketNum();
			}
		}
		return max + 1;
	}
	
	public static int createWishIndex() {
		
		int max = 0;
		
		for (WishList wish : wishList) {
			
			if (wish.getLikeNum() > max) {
				max = wish.getLikeNum();
			}
		}
		return max + 1;
	}

	public static ArrayList<Post> searchPost(String style) {

		ArrayList<Post> plist = new ArrayList<Post>();

		for (Post post : postList) {

			if (post.getStyle().contains(style)) {

				plist.add(post);
			}
		}

		return plist;

	}

	public static boolean deletePost(String postIndex) {

		String pIndex = getPostIndex(postIndex);

		for (Post post : postList) {

			if (post.getPostIndex().equals(pIndex)) {

				postList.remove(post);

				return true;
			}
		}
		return false;
	}

	private static String getPostIndex(String postIndex) {

		for (Post post : postList) {

			if (post.getPostIndex().equals(postIndex)) {

				return post.getPostIndex();
			}
		}

		return null;

	}

	public static boolean deleteComment(String commentIndex) {
		
		String cIndex = getCommentIndex(commentIndex);

		for (Comments comment : commentsList) {

			if (comment.getCommentIndex().equals(cIndex)) {

				postList.remove(comment);

				return true;
			}
		}
		
		return false;
	}

	private static String getCommentIndex(String commentIndex) {
		
		for (Comments comment : commentsList) {

			if (comment.getCommentIndex().equals(commentIndex)) {

				return comment.getCommentIndex();
			}
		}
		return null;
	}

	public static boolean basketPurchase(int itemCode) {
	
		for (Basket basket : basketList) {
			if(basket.getBasketItemCode() == itemCode) {
				return true;
			}
		}
		
		return false;
	}
	
	public static int getBasketIndex(int basketIndex) {
		
		for (Basket basket : basketList) {			
			if(basket.getBasketNum() == basketIndex) {
				return basketIndex;
			}
		}
		return 0;
		
	}
	
	public static boolean deleteBasket(int itemCode) {

		for (Basket basket : basketList) {
			
			if(basket.getBasketItemCode() == itemCode) {
				
				basketList.remove(basket);
				Data.update();
				return true;
			}
		}
		
		
		return false;
	}
	
	public static void purchase(int index) {
		
		deleteBasket(index);
		Data.update();
		
		System.out.println();
		System.out.println("            ======================================================");
		System.out.println("                         주문이 완료되었습니다! 감사합니다!");
		System.out.println("                              행복한 하루 보내세요!");
		System.out.println("            ======================================================");
		
		MainClass.pause();
		System.out.println();
		
		CartService.cartItemView();
	}
	
	public static void allPurchase(String id) {

		allDeleteBasket(id);
		Data.update();
		
		System.out.println();
		System.out.println("            ======================================================");
		System.out.println("                         주문이 완료되었습니다! 감사합니다!");
		System.out.println("                              행복한 하루 보내세요!");
		System.out.println("            ======================================================");
		
		MainClass.pause();
		
		System.out.println();
		
		MemberService.memberMenu();
	}

	public static ArrayList<Basket> allDeleteBasket(String id) {

		ArrayList<Basket> blist = new ArrayList<Basket>();
		
		for (Basket basket : basketList) {

			if (basket.getBasketId().equals(id)) {
				blist.add(basket);
			}
			
			Iterator<Basket> itr = blist.iterator();
			
			while(itr.hasNext()) {
				Basket b = itr.next();
				
				itr.remove();
				Data.update();

				return blist;
			}
		}
		return null;
	}

	public static boolean deleteWish(int itemCode) {
		
		for (WishList wish : wishList) {
			
			if(wish.getLikeItemCode() == itemCode) {
				
				wishList.remove(wish);
				Data.update();
				
				return true;
			}
		}
		return false;
	}

	public static ArrayList<WishList> allDeleteWishList(String memberId) {
		
		ArrayList<WishList> wlist = new ArrayList<WishList>();

		for (WishList wish : wishList) {
			
			if (wish.getLikeId().equals(memberId)) {
				wlist.add(wish);
			}
			
			Iterator<WishList> itr = wlist.iterator();
			
			while(itr.hasNext()) {
				
				WishList w = itr.next();
				
				itr.remove();
				Data.update();
				
				return wlist;
			
			}
			
		}
		
		return null;
	}

	public static int getAllPrice(String memberId) {

		ArrayList<Integer> priceList = new ArrayList<Integer>();

		for (Basket basket : basketList) {

			if (basket.getBasketId().equals(memberId)) {

				priceList.add(basket.getBasketItemPrice());
			}
		}
		
		if (priceList.size() != 0) {


			int sum = 0;
			for (int i : priceList) {

				sum += i;
			}

			return sum;

		} else {
			return 0;
		}
	}

	public static String buySelectItem(String memberId, int sel) {
		
		for (Basket basket : basketList) {
			
			if (basket.getBasketId().equals(memberId)) {
				if (basket.getBasketItemCode() == sel) {
					
					return Data.getItemName(sel);
					
				}	
			}
		}
		return null;
	}

	public static int getItemPirce(int sel) {
		
		for (Item item : itemList) {
			
			if (item.getItemCode() == sel) {
				
				return item.getPrice();
			}
		}
		return 0;
	}

	public static String getShopName(int sel) {
		
		for (Item item : itemList) {
			if(item.getItemCode() == sel) {
				return item.getShopName();
			}
		}
		return null;
	}

	public static int getItemCount(String memberId) {
		
		int count = 0;
		for (Basket basket : basketList) {
			if(basket.getBasketId().equals(memberId)) {
				count++;
			}
		}
		
		return count;
	}
}


