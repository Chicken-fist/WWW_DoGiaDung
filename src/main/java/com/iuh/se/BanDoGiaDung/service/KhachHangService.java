package com.iuh.se.BanDoGiaDung.service;

import java.util.List;

import com.iuh.se.BanDoGiaDung.dto.KhachHangDto;

public interface KhachHangService {
	public List<KhachHangDto> layDSKhachHang();

	public KhachHangDto themKhachHang(KhachHangDto khachHangDto) throws Exception;

	public KhachHangDto layKhachHangTheoId(int id);

	public String xoaKhachHangTheoId(int id);
	
	public void suaKhachHang( int id,KhachHangDto khachHangDto);
}
