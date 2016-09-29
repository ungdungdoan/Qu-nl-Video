insert into dbo.LoaiSach values(1,N'Văn Học Nước Ngoài')
insert into dbo.LoaiSach values(2,N'Văn Học Việt Nam')
insert into dbo.LoaiSach values(3,N'Truyện Tranh')
insert into dbo.LoaiSach values(4,N'Sách Giáo Khoa')
select * from LoaiSach
delete LoaiSach
insert into Sach values
(1,1,'Don Quixote','Miguel De Cervantes',50000),
(2,1,N'Nhà giả kim','Paulo Coelho',150000),
(3,1,N'Đồi gió hú','Emily Bronte',75000),
(4,1,N'Chúa tể những chiếc nhẫn','J.R.R. Tolkien',20000),
(5,1,N'Anh chàng Hobbit','J.R.R. Tolkien',250000),
(6,2,N'Hà Nội ba mươi sáu phố phường',N'Thạch Lam',55000),
(7,2,N'Bỉ vỏ',N'Nguyên Hồng',34000),
(8,2,N'Bước Đường Cùng',N'Nguyễn Công Hoan',186000),
(9,2,N'Số Đỏ',N'Vũ Trọng Phụng',152000),
(10,2,N'Đất rừng phương nam',N'Đoàn Giỏi',220000),
(11,2,N'Truyện Ngắn Nam Cao','Nam Cao',98000),
(12,3,N'One Piece Tập 2','Oda',22000),
(13,3,N'One Piece Tập 3','Oda',22000),
(14,3,N'One Piece Tập 12','Oda',22000),
(15,3,N'One Piece Tập 23','Oda',22000),
(16,3,N'One Piece Tập 34','Oda',22000),
(17,3,N'One Piece Tập 35','Oda',22000),
(18,3,N'One Piece Tập 37','Oda',22000),
(19,3,N'One Piece Tập 62','Oda',22000),
(20,3,N'One Piece Tập 68','Oda',22000),
(21,3,N'One Piece Tập 72','Oda',22000),
(22,3,N'One Piece Tập 76','Oda',22000),
(23,3,N'Bảy Viên Ngọc Rồng Tập 2','Akira Toriyama',19000),
(24,3,N'Bảy Viên Ngọc Rồng Tập 5','Akira Toriyama',19000),
(25,3,N'Bảy Viên Ngọc Rồng Tập 15','Akira Toriyama',19000),
(26,3,N'Bảy Viên Ngọc Rồng Tập 22','Akira Toriyama',19000),
(27,3,N'Bảy Viên Ngọc Rồng Tập 52','Akira Toriyama',19000),
(28,3,N'Đôrêmon Truyện Ngắn Tập 2','Fujiko Fujio',6000),
(29,3,N'Đôrêmon Truyện Ngắn Tập 5','Fujiko Fujio',6000),
(55,3,N'Đôrêmon Truyện Ngắn Tập 7','Fujiko Fujio',6000),
(30,3,N'Đôrêmon Truyện Ngắn Tập 15','Fujiko Fujio',6000),
(31,3,N'Đôrêmon Truyện Dài Tập 1','Fujiko Fujio',26000),
(32,3,N'Đôrêmon Truyện Dài Tập 2','Fujiko Fujio',26000),
(33,3,N'Đôrêmon Truyện Dài Tập 3','Fujiko Fujio',26000),
(34,3,N'Đôrêmon Truyện Dài Tập 4','Fujiko Fujio',26000)
select * from Sach
delete Sach

insert into KhachHang values
(1,'VIP',N'Hồ Quốc Bình',N'Bình Thạnh','01686262237','225456996'),
(2,'SV',N'Lương Hoàn Huân',N'Gò Vấp','0168153145','2251537248'),
(3,'SV',N'Nguyễn Anh Hào',N'Củ Chi','0168495513','225154326'),
(4,'NG',N'An Tô',N'Bình Thạnh','0169154824','224152215')
select * from KhachHang
delete KhachHang

insert into ThuThu values
(1,N'Quốc Bình Hồ',N'Bình Thạnh','01686262237'),
(2,N'Hoàn Huân Lương',N'Gò Vấp','01681322344')
select * from ThuThu
delete ThuThu

insert into TheThuVien values
(1,1,'2-2-2015','3-2-2015',1,5000,1),
(2,2,'3-3-2015','9-3-2015',2,1500,2),
(3,3,'4-4-2015','9-4-2015',1,2000,3)

select * from TheThuVien
delete TheThuVien