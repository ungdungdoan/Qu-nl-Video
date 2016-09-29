create table LoaiSach(
    maLoai int PRIMARY KEY NOT NULL,
	loai nvarchar(20)
)

create table Sach(
   maSach int PRIMARY KEY NOT NULL,
   maLoai int,
   tenSach nvarchar(30),
   tacGia nvarchar(30),
   gia money,
)

create table ThuThu(
 maTT int PRIMARY KEY NOT NULL,
 tenTT nvarchar(30),
 diaChi nvarchar(30),
  soDT nvarchar(11),
)

create table TheThuVien(
  maThe int PRIMARY KEY NOT NULL,
  maSach int,
  ngayThue datetime,
  ngayTra datetime,
  maTT int,
  giaThue money,
  maKH int,
)

create table KhachHang(
  maKH int PRIMARY KEY NOT NULL,
  loaiKH varchar(5),
  tenKH nvarchar(30),
  diaChi nvarchar(30),
  soDT nvarchar(11),
  soCMND nvarchar(10),
)

Alter Table sach
add constraint FK_LoaiSach foreign key(maLoai) references LoaiSach(maLoai)
Alter Table TheThuVien
add constraint FK_Sach foreign key(maSach) references Sach(maSach)
Alter Table TheThuVien
add constraint FK_ThuThu foreign key(maTT) references ThuThu(maTT)
Alter Table TheThuVien
add constraint FK_KH foreign key(maKH) references KhachHang(maKH)