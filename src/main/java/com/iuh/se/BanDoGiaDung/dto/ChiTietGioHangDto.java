package com.iuh.se.BanDoGiaDung.dto;

import java.util.Date;

import com.iuh.se.BanDoGiaDung.entity.ChiTietGioHangPk;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChiTietGioHangDto {
	private ChiTietGioHangPk id;
	private int gioHangId;
	private int sanPhamId;
	private Date ngayDatSanPham;
	private Date ngaytKetThucDatSanPham;
	private int soLuong;
	private int soKy;
	private double donGia;
	private String tenSanPham;
	private double thanhTien;
	
}
