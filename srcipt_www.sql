USE [QuanLyDoGiaDung]
GO
/****** Object:  Table [dbo].[chi_tiet_don_hang]    Script Date: 09/05/2023 7:45:21 CH ******/
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
ALTER AUTHORIZATION ON [dbo].[chi_tiet_don_hang] TO  SCHEMA OWNER 
GO
/****** Object:  Table [dbo].[chi_tiet_gio_hang]    Script Date: 09/05/2023 7:45:21 CH ******/
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
ALTER AUTHORIZATION ON [dbo].[chi_tiet_gio_hang] TO  SCHEMA OWNER 
GO
/****** Object:  Table [dbo].[don_hang]    Script Date: 09/05/2023 7:45:21 CH ******/
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
ALTER AUTHORIZATION ON [dbo].[don_hang] TO  SCHEMA OWNER 
GO
/****** Object:  Table [dbo].[gio_hang]    Script Date: 09/05/2023 7:45:21 CH ******/
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
ALTER AUTHORIZATION ON [dbo].[gio_hang] TO  SCHEMA OWNER 
GO
/****** Object:  Table [dbo].[khach_hang]    Script Date: 09/05/2023 7:45:21 CH ******/
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
ALTER AUTHORIZATION ON [dbo].[khach_hang] TO  SCHEMA OWNER 
GO
/****** Object:  Table [dbo].[khuyen_mai]    Script Date: 09/05/2023 7:45:21 CH ******/
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
ALTER AUTHORIZATION ON [dbo].[khuyen_mai] TO  SCHEMA OWNER 
GO
/****** Object:  Table [dbo].[nhan_vien]    Script Date: 09/05/2023 7:45:21 CH ******/
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
ALTER AUTHORIZATION ON [dbo].[nhan_vien] TO  SCHEMA OWNER 
GO
/****** Object:  Table [dbo].[san_pham]    Script Date: 09/05/2023 7:45:21 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
ALTER AUTHORIZATION ON [dbo].[san_pham] TO  SCHEMA OWNER 
GO
/****** Object:  Table [dbo].[users]    Script Date: 09/05/2023 7:45:21 CH ******/
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
ALTER AUTHORIZATION ON [dbo].[users] TO  SCHEMA OWNER 
GO
SET IDENTITY_INSERT [dbo].[khach_hang] ON 

INSERT [dbo].[khach_hang] ([id], [sdt], [email], [ho_ten], [users_id]) VALUES (1, N'0654856123', N'nora123456@gmail.com', N'Nguyen Van Tan', 1)
INSERT [dbo].[khach_hang] ([id], [sdt], [email], [ho_ten], [users_id]) VALUES (2, N'0123456789', N'wilson@gmail.com', N'Tran Duc Nghia', 2)
INSERT [dbo].[khach_hang] ([id], [sdt], [email], [ho_ten], [users_id]) VALUES (3, N'0885465123', N'cuong123@gmail.com', N'Lam Duc Cuong', 5)
SET IDENTITY_INSERT [dbo].[khach_hang] OFF
GO
SET IDENTITY_INSERT [dbo].[nhan_vien] ON 

INSERT [dbo].[nhan_vien] ([id], [sdt], [dia_chi], [ten_nhan_vien], [users_id]) VALUES (1, N'0546213588', N'TPHCM', N'Hoang Hoa Thuan', 3)
INSERT [dbo].[nhan_vien] ([id], [sdt], [dia_chi], [ten_nhan_vien], [users_id]) VALUES (2, N'0855654213', N'TPHCM', N'NguyenChi Quoc Dang', 4)
SET IDENTITY_INSERT [dbo].[nhan_vien] OFF
GO
SET IDENTITY_INSERT [dbo].[san_pham] ON 

