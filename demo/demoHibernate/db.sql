create table sanpham (
masanpham number(6) constraint sanpham_pk primary key, 
tensanpham varchar2(60), 
gia number,
soluong number,
tinhtrang VARCHAR2(60),
mota VARCHAR2(200),
ngaysanxuat number,
madanhmuc number(6),
hinhanh VARCHAR(100));


create table chitiethoadon (
mahoadon number(6) , 
masanpham number(6),
gia number,
soluong number,
constraint chitethoadon_pk primary key (mahoadon,masanpham)
);

create table danhmuc (
madanhmuc number(6) constraint danhmuc_pk primary key, 
tendanhmuc varchar2(60));


create table hoadon (
mahoadon number(6) constraint hoadon_pk primary key, 
tenhoadon varchar2(60),
ngaylap date,
tinhtrang varchar2(20),
hinhthucthanhtoan varchar2(20),
username varchar2(20)
);

create table taikhoan (
username varchar2(20) constraint taikhoan_pk primary key, 
password varchar2(40),
hoten varchar2(60),
email varchar2(60),
dienthoai number,
congty varchar2(60),
diachi varchar2(60)
);

alter table hoadon add (constraint hoadon_fk_taikhoan
foreign key (username) references taikhoan(username)); 
 
alter table chitiethoadon add (constraint chitiethoadon_hoadon_fk
foreign key (mahoadon) references hoadon(mahoadon)); 

alter table chitiethoadon add (constraint chitiethoadon_sanpham_fk
foreign key (masanpham) references sanpham(masanpham)); 

alter table sanpham add (constraint sanpham_danhmuc_fk
foreign key (madanhmuc) references danhmuc(madanhmuc)); 

//identity
create sequence seq_danhmuc
increment by 1
start with 1;

create sequence seq_hoadon
increment by 1
start with 1;

CREATE OR REPLACE trigger danhmuc_trigger_IDUp
BEFORE INSERT ON danhmuc
for each row
begin
    select seq_danhmuc.nextval into :new.madanhmuc from dual;
end;

CREATE OR REPLACE trigger hoadon_trigger_IDUp
BEFORE INSERT ON hoadon
for each row
begin
    select seq_hoadon.nextval into :new.mahoadon from dual;
end;


insert into danhmuc (tendanhmuc) values('danh muc 1');
insert into danhmuc (tendanhmuc) values('danh muc 2');
insert into danhmuc (tendanhmuc) values('danh muc 3');
insert into danhmuc (tendanhmuc) values('danh muc 4');