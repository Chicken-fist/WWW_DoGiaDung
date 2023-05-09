package com.iuh.se.BanDoGiaDung.service;

import java.util.List;

import com.iuh.se.BanDoGiaDung.entity.ChiTietDonHang;
import com.iuh.se.BanDoGiaDung.entity.ChiTietDonHangPk;

public interface ChiTietDonHangService {

	public List<ChiTietDonHang> layDSChiTietDonHang();
	public ChiTietDonHang layChiTietDonHangTheoid(ChiTietDonHangPk id);
	public String XoaChiTietDonHang(ChiTietDonHang id );
	public ChiTietDonHang luuChitietDonHang(ChiTietDonHang chiTietDonHang);
}
