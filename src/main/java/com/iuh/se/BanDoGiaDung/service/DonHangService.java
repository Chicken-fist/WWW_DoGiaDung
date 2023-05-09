package com.iuh.se.BanDoGiaDung.service;

import java.security.Principal;
import java.util.List;

import com.iuh.se.BanDoGiaDung.dto.DonHangDTO;

public interface DonHangService {
	public List<DonHangDTO> layDSDonHang();
	public DonHangDTO layDonHangTheoId(int id);
	public String xoaDonHang(int id);
	public Integer luuDonHang(DonHangDTO donHangDTO, Principal principal);
	List<DonHangDTO> finddonhang(int year, int month, int day);
	void suaDonHang(DonHangDTO donHangDTO, int madonhang);
	
}
