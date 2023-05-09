package com.iuh.se.BanDoGiaDung.service;

import java.util.List;

import com.iuh.se.BanDoGiaDung.dto.ChiTietGioHangDto;
import com.iuh.se.BanDoGiaDung.entity.ChiTietGioHangPk;


public interface ChiTietGioHangService {
	public List<ChiTietGioHangDto> layDSChiTietGioHang();
	public String xoaChiTietGioHang(ChiTietGioHangPk chiTietGioHangId);

	public ChiTietGioHangDto layChiTietGioHangTheoId(int id);
	public ChiTietGioHangDto luuChiTietGioHang(ChiTietGioHangDto chiTietGioHangDto);
}