INSERT [dbo].[san_pham] ([id], [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES (1, 1000000, N'https://vcdn-giadinh.vnecdn.net/2021/02/05/1-1612520099-1612520123-1798-1612520134.jpg', N'Bộ nồi Nagakawa với 3 kích thước, thỏa sức sáng tạo các bữa ăn cho gia đình.', N'Bộ nồi Nagakawa')
INSERT [dbo].[san_pham] ([id], [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES (2, 1200000, N'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/n/o/noi-chien-khong-dau-xiaomi-mi-smart-air-fryer-1_2.jpg', N'Nồi chiên không dầu Xiaomi Mi Smart Air Fryer 3,5 lít chính hãng - Giá rẻ, chất lượng, độ bền cao.', N'Nồi chiên không dầu Xiaomi Mi Smart Air Fryer')
INSERT [dbo].[san_pham] ([id], [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES (3, 550000, N'https://cdn11.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture/Apro/Apro_product_25859/ban-ui-hoi-nuoc_main_133_450.png.webp', N'Với mặt đế bằng gốm chống dính, loại bỏ hiệu quả các nếp nhăn trên các chất liệu vải thông dụng', N'Bàn ủi hơi nước Electrolux ESI5116 1800W')
INSERT [dbo].[san_pham] ([id], [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES (4, 2490000, N'https://cdn11.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_32078/may-hut-bui-cam_main_948_1020.png.webp', N'Trọng lượng chỉ 3.59kg nhẹ nhàng,dây điện 6m cho phép bạn hút bụi ở mọi nơi trong nhà.', N'Máy Hút Bụi Cầm Tay Electrolux EDYL35OR')
INSERT [dbo].[san_pham] ([id], [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES (5, 399000, N'https://cdn11.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_25985/lo-nuong-comet-_main_733_1020.png.webp', N'Dùng để hâm nóng, rã đông thức ăn, nướng lượng nhỏ thực phẩm, gà nguyên con chặt góc tư, ...', N'Lò nướng Comet CM6510 10 lít')
INSERT [dbo].[san_pham] ([id], [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES (6, 6990000, N'https://cdn11.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_27519/bep-tu-am-elect_main_34_1020.png.webp', N'Bếp từ âm đôi Electrolux EHI7260BB 3200W - nổi bật với kiểu dáng bắt mắt cùng hiệu suất nấu ăn cao', N'Bếp từ âm đôi Electrolux EHI7260BB 3200W')
INSERT [dbo].[san_pham] ([id], [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES (7, 550000, N'https://cdn11.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_25485/noi-com-dien-to_main_593_1020.png.webp', N'Toshiba RC-10JFM(H)VN hệ thống tỏa nhiệt, đối lưu bao quang  truyền nhiệt đồng nhất làm cơm chín đều', N'Nồi Cơm Điện Toshiba RC-10JFM(H)VN 1 lít')
INSERT [dbo].[san_pham] ([id], [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES (8, 500000, N'https://cdn11.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_30017/quat-lung-duxto_main_742_1020.png.webp', N'Quạt lửng Duxton B4 DFTS40-15LN hoạt động êm ái tạo luồng gió mát khắp phòng', N'Quạt lửng Duxton B4 DFTS40-15LN')
INSERT [dbo].[san_pham] ([id], [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES (9, 9990000, N'https://cdn11.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_27474/may-loc-nuoc-no_main_495_1020.png.webp', N'MUTOSI MP-350D-BKQ có kiểu dáng dạng tủ đứng rất nhỏ gọn, không chiếm nhiều diện tích', N'Máy lọc nước nóng lạnh nguội Mutosi MP-350D-BKQ 8 lõi')
INSERT [dbo].[san_pham] ([id], [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES (10, 7590000, N'https://cdn11.dienmaycholon.vn/filewebdmclnew/public//userupload/images/may-loc-nuoc-nong-lanh-10-loi-sunhouse--slimbio-SHA76213CK-1.png', N'Thiết kế thon gọn phổ biến tại các đô thị lớn hiện nay.', N'Máy lọc nước R.O Sunhouse SHA88510K 10 lõi')
INSERT [dbo].[san_pham] ([id], [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES (12, 445000, N'https://cdn.tgdd.vn/Products/Images/1985/235885/ava-bl1055-cb-070921-022110-300x300.jpg', N'AVA BL1055-CB có thiết kế sang trọng, tiện dụng với 2 cối xay sinh tố và xay thực phẩm khô', N'Máy xay sinh tố đa năng AVA BL1055-CB')
INSERT [dbo].[san_pham] ([id], [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES (13, 19900000, N'https://cdn.tgdd.vn/Products/Images/10139/306067/21.jpg', N'Sạc khoảng 6.5 giờ với dung lượng pin khoảng 5200 mAh cho thời gian sử dụng khoảng 260 phút.', N'Robot hút bụi lau nhà Ecovacs Deebot T20 Omni DLX23 ')
INSERT [dbo].[san_pham] ([id], [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES (14, 2750000, N'https://cdn.tgdd.vn/Products/Images/7498/236017/puwa-ac-38ar-16-300x300-600x600.jpg', N'Quạt công suất 150W mạnh mẽ, làm mát hiệu quả trên diện tích rộng 20 - 35 m2', N'Quạt điều hòa Puwa AC-38AR ')
INSERT [dbo].[san_pham] ([id], [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES (15, 890000, N'https://cdn.tgdd.vn/Products/Images/2062/233451/ava-aj02-16-600x600.jpg', N'Máy ép trái cây thiết kế hiện đại, sang trọng, đẹp mắt trong không gian dùng', N'Máy ép trái cây AVA AJ02')
INSERT [dbo].[san_pham] ([id], [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES (16, 679000, N'https://cdn.tgdd.vn/Products/Images/1992/275528/vy3777901.jpg', N'Công suất 55W mạnh mẽ, 3 cánh quạt đường kính 40 cm tạo luồng gió rộng, làm mát hiệu quả.', N'Quạt treo Asia VY377790')
INSERT [dbo].[san_pham] ([id], [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES (17, 3990000, N'https://cdn.tgdd.vn/Products/Images/7498/219138/quat-dieu-hoa-rapido-9000d-201022-051707-600x600.jpg', N'Đi kèm quạt có 4 đá khô tăng hiệu quả làm mát trong ngày nắng nóng cao độ', N'Quạt điều hòa Rapido 9000D')
INSERT [dbo].[san_pham] ([id], [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES (18, 950000, N'https://cdn.tgdd.vn/Products/Images/1982/285114/ava-ai-32-1.-600x600.jpg', N'Tiện ích: 6 chế độ nấu cài đặt sẵn, 8 mức điều chỉnh công suất và nhiệt độ, hẹn giờ.', N'Bếp từ AVA AI-32 ')
INSERT [dbo].[san_pham] ([id], [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES (19, 350000, N'https://cdn.tgdd.vn/Products/Images/1989/89414/delites-st17db01-mau-den-281222-102609-600x600.jpg', N'Bình đun siêu tốc Delites kiểu dáng thanh lịch, dung tích lớn, an toàn khi dùng', N'Bình đun siêu tốc Delites 1.7 lít ST17DB01 Màu Đen')
INSERT [dbo].[san_pham] ([id], [don_gia], [hinh_anh], [mo_ta], [ten_san_pham]) VALUES (20, 2690000, N'https://cdn.tgdd.vn/Products/Images/2222/202937/midea-yd1518s-x-thumb-600x600.jpg', N'Cây nước nóng lạnh Midea với thiết kế sang trọng, nổi bật phù hợp đặt để trong mọi không gian sống', N'Cây nước nóng lạnh Midea YD1518S-X 498W')
SET IDENTITY_INSERT [dbo].[san_pham] OFF
GO
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([id], [password], [username]) VALUES (1, N'{bcrypt}$2a$10$qDoISw0uB8nBA9NxTNiQ3OJc4we58/VfYY0fm8pxln7qyH7fezjhO', N'customer1')
INSERT [dbo].[users] ([id], [password], [username]) VALUES (2, N'{bcrypt}$2a$10$qDoISw0uB8nBA9NxTNiQ3OJc4we58/VfYY0fm8pxln7qyH7fezjhO', N'customer2')
INSERT [dbo].[users] ([id], [password], [username]) VALUES (3, N'{bcrypt}$2a$10$qDoISw0uB8nBA9NxTNiQ3OJc4we58/VfYY0fm8pxln7qyH7fezjhO', N'hoathuan')
INSERT [dbo].[users] ([id], [password], [username]) VALUES (4, N'{bcrypt}$2a$10$qDoISw0uB8nBA9NxTNiQ3OJc4we58/VfYY0fm8pxln7qyH7fezjhO', N'quocdang')
INSERT [dbo].[users] ([id], [password], [username]) VALUES (5, N'{bcrypt}$2a$10$qDoISw0uB8nBA9NxTNiQ3OJc4we58/VfYY0fm8pxln7qyH7fezjhO', N'duccuong')
SET IDENTITY_INSERT [dbo].[users] OFF
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
