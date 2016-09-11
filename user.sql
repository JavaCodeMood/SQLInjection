create database if not exists test1;
use test1;
drop table if exists user;
create table user(
	id int not null primary key auto_increment,
    `name` varchar(20) not null,
    `password` varchar(20) not null,
    `age` int not null 
    );
    
insert into user(`name`,`password`,`age`) values('user1','123456',18);
insert into user(`name`,`password`,`age`) values('user2','123456',20);


drop table if exists sponsor;
create table sponsor(
	id int not null primary key auto_increment,
    `name` varchar(20) not null,
    `time` varchar(20) not null,
    `money` int not null 
    );
insert into sponsor(`name`,`time`,`money`) values('sponsor1','1年',1000);
insert into sponsor(`name`,`time`,`money`) values('sponsor2','2年',2000);
desc sponsor;

DROP PROCEDURE IF EXISTS check_login;
DELIMITER // 
CREATE PROCEDURE check_login(
IN name1 varchar(20),
IN password1 varchar(20)
) 
BEGIN 
SELECT `id`,`name`,`age` FROM user where `name`=name1 and `password`=password1; 
END // 
DELIMITER ; 

CALL check_login('user1','123');

select * from user union select * from sponsor;