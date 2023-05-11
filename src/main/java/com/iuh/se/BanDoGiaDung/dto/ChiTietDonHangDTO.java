package com.iuh.se.BanDoGiaDung.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietDonHangDTO {
	private int madonHang;
	private int maSanPham;
	private String tenSanPham;
	private Date ngayDatSanPham;
	private double donGia;
	private int soLuong;
	private double thanhTien;

	
	

	
}
