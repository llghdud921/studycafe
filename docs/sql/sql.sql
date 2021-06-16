
drop table members cascade constraint;

create table members(
Name Varchar2(10) not null ,
R_time number not null, 
Email Varchar2(30) not null,
Password Varchar2(30) not null,
Phone Varchar2(30) not null,
Gender Varchar2(1) not null, 
Use number not null,
S_time number not null);

drop table seats cascade constraint;

create table seats(
T_number Number not null,
Gender Varchar2(1),
Name Varchar2(10),
SeatTF Varchar2(1) not null,
Use_Time number not null);

alter table members
add constraint PK_MEMBERS_USERID primary key (Email);

drop table times cascade constraint;

create table times(
tid number not null,
day varchar2(20) not null,
in_time Varchar2(1000) not null,
out_time Varchar2(1000),
use_time Varchar2(10) ,
name Varchar2(10) not null);

drop table amembers cascade constraint;

create table amembers (
Email Varchar2(30) not null,
Password Varchar2(30) not null,
Name Varchar2(10) not null
);

-----------------------------------------------------

delete from members;

delete from amembers;

delete from times;
drop sequence t_ID;
create sequence t_ID start with 1 increment by 1;

delete from seats;

insert into seats values (1,null,null,'F',0);
insert into seats values(2,null,null,'F',0);
insert into seats values(3,null,null,'F',0);
insert into seats values(4,null,null,'F',0);
insert into seats values(5,null,null,'F',0);
insert into seats values(6,null,null,'F',0);
insert into seats values(7,null,null,'F',0);
insert into seats values(8,null,null,'F',0);
insert into seats values(9,null,null,'F',0);
insert into seats values(10,null,null,'F',0);
insert into seats values(11,null,null,'F',0);
insert into seats values(12,null,null,'F',0);
insert into seats values(13,null,null,'F',0);
insert into seats values(14,null,null,'F',0);
insert into seats values(15,null,null,'F',0);
insert into seats values(16,null,null,'F',0);


---------------------------------------------------------

insert into members(Email,Password,Name,Phone,R_Time,Gender,Use,S_Time) values('park@naver.com','222222','박정연','01011112222',0,'F',0,0);
insert into members(Email,Password,Name,Phone,R_Time,Gender,Use,S_Time) values('jeon@naver.com','333333','전예림','01033334444',0,'F',0,0);


insert into members(Email,Password,Name) values('admin@naver.com','000000','관리자1');


