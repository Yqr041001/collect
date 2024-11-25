-- student数据库创建示例
create database student1 character set utf8;
use student1;

-- 设计客户端默认字符集
SET @saved_cs_client = @@character_set_client;
SET @@character_set_client = 'utf8';

-- 含指定引擎和默认字符集
create table stu
(
	sno char(9) primary key,
	sname varchar(30) not null,
	ssex char(2) not null,
	snative varchar(30),
	mno int
)ENGINE=InnoDB DEFAULT CHARSET= utf8;

set names utf8;
insert into stu values('100000001','尚小云','女','广东广州',1);
insert into stu values('100000002','廖时飞','男','广东梅州',1);
insert into stu values('100000003','宋凌枫','男','湖南郴州',2);
insert into stu values('100000004','刘小纳', '女','广东佛山',2);

-- 恢复客户端默认字符集
SET @@character_set_client = @saved_cs_client;