drop table qna; 
drop table o_detail;
drop table p_order;
drop table cart;
drop table product;
drop table category;
drop table Join_User;
drop table admin;
drop table review;
drop table mtm;

drop view cart_view;
drop view cate_view;
drop view order_view;
drop view re_view;

drop sequence pro_seq;
drop sequence order_seq;	
drop sequence cart_seq;
drop sequence qna_seq;
drop sequence detail_seq;
drop sequence re_seq;
drop sequence mtm_seq;

create sequence pro_seq start with 1; 					-- 상품번호 시퀀스
create sequence order_seq start with 1; 				-- 주문번호 시퀀스
create sequence cart_seq start with 1; 					-- 카트번호 시퀀스
create sequence qna_seq start with 1; 					-- 공지사항 시퀀스 
create sequence detail_seq start with 1; 				-- 상세상품번호 시퀸스
create sequence re_seq start with 1;  					-- 리뷰번호 시퀀스
create sequence mtm_seq start with 1;  					-- 1:1 시퀀스

create table Join_User(
	ID			varchar2(20) not null primary key, 		-- 회원 아이디
	password	varchar2(50) not null,					-- 회원 비밀번호
	name 		varchar2(20) not null,			   		-- 회원 이름
	birthday	varchar2(20) not null,					-- 회원 생년월일
	phone 		varchar2(20) not null,					-- 회원 전화번호
	address 	varchar2(300)not null,		     		-- 회원 주소
	Email 		varchar2(50),					   		-- 회원 이메일
	cateName    varchar2(30) not null					-- 관심사
);


create table category(   							-- 메인 화면 카테고리 나누기
	cateCode 	number(10)   not null primary key,	-- 카테고리 코드 0.관심없음 1.강아지 2.고양이 3.조류 4.파충류 	 
	cateName 	varchar2(30) not null				-- 카테고리 이름 0.관심없음 1.dog 2.cat 3.bird 4.rep
);

insert into category values(0,'none');
insert into category values(1,'dog');
insert into category values(2,'cat');
insert into category values(3,'bird');
insert into category values(4,'rep');

create table admin(
	admin_id    varchar2(20) not null primary key, 	-- 관리자 아이디
	admin_name  varchar2(20) not null,			 	-- 관리자 이름
	admin_pw    varchar2(50) not null			  	-- 관리자 비밀번호
);

create table product(
	pNum 	  number(10)   not null primary key,   					-- 상품 번호(시퀀스)
	pName	  varchar2(100) not null, 			   					-- 상품명
	pPrice 	  number(10)   not null,			   					-- 상품가격
	CP 		  varchar2(30) not null,			   					-- 제작사
	pImg 	  varchar2(100)not null,			   					-- 상품 이미지
	pInfo 	  varchar2(200)not null,            					-- 상품 설명
	cateCode  number(10)   not null references category(cateCode),  -- 카테고리 코드 FK category(cateCode)  	
	cateName  varchar2(30), 							            -- 카테고리 이름		  	
	kind	  varchar2(30) not null								    -- 제품 종류
);

create table p_order(
	oNum    number(10)   not null primary key,  	     	-- 상품 구매번호(시퀀스)
	ID 	    varchar2(20) not null references join_User(ID),	-- 상품을 주문한 회원의 아이디
	indate  date default sysdate							-- 주문 일자  				
);

create table cart(
	cNum 	   number(10)   not null primary key,				-- 시퀸스(장바구니 번호)
	id 		   varchar2(20) references Join_User(ID),	        -- 주문자 FK Join_User의 ID
	pNum_cart  number(10)   references product(pNum),	        -- 상품번호 FK Product의 pNum
	cnt 	   number(4)    default 1 not null 					-- 주문 수량
);

create table o_detail(
	odNum 		 number(10)	  not null primary key,					-- 상세 상품 구매번호(시퀸스)
	oNum 		 number(10)   not null references p_order(oNum),	-- 상품 구매번호(시퀸스) FK p_order(oNum)
	pNum 		 number(10)   references product(pNum),				-- 상품 번호(시퀸스) FK product(pNum)
	cnt 		 number(5) 	  default 1,							-- 상품 주문 갯수
	admin_state	 varchar2(20) default '주문완료' not null, 			-- 관리자 화면에서 보는 주문 상태
	user_state 	 varchar2(20) default '결제완료' not null,   			-- 유저 화면에서 보는 주문 상태
	result	 	 number(1)    default 1 not null ,					-- 리뷰 답변 확인용
	oName		 varchar2(20) not null,								-- 배송 받는분
	oAddress     varchar2(300) not null,							-- 배송지
	oPhone	     varchar2(20) not null								-- 배송 받는분 연락처		
);

create table qna(
	qNo 	    number(10)   not null primary key,	             -- 공지사항 번호(시퀀스)
	qTitle 		varchar2(50) not null,			                 -- 제목
	ID 			varchar2(20) default '운영자',  					 -- 작성자 ID
	qDate 		date default sysdate, 			                 -- 작성일자
	qContent 	varchar2(500)           		                 -- 문의내용
);

create table review(
 rNum     number(4) primary key,	 	 -- 리뷰 글 번호(시퀀스)
 pNum     number(4) not null,			 -- 상품번호
 odNum    number(4) not null,			 -- 상품별 주문번호
 ID       varchar2(20),					 -- 회원 아이디
 content  varchar2(300),				 -- 리뷰 내용
 rImg     varchar2(300),				 -- 리뷰에 올릴 사진
 wDate    date default sysdate,          -- 리뷰 작성일
 rating   varchar2(3) default '5'  		 -- 별점
);

create table mtm (
 qseq    number(5) primary key,  -- 1:1 문의 번호 (시퀀스)
 title   varchar2(300),			 -- 글제목
 content varchar2(1000),		 -- 글내용
 reply   varchar2(1000),		 -- 답변
 id      varchar2(1000),		 -- 작성자 id
 rep     char(1) default '1',	 -- 1:답변없음 2:답변완료
 indate  date default sysdate    -- 문의글 작성일
);

create or replace view cart_view
as
select c.cNum, c.id, c.pNum_cart, u.name uname, p.pName pname, 
c.cnt, p.pPrice  
from cart c, join_User u, product p 
where c.id = u.id and c.pNum_cart = p.pNum;

create or replace view order_view
as
select d.odNum, o.oNum ,j.ID, o.indate , d.pNum , d.cnt ,
j.name, d.oname, d.oaddress, d.ophone, p.pName , p.pPrice ,d.result, j.address , j.phone , 
d.user_state , d.admin_state
from p_order o, o_detail d, product p, Join_User j
where o.ID = j.ID and d.pNum = p.pNum and o.onum = d.onum;

create or replace view cate_view
as
select p.pNum, p.pName, p.pPrice, p.CP, p.pImg, p.pInfo, p.kind, c.cateCode, c.cateName
from product p, category c
where p.cateCode = c.cateCode;

create or replace view re_view
as
select p.pNum, o.USER_STATE , r.rNum , r.ID, r.content, r.rImg, r.wDate, r.rating
from product p, review r, o_detail o
where r.pNum = p.pNum and r.odnum=o.odnum;