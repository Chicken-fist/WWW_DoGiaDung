package com.iuh.se.BanDoGiaDung.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KhachHangDto extends AbstractDTO{

	private String tenKhachHang;
	private String SDT;
	private String email;
	private String matKhau;
	private int maUser;
	
}
