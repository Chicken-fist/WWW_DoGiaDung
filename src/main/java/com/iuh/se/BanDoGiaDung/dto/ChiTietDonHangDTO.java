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
	private int mabao;
	private String tenBao;
	private Date ngayDatBao;
	private Date ngatKetThucDatBao;
	private double donGia;
	private int soLuong;
	private int soKy;
	private double thanhTien;

	
	

	
}
