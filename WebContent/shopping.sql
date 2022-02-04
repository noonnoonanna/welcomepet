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

create sequence pro_seq start with 1; 					-- ��ǰ��ȣ ������
create sequence order_seq start with 1; 				-- �ֹ���ȣ ������
create sequence cart_seq start with 1; 					-- īƮ��ȣ ������
create sequence qna_seq start with 1; 					-- �������� ������ 
create sequence detail_seq start with 1; 				-- �󼼻�ǰ��ȣ ������
create sequence re_seq start with 1;  					-- �����ȣ ������
create sequence mtm_seq start with 1;  					-- 1:1 ������

create table Join_User(
	ID			varchar2(20) not null primary key, 		-- ȸ�� ���̵�
	password	varchar2(50) not null,					-- ȸ�� ��й�ȣ
	name 		varchar2(20) not null,			   		-- ȸ�� �̸�
	birthday	varchar2(20) not null,					-- ȸ�� �������
	phone 		varchar2(20) not null,					-- ȸ�� ��ȭ��ȣ
	address 	varchar2(300)not null,		     		-- ȸ�� �ּ�
	Email 		varchar2(50),					   		-- ȸ�� �̸���
	cateName    varchar2(30) not null					-- ���ɻ�
);


create table category(   							-- ���� ȭ�� ī�װ� ������
	cateCode 	number(10)   not null primary key,	-- ī�װ� �ڵ� 0.���ɾ��� 1.������ 2.����� 3.���� 4.����� 	 
	cateName 	varchar2(30) not null				-- ī�װ� �̸� 0.���ɾ��� 1.dog 2.cat 3.bird 4.rep
);

insert into category values(0,'none');
insert into category values(1,'dog');
insert into category values(2,'cat');
insert into category values(3,'bird');
insert into category values(4,'rep');

create table admin(
	admin_id    varchar2(20) not null primary key, 	-- ������ ���̵�
	admin_name  varchar2(20) not null,			 	-- ������ �̸�
	admin_pw    varchar2(50) not null			  	-- ������ ��й�ȣ
);

create table product(
	pNum 	  number(10)   not null primary key,   					-- ��ǰ ��ȣ(������)
	pName	  varchar2(100) not null, 			   					-- ��ǰ��
	pPrice 	  number(10)   not null,			   					-- ��ǰ����
	CP 		  varchar2(30) not null,			   					-- ���ۻ�
	pImg 	  varchar2(100)not null,			   					-- ��ǰ �̹���
	pInfo 	  varchar2(200)not null,            					-- ��ǰ ����
	cateCode  number(10)   not null references category(cateCode),  -- ī�װ� �ڵ� FK category(cateCode)  	
	cateName  varchar2(30), 							            -- ī�װ� �̸�		  	
	kind	  varchar2(30) not null								    -- ��ǰ ����
);

create table p_order(
	oNum    number(10)   not null primary key,  	     	-- ��ǰ ���Ź�ȣ(������)
	ID 	    varchar2(20) not null references join_User(ID),	-- ��ǰ�� �ֹ��� ȸ���� ���̵�
	indate  date default sysdate							-- �ֹ� ����  				
);

create table cart(
	cNum 	   number(10)   not null primary key,				-- ������(��ٱ��� ��ȣ)
	id 		   varchar2(20) references Join_User(ID),	        -- �ֹ��� FK Join_User�� ID
	pNum_cart  number(10)   references product(pNum),	        -- ��ǰ��ȣ FK Product�� pNum
	cnt 	   number(4)    default 1 not null 					-- �ֹ� ����
);

create table o_detail(
	odNum 		 number(10)	  not null primary key,					-- �� ��ǰ ���Ź�ȣ(������)
	oNum 		 number(10)   not null references p_order(oNum),	-- ��ǰ ���Ź�ȣ(������) FK p_order(oNum)
	pNum 		 number(10)   references product(pNum),				-- ��ǰ ��ȣ(������) FK product(pNum)
	cnt 		 number(5) 	  default 1,							-- ��ǰ �ֹ� ����
	admin_state	 varchar2(20) default '�ֹ��Ϸ�' not null, 			-- ������ ȭ�鿡�� ���� �ֹ� ����
	user_state 	 varchar2(20) default '�����Ϸ�' not null,   			-- ���� ȭ�鿡�� ���� �ֹ� ����
	result	 	 number(1)    default 1 not null ,					-- ���� �亯 Ȯ�ο�
	oName		 varchar2(20) not null,								-- ��� �޴º�
	oAddress     varchar2(300) not null,							-- �����
	oPhone	     varchar2(20) not null								-- ��� �޴º� ����ó		
);

create table qna(
	qNo 	    number(10)   not null primary key,	             -- �������� ��ȣ(������)
	qTitle 		varchar2(50) not null,			                 -- ����
	ID 			varchar2(20) default '���',  					 -- �ۼ��� ID
	qDate 		date default sysdate, 			                 -- �ۼ�����
	qContent 	varchar2(500)           		                 -- ���ǳ���
);

create table review(
 rNum     number(4) primary key,	 	 -- ���� �� ��ȣ(������)
 pNum     number(4) not null,			 -- ��ǰ��ȣ
 odNum    number(4) not null,			 -- ��ǰ�� �ֹ���ȣ
 ID       varchar2(20),					 -- ȸ�� ���̵�
 content  varchar2(300),				 -- ���� ����
 rImg     varchar2(300),				 -- ���信 �ø� ����
 wDate    date default sysdate,          -- ���� �ۼ���
 rating   varchar2(3) default '5'  		 -- ����
);

create table mtm (
 qseq    number(5) primary key,  -- 1:1 ���� ��ȣ (������)
 title   varchar2(300),			 -- ������
 content varchar2(1000),		 -- �۳���
 reply   varchar2(1000),		 -- �亯
 id      varchar2(1000),		 -- �ۼ��� id
 rep     char(1) default '1',	 -- 1:�亯���� 2:�亯�Ϸ�
 indate  date default sysdate    -- ���Ǳ� �ۼ���
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