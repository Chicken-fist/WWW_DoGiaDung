package com.iuh.se.BanDoGiaDung.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KhuyenMaiDto extends AbstractDTO {

	private String tenKhuyenMai;
	private double giaTriGiam;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayBatDau;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayHetHan;
	private int maNhanVien;
	private String tenNhanVien;

	public KhuyenMaiDto(int maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}

}
