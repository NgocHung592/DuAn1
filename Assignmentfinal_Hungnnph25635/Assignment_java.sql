create database assignment_java;
use assignment_java;
go

create table Logins(
	id int identity primary key,
	username varchar(20) not null,
	password varchar(20) not null,
	vai_tro varchar(10) not null
);
go

create table Diems(
	id int identity primary key,
	masv varchar(20) not null,
	tensv nvarchar(50) not null,
	diem_tienganh float not null,
	diem_tinhoc float not null,
	diem_gdtc float not null,
	foreign key(masv) references SinhViens(masv)
);
go
create table SinhViens(
	id int identity primary key,
	masv varchar(20) not null,
	tensv nvarchar(50) not null,
	email varchar(20) not null,
	sdt varchar(20) not null,
	gioi_tinh int not null,
	dia_chi nvarchar(50) not null,
	hinh_anh varchar(20) not null,
);
alter table SinhVien add constraint pk_sv primary key(id,mav);

insert into Diems
values ('sv1','hung',9,8,10),
('sv1','hung',9,8,10)
select * from Diems
insert into SinhViens values
('sv1','hung','hung@gmail.com','0326995001',1,'HN','save.png')
select * from SinhViens
insert into Logins values
('tuan12345','12345','giang vien'),
('hung12345','12345','can bo')