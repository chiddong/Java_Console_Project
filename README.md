# Java_Console_Project👩‍💻


## Summary
- 기존 쇼핑몰에 회원들이 소통을 할 수 있는 게시판을 추가하여, 쇼핑몰 사용자간 커뮤니티 활동이 가능한 프로그램입니다.

&nbsp;
&nbsp;

### ✨프로젝트 목적
1.  소통을 쇼핑으로 이어지게 함으로써 회원들에게 다양한 상품을 제공
2.  시스템 관리자에게 커뮤니티,  쇼핑몰 통합 관리 시스템을 제공


&nbsp;
&nbsp;

### ✨주요기능
☑️ 회원 가입

☑️ 로그인

☑️ 아이디/비밀번호 찾기

☑️ 상품 검색

☑️ 장바구니/찜

☑️ 구매하기

☑️ 회원탈퇴

☑️ 상품 관리

☑️ 게시


&nbsp;
&nbsp;

### ✨ 사용 기술
| 기술분야 | 상세내용 |
| ------ | ------ |
| 파일 입출력 | BufferedReader, Writer, FileReader |
| 컬렉션 | ArrayList<T>, HashMap<T> |
| 기타 레퍼런스 타입 클래스 | 데이터 생성을 위한 Random, Math 클래스스 |
| 오버로딩 | 생성자 오버로딩 |

&nbsp;
 &nbsp;     

### ✨ 담당 업무
- **회원** 
     1. 장바구니 추가 및 삭제
&nbsp;
&nbsp;
&nbsp;     
     ![image](https://user-images.githubusercontent.com/111338981/214494231-cc423de0-8387-4dcb-a150-4ab246d8ff73.png)
     ![image](https://user-images.githubusercontent.com/111338981/214494327-ac952a79-6ab3-4e14-a585-46e3df8e8795.png)
     ![image](https://user-images.githubusercontent.com/111338981/214494339-1221f547-88c8-4085-bc05-dfcc359f93ca.png)
&nbsp;
&nbsp;
- 내용
 

     개인 회원이 상품 검색 후에 혹은 찜 목록에서 장바구니에 추가를 할 수 있으며,
    장바구니 추가된 제품을 선택구매 혹은 전체구매 할 수 있습니다.
    구매 시에는 구매한 제품 목록과 총 금액을 출력하여 보여줍니다.
    이때 원하지 않는 상품을 선택삭제 혹은 장바구니 내역 전체삭제를 할 수 있습니다.
 
 
 
 
- 기술
     ###### Scanner, ArrayList, Iterator, BufferedReader, BufferedWriter, Stream

    Stream을 통해 로그인한 회원의 ID에 해당하는 장바구니 목록을 출력하였고,
    장바구니 추가를 누르면 Basket 객체의 setter를 이용하여 
    회원 아이디와 상품코드, 상품명, 수량, 가격, 쇼핑몰 데이터를 넣어주었습니다.
    전체 상품 삭제시에는 Iterator를 사용하여 삭제를 진행하였는데, 처음에는 Iterator 사용법에 대해
    제대로 숙지가 되어 있지 않은 상황이라 다소 어려움을 느꼈으나, 프로젝트 진행을 하면서 Iterator 사용에
    대해서 잘 알게 되었고 이후에는 해당 내용을 팀원들에게 설명할 수 있게 되었습니다. 


&nbsp;
&nbsp;
&nbsp;     
 
     2. 장바구니 추가 및 삭제
&nbsp;
&nbsp;
&nbsp;     
     ![image](https://user-images.githubusercontent.com/111338981/214494782-64aa5ebb-3ce2-4873-915e-a31820290482.png)
     ![image](https://user-images.githubusercontent.com/111338981/214494799-2d83f935-2c8c-4261-9523-279eafed4c1f.png)
     ![image](https://user-images.githubusercontent.com/111338981/214494813-067201f2-b27b-4e01-8e56-d3de90f3b7c8.png)
&nbsp;
&nbsp;
- 내용
 

    상품을 둘러보던 개인 회원이 원하는 상품을 찜 할 수 있는 기능입니다.
    상품 검색 후 찜 목록 추가가 가능하며, 구매를 원할 경우 장바구니로 이동 후에 구매할 수 있습니다.
    추가로 찜 목록에서 삭제를 원하는 제품을 삭제할 수 있습니다.

 
 
- 기술
     ###### Scanner, ArrayList, BufferedReader, BufferedWriter, Stream


    Stream을 통해 로그인한 회원의 ID에 해당하는 찜 목록을 출력하였고,
    찜 목록 추가를 누르면 Wish 객체의 setter를 이용하여 회원 아이디와 상품코드, 상품명, 가격, 쇼핑몰 데이터를 넣어주었습니다. 
    처음에는 getter와 setter의 사용에 대해 능숙하지 못했지만, 앞선 장바구니 추가와 더불어 찜 목록 추가를 하게 되면서 
    점차적으로 getter와 setter 사용에 능숙해질 수 있었습니다



&nbsp;
&nbsp;
&nbsp;          
     3. 구매(전체 상품 구매 및 선택 상품 구매)
&nbsp;
&nbsp;
&nbsp;     
     ![image](https://user-images.githubusercontent.com/111338981/214494963-609d1eeb-cfea-4808-a7eb-b052fb1cedea.png)
     ![image](https://user-images.githubusercontent.com/111338981/214494979-a825a39a-33e6-44de-8925-715ea18c4347.png)
&nbsp;
&nbsp;
- 내용
 

    개인회원이 장바구니에 추가된 상품 혹은 검색을 통해서 원하는 상품을 구매할 수 있습니다.
    장바구니 상품 구매 시, 전체구매와 개별 구매로 나누어서 구매 가능하며,
    구매 시 장바구니에서는 자동으로 삭제됩니다.


 
 
- 기술
     ###### Scanner, ArrayList, BufferedReader, BufferedWriter

    선택 구매하기 클릭 시, deleteBasket(상품코드) 메소드를 호출하여 해당 상품을 장바구니 목록에서
    바로 삭제되게 하였으며, 전체 구매하기 클릭 시 회원 아이디를 매개변수로 하는 allDeleteBasket 메소드를
    호출하여 전체 장바구니 목록이 비워질 수 있게 하였습니다.



&nbsp;
&nbsp;
&nbsp;          
     4. 아이디/비밀번호 찾기 
     
&nbsp;
&nbsp;
&nbsp;     
     ![image](https://user-images.githubusercontent.com/111338981/214495181-2850c1a9-93b8-4e8c-a244-e86223c5a9f0.png)
     ![image](https://user-images.githubusercontent.com/111338981/214495200-5d440107-bf32-474a-876f-9a897cac5069.png)
&nbsp;
&nbsp;
- 내용
 

    개인 회원과 쇼핑몰 회원이 아이디나 비밀번호를 잊어버린 경우, 
    회원(아이디: 이름+생년월일 / 비밀번호: 아이디+전화번호), 
    쇼핑몰(아이디: 이름+사업자번호 / 비밀번호: 아이디+대표번호)를 입력 받아
    각각의 정보를 이용하여 아이디나 비밀번호를 찾을 수 있다.



 
 
- 기술
     ###### Scanner, getter, setter

    If문을 통해 scanner로 입력 받은 값과 일치하는 데이터를 순서대로 찾은 후에, 
    최종 일치하는 값을 Member객체와 ShopMember객체의 getter를 통해 돌려받아 출력해주었습니다




&nbsp;
&nbsp;
&nbsp;          

- **쇼핑몰**
    1. 아이디/비밀번호 찾기 
     
&nbsp;
&nbsp;
&nbsp;     
     ![image](https://user-images.githubusercontent.com/111338981/214495372-456f135c-6890-47c8-8bc2-0bb8a2680035.png)
 ![image](https://user-images.githubusercontent.com/111338981/214495388-29d41ca8-8418-42e7-8e6e-89d517b22b9b.png)
&nbsp;
&nbsp;
- 내용
 

    개인 회원과 쇼핑몰 회원이 아이디나 비밀번호를 잊어버린 경우, 
    회원(아이디: 이름+생년월일 / 비밀번호: 아이디+전화번호), 
    쇼핑몰(아이디: 이름+사업자번호 / 비밀번호: 아이디+대표번호)를 입력 받아
    각각의 정보를 이용하여 아이디나 비밀번호를 찾을 수 있다.




- 기술
     ###### Scanner, getter, setter

    If문을 통해 scanner로 입력 받은 값과 일치하는 데이터를 순서대로 찾은 후에, 
    최종 일치하는 값을 Member객체와 ShopMember객체의 getter를 통해 돌려받아 출력해주었습니다




&nbsp;
&nbsp;
&nbsp;          

     
     
 ### ✨프로젝트를 통해
 
 - Java 프로그래밍 언어를 배우면서 처음으로 진행한 콘솔프로젝트 입니다.
 - 자바의 객체 지향적인 언어의 특징에 대해서 배우고, 객체를 다루는 법에 대해서 배웠습니다.
 - ArryList, HashMap과 같은 컬렉션과 파일입출력을 하는 BufferedReader등에 대해서 헷갈렸던 개념을 보다 자세히 정리할 수 있는 계기가 되었습니다.
 - 첫 팀 프로젝트에 조장으로 팀을 이끌면서 다양한 팀원들의 의견을 수렴하고, 그 과정에 있어 조율하는 법을 배울 수 있었습니다.
 - 코드를 작성하며 서로의 코드를 리뷰하기도하고, 어떻게 하면 클린코드를 작성할 수 있을지에 대해 많이 고민할 수 있었습니다.
 - 추가로 아이템 선정을 위한 브레인스토밍, 기획서, 요구 분석서, 순서도, 화면설계서, 기능명세서 등의 문서를 단계적으로 작성하면서, 프로젝트 진행과 관리하는 법에 대해서도 많은 경험을 할 수 있었던 프로젝트입니다.

&nbsp;
&nbsp;
---
&nbsp;
&nbsp;
###### _프로젝트 기간_
- 2022.09.21 ~ 2022.09.30


###### _프로젝트 참여인원_
- 5명


