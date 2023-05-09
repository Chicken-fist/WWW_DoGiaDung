package com.iuh.se.BanDoGiaDung.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NhanVienDto extends AbstractDTO {
	private String tenNhanVien;

	private String SDT;

	private String diaChi;

	private String email;

	private String matKhau;
	


}
