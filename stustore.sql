
create database stustore  character set utf8;
create table t_user(
   id int auto_increment primary key,
   username varchar(50) unique,
   password varchar(50) not null,
   email varchar(50) not null,
   phone varchar(50) not null,
   image varchar(100),
   gender int(1),
   create_user varchar(50),
   create_time date,
   modified_user varchar(50),
   modified_time date
)default charset=utf8;

create table t_address(id int auto_increment primary key,
                       uid int not null,
                       recv_name varchar(100),
                       recv_city varchar(6),
                       recv_province varchar(6),
                       
                       
                       
                       );