package com.test.ranking;


import com.test.buyHistory.BuyHistory;
import com.test.fashion.MainClass;
import com.test.member.MemberService;

import java.io.*;
import java.util.*;

public class Ranking {

    static ArrayList<String> topShop = shopRanking();
    static ArrayList<String> topItem = itemRanking();

    public static void main(String[] args) {
        init();
    }

    private static void init() {
        int select = rankingMenu();
        selectMenu(select);
    }

    private static void selectMenu(int select) {
        Scanner scan = new Scanner(System.in);

        switch (select) {
            case 1:
                System.out.println("                                  *쇼핑몰 랭킹*");
                System.out.println("            ======================================================");
                for (int i = 0; i < 5; i++) {
                    System.out.println("                           " + (i + 1) + "위. " + topShop.get(i));
                }

                System.out.println("            ======================================================");
                System.out.println();
    			MainClass.pause();

                String input = scan.nextLine();
                if(input.length() == 0) {
                    init();
                    break;
                }
                break;

            case 2:
                System.out.println("                                  *상품 랭킹*");
                System.out.println("            ======================================================");
                for (int i = 0; i < 5; i++) {
                    System.out.println("                           " + (i + 1) + "위. " + topItem.get(i));
                }

                System.out.println("            ======================================================");
                System.out.println();
    			MainClass.pause();

                input = scan.nextLine();
                if(input.length() == 0) {
                    init();
                    break;
                }
                break;

            case 3: MainClass.main(null);
            default:
                System.out.println();
                System.out.println("            잘못된 입력입니다.");
                System.out.println("            다시 입력해주세요.");
                init();
                break;

        }
    }

    private static ArrayList<String> itemRanking() {
        ArrayList<String> itemShop = null;
        try {
            BufferedReader Buyread = new BufferedReader(new FileReader(".//dat//item.txt"));
            HashMap<String, Integer> sellcount = new HashMap<String, Integer>();
            itemShop = new ArrayList<>();


            String line = null;
            while ((line = Buyread.readLine()) != null) {
                String[] temp = line.split(",");
                if(sellcount.containsKey(temp[1])) {
                    int count = sellcount.get(temp[1]);
                    count += Integer.parseInt(temp[5]);
                    sellcount.put(temp[1],count);
                } else {
                    sellcount.put(temp[1],Integer.parseInt(temp[5]));
                }
            }

            List<String> keySet = new ArrayList<>(sellcount.keySet());

            // Value 값으로 오름차순 정렬
            keySet.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return sellcount.get(o2).compareTo(sellcount.get(o1));
                }
            });


            itemShop.addAll(keySet);

        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return (itemShop);
    }

    private static ArrayList<String> shopRanking() {
        ArrayList<String> topShop = null;
        try {
            BufferedReader Buyread = new BufferedReader(new FileReader(".//dat//buyList.txt"));
            HashMap<String, Integer> sellcount = new HashMap<String, Integer>();
            topShop = new ArrayList<>();


            String line = null;
            while ((line = Buyread.readLine()) != null) {
                String[] temp = line.split(",");
                if(sellcount.containsKey(temp[3])) {
                    int count = sellcount.get(temp[3]);
                    count += Integer.parseInt(temp[2]);
                    sellcount.put(temp[3],count);
                } else {
                    sellcount.put(temp[3],Integer.parseInt(temp[2]));
                }
            }

            List<String> keySet = new ArrayList<>(sellcount.keySet());

            // Value 값으로 오름차순 정렬
            keySet.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return sellcount.get(o2).compareTo(sellcount.get(o1));
                }
            });

            topShop.addAll(keySet);

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return (topShop);
    }

    private static int rankingMenu() {
        Scanner scan = new Scanner(System.in);

        System.out.println("            ======================================================");
        System.out.println("                                   1. 쇼핑몰 별");
        System.out.println("                                   2. 상품 별");
        System.out.println("                                   3. 뒤로가기");
        System.out.println("            ======================================================");
        System.out.println();
        System.out.print("            선택: ");

        int select = scan.nextInt();
        scan.nextLine();

        return select;
    }


}