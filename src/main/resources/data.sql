USE [QuanLyDoGiaDung]
GO
/****** Object:  Table [dbo].[san_pham]    Script Date: 2/15/2023 10:17:24 AM ******/
CREATE TABLE [dbo].[san_pham](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[don_gia] [float] NULL,
	[hinh_anh] [varchar](255) NULL,
	[mo_ta] [nvarchar](100) NULL,
	[ten_san_pham] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[chi_tiet_don_hang]    Script Date: 2/15/2023 10:17:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chi_tiet_don_hang](
	[san_pham_id] [int] NOT NULL,
	[don_hang_id] [int] NOT NULL,
	[ngay_ket_thuc_dat_san_pham] [datetime2](7) NULL,
	[ngay_dat_san_pham] [datetime2](7) NULL,
	[so_ky] [int] NULL,
	[so_luong] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[san_pham_id] ASC,
	[don_hang_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[chi_tiet_gio_hang]    Script Date: 2/15/2023 10:17:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chi_tiet_gio_hang](
	[san_pham_id] [int] NOT NULL,
	[gio_hang_id] [int] NOT NULL,
	[ngay_dat_san_pham] [datetime2](7) NULL,
	[ngay_ket_thuc_dat_san_pham] [datetime2](7) NULL,
	[so_ky] [int] NULL,
	[so_luong] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[san_pham_id] ASC,
	[gio_hang_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[don_hang]    Script Date: 2/15/2023 10:17:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[don_hang](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[dia_chi_nhan_hang] [nvarchar](100) NULL,
	[hinh_thuc_thanh_toan] [nvarchar](100) NULL,
	[ngay_tao_don_hang] [datetime2](7) NULL,
	[tong_tien_don_hang] [float] NULL,
	[trang_thai_don_hang] [nvarchar](100) NULL,
	[khach_hang_id] [int] NULL,
	[khuyen_mai_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[gio_hang]    Script Date: 2/15/2023 10:17:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[gio_hang](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ngay_tao_gio_hang] [datetime2](7) NOT NULL,
	[khach_hang_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[khach_hang]    Script Date: 2/15/2023 10:17:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[khach_hang](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[sdt] [varchar](255) NULL,
	[email] [nvarchar](100) NULL,
	[ho_ten] [nvarchar](100) NULL,
	[users_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[khuyen_mai]    Script Date: 2/15/2023 10:17:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[khuyen_mai](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[gia_tri_giam] [float] NULL,
	[ngay_bat_dau] [datetime2](7) NULL,
	[ngay_het_han] [datetime2](7) NULL,
	[ten_khuyen_mai] [nvarchar](100) NULL,
	[nhan_vien_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[nhan_vien]    Script Date: 2/15/2023 10:17:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nhan_vien](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[sdt] [varchar](255) NULL,
	[dia_chi] [nvarchar](100) NULL,
	[ten_nhan_vien] [nvarchar](100) NULL,
	[users_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 2/15/2023 10:17:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[password] [varchar](255) NULL,
	[username] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[chi_tiet_don_hang]  WITH CHECK ADD  CONSTRAINT [FK7umh8es02cc48xi4gb5scbgcb] FOREIGN KEY([san_pham_id])
REFERENCES [dbo].[san_pham] ([id])
GO
ALTER TABLE [dbo].[chi_tiet_don_hang] CHECK CONSTRAINT [FK7umh8es02cc48xi4gb5scbgcb]
GO
ALTER TABLE [dbo].[chi_tiet_don_hang]  WITH CHECK ADD  CONSTRAINT [FKt57maavf6s28hxyar724mdr1b] FOREIGN KEY([don_hang_id])
REFERENCES [dbo].[don_hang] ([id])
GO
ALTER TABLE [dbo].[chi_tiet_don_hang] CHECK CONSTRAINT [FKt57maavf6s28hxyar724mdr1b]
GO
ALTER TABLE [dbo].[chi_tiet_gio_hang]  WITH CHECK ADD  CONSTRAINT [FK5e5jfe401gg179es4akmlg2u9] FOREIGN KEY([gio_hang_id])
REFERENCES [dbo].[gio_hang] ([id])
GO
ALTER TABLE [dbo].[chi_tiet_gio_hang] CHECK CONSTRAINT [FK5e5jfe401gg179es4akmlg2u9]
GO
ALTER TABLE [dbo].[chi_tiet_gio_hang]  WITH CHECK ADD  CONSTRAINT [FKtqquymvys3klt816jj4u5x0wq] FOREIGN KEY([san_pham_id])
REFERENCES [dbo].[san_pham] ([id])
GO
ALTER TABLE [dbo].[chi_tiet_gio_hang] CHECK CONSTRAINT [FKtqquymvys3klt816jj4u5x0wq]
GO
ALTER TABLE [dbo].[don_hang]  WITH CHECK ADD  CONSTRAINT [FKeyporccvr9mq4k9j4fc5wpum5] FOREIGN KEY([khach_hang_id])
REFERENCES [dbo].[khach_hang] ([id])
GO
ALTER TABLE [dbo].[don_hang] CHECK CONSTRAINT [FKeyporccvr9mq4k9j4fc5wpum5]
GO
ALTER TABLE [dbo].[don_hang]  WITH CHECK ADD  CONSTRAINT [FKm66hy6vf9vuoi3tdept6h771l] FOREIGN KEY([khuyen_mai_id])
REFERENCES [dbo].[khuyen_mai] ([id])
GO
ALTER TABLE [dbo].[don_hang] CHECK CONSTRAINT [FKm66hy6vf9vuoi3tdept6h771l]
GO
ALTER TABLE [dbo].[gio_hang]  WITH CHECK ADD  CONSTRAINT [FKtfg3dplbmn3wiwy26si1daye3] FOREIGN KEY([khach_hang_id])
REFERENCES [dbo].[khach_hang] ([id])
GO
ALTER TABLE [dbo].[gio_hang] CHECK CONSTRAINT [FKtfg3dplbmn3wiwy26si1daye3]
GO
ALTER TABLE [dbo].[khach_hang]  WITH CHECK ADD  CONSTRAINT [FK777qmwi2tmfvbtrrsjjb6yvp5] FOREIGN KEY([users_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[khach_hang] CHECK CONSTRAINT [FK777qmwi2tmfvbtrrsjjb6yvp5]
GO
ALTER TABLE [dbo].[khuyen_mai]  WITH CHECK ADD  CONSTRAINT [FKl49lkrrkhagrpstox8usv92fs] FOREIGN KEY([nhan_vien_id])
REFERENCES [dbo].[nhan_vien] ([id])
GO
ALTER TABLE [dbo].[khuyen_mai] CHECK CONSTRAINT [FKl49lkrrkhagrpstox8usv92fs]
GO
ALTER TABLE [dbo].[nhan_vien]  WITH CHECK ADD  CONSTRAINT [FKovyhdh7a2i4b4vm89kqotx026] FOREIGN KEY([users_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[nhan_vien] CHECK CONSTRAINT [FKovyhdh7a2i4b4vm89kqotx026]
GO
USE [master]
GO
ALTER DATABASE [QuanLyDoGiaDung] SET  READ_WRITE 
GO


use QuanLyDoGiaDung
SET IDENTITY_INSERT [dbo].[users] off 
INSERT [dbo].[users] ([id], [password], [username]) VALUES (1, N'{bcrypt}$2a$10$qDoISw0uB8nBA9NxTNiQ3OJc4we58/VfYY0fm8pxln7qyH7fezjhO', N'customer1')
INSERT [dbo].[users] ([id], [password], [username]) VALUES (2, N'{bcrypt}$2a$10$qDoISw0uB8nBA9NxTNiQ3OJc4we58/VfYY0fm8pxln7qyH7fezjhO', N'customer2')
INSERT [dbo].[users] ([id], [password], [username]) VALUES (3, N'{bcrypt}$2a$10$qDoISw0uB8nBA9NxTNiQ3OJc4we58/VfYY0fm8pxln7qyH7fezjhO', N'hoathuan')

SET IDENTITY_INSERT [dbo].san_pham ON 
INSERT [dbo].san_pham ([don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES ( 10000, N'https://khoahoctoday.xembao.vn/Epaper/2016/so60/files/assets/cover/1.jpg', N'Tạp chí khoa học và công nghệ là nơi cập nhập những tin tức về công nghệ mới nhất ', N'Tạp chí khoa học và công nghệ')
INSERT [dbo].san_pham ( [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES ( 20000, N'https://nhacxua.vn/wp-content/uploads/2020/09/thieu-nhi-40.jpg', N'Bạn sẽ dễ dàng khám phá thế giới "Nhất quỷ nhì ma - Thứ ba học trò" ', N'Thiếu Nhi')
INSERT [dbo].san_pham ( [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES ( 3000, N'https://img.nhandan.com.vn/Files/Images/2022/05/17/n17_5_tr1-1652749291889.jpg', N'Báo Nhân Dân là cơ quan ngôn luận của Đảng Cộng sản Việt Nam', N'Báo nhân dân')
INSERT [dbo].san_pham ( [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES ( 124123, N'https://nld.mediacdn.vn/2020/8/3/ava-15964262576301231699819.jpg', N'Báo Người Lao Động là tờ báo luôn đồng hành với Đời Sống và việc làm của bạn đọc.', N'Nguời lao động')
INSERT [dbo].san_pham ([don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES ( 5000, N'http://leadmedia.vn/data/upload/doisongphapluatbw.png', N'Báo đời sống pháp luật phản ánh các đặc điểm và trình độ của hiện thực pháp luật và thái độ của ...', N'Đời sống và pháp luật')
INSERT [dbo].san_pham ( [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES ( 7000, N'https://bookingquangcao.com.vn/upload/images/tien-phong-logo.jpg', N'Tiền Phong là một nhật báo hàng đầu nước ta. Nó được thành lập trong Chiến tranh Đông Dương', N'Tiền phong')
INSERT [dbo].san_pham ( [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES ( 9000, N'https://docbao.nhandan.vn/upload/item/33571/143c3b9cd25eae5d0b56bfbc41548633.jpg', N'Báo thời nay là loại báo cập nhật thông tin mới nhất', N'Thời nay')
INSERT [dbo].san_pham ( [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES ( 10000, N'https://static.tuoitre.vn/tto/r/2015/08/26/trang-1-to-bao-chu-nhat-1440551296.jpg', N'báo nụ cười hiha', N'Báo nụ cười')


select * from san_pham
