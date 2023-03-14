create database QLKhachSan
go

use QLKhachSan
go

create table NhanVien(
	MaNV varchar(100) primary key,
	TenNV nvarchar(100),
	GioiTinh nvarchar(10),
	DiaChi nvarchar(100),
	SDT varchar(100),
	CaLam nvarchar(50),
	Luong money,
	SoNgayNghi int,
	TinhTrang nvarchar(50),
)

create table TaiKhoan(
	TenTK varchar(100) primary key,
	MatKhau varchar(100),
)

create table KhachHang(
	MaKH int identity(1,1) primary key,
	TenKH nvarchar(100),
	GioiTinh nvarchar(10),
	NgaySinh date,
	CCCD varchar(100),
	DiaChi nvarchar(100),
	SDT varchar(100)
)

create table Phong(
	SoPhong varchar(100) primary key,
	GiaPhong money,
	TinhTrang nvarchar(100),
	MaKH int,
	NgayDat dateTime,
	constraint FK_Phong_KhachHang foreign key(MaKH) references KhachHang(MaKH)
)

go
create table HoaDon(
	MaHD int identity(1,1) primary key,
	SoPhong varchar(100),
	MaKH int,
	NgayDat dateTime,
	NgayTra dateTime,
	ThanhTien money,
	GhiChu nvarchar(100),
	constraint FK_HoaDon_Phong foreign key(SoPhong) references Phong(SoPhong)
)

use QLKhachSan
go

insert into TaiKhoan values('admin', '12345')

insert into NhanVien values('NV01', N'Phạm Văn Đạt', N'Nam', N'Thanh Hóa', '0123456789', N'Sáng', 10000000, 3, N'Có mặt'),
							('NV02', N'Hoàng Thị Hiếu', N'Nữ', N'Cần Thơ', '099999999', N'Tối', 900000000, 29, N'Vắng'),
							('NV03', N'Trịnh Tiến Lên', N'Nam', N'Nghệ An', '0888888888', N'Sáng', 15000000, 5, N'Có mặt'),
							('NV04', N'Đoàn Thị Báo', N'Nữ', N'Hà Lội', '0777777777', N'Tối', 17000000, 6, N'Vắng'),
							('NV05', N'Nguyễn Quang Si', N'Nam', N'Agentina', '0111111111', N'Tối', 16000000, 7, N'Có mặt')

insert into KhachHang values(N'Nguyễn Văn Quang', N'Nam', '2023-01-27', '2020602028', N'Thanh Hóa', '0123456789'),
							(N'Hoàng Minh Hương', N'Nữ', '2023-01-27', '2020602029', N'Thái Bình', '0123456788'),
							(N'Nguyễn Minh Đại', N'Nữ', '2023-01-26', '2020602030', N'Hưng Yên', '0123456787'),
							(N'Nguyễn Quang Đoàn', N'Nam', '2023-01-26', '2020602018', N'Hải Dương', '0123456786'),
							(N'Trịnh Tiến Anh', N'Nam', '2023-01-26', '2020602019', N'Phú Thọ', '0123456785')

insert into Phong values('101', 100000, N'Trống', null, null),
						('102', 200000, N'Đã đặt', 1, '2023-02-25 20:30'),
						('201', 300000, N'Đã đặt', 2, '2023-02-26 21:30'),
						('202', 400000, N'Trống', null, null),
						('303', 500000, N'Đã đặt', 1, '2023-02-22 20:30')

insert into HoaDon values('101', 1, '2023-02-27 20:30', '2023-02-28 16:00', 1000000, N'Đã thanh toán')


