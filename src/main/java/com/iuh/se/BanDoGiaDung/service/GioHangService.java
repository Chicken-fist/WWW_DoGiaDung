package com.iuh.se.BanDoGiaDung.service;

import java.util.List;

import com.iuh.se.BanDoGiaDung.dto.GioHangDto;
import com.iuh.se.BanDoGiaDung.dto.XoaChiTietGioHangDto;

public interface GioHangService {
		public List<GioHangDto> layDSGioHang();
		public GioHangDto layGioHangTheoId(int id);
		public String  xoaGioHang(int id);
		public void luuGioHang(GioHangDto gioHangDto);
		public void themSanPhamVaoGioHang(GioHangDto gioHangDto);
		public void xoaChiTietGioHang(XoaChiTietGioHangDto xoaChiTietGioHangDto);
}
