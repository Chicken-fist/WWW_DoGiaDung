package com.iuh.se.BanDoGiaDung.convert;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iuh.se.BanDoGiaDung.dto.ChiTietDonHangDTO;
import com.iuh.se.BanDoGiaDung.dto.DonHangDTO;
import com.iuh.se.BanDoGiaDung.dto.SanPhamDto;
import com.iuh.se.BanDoGiaDung.entity.ChiTietDonHang;
import com.iuh.se.BanDoGiaDung.service.DonHangService;
import com.iuh.se.BanDoGiaDung.service.SanPhamService;

@Component
public class ChiTietDonHangConvert {
	@Autowired
	private SanPhamConvert sanPhamConvert;
	@Autowired
	private DonHangConvert donHangConvert;
	@Autowired
	private DonHangService donHangService;
	@Autowired
	private SanPhamService sanPhamService;

	public ChiTietDonHang chuyenChiTietDonHangEntity(ChiTietDonHangDTO chiTietDonHangDTO, int maDonHang) {
		ChiTietDonHang chiTietDonHang = new ChiTietDonHang();

		SanPhamDto baoDto = sanPhamService.laySanPhamTheoID(chiTietDonHangDTO.getMabao());
		chiTietDonHang.setSanPham(sanPhamConvert.chuyenSanPhamEntity(baoDto));
		DonHangDTO donHangDTO = donHangService.layDonHangTheoId(maDonHang);
		chiTietDonHang.setDonHang(donHangConvert.chuyendonHangEntity(donHangDTO));
		chiTietDonHang.setDonHang(chiTietDonHang.getDonHang());
		chiTietDonHang.setNgayDatHang(chiTietDonHangDTO.getNgayDatBao());
		chiTietDonHang.setSoLuong(chiTietDonHangDTO.getSoLuong());
		return chiTietDonHang;
	}

	public ChiTietDonHangDTO chuyenChiTietDonHangDto(ChiTietDonHang chiTietDonHang) {
		ChiTietDonHangDTO chiTietDonHangDTO = new ChiTietDonHangDTO();

		chiTietDonHangDTO.setMadonHang(chiTietDonHang.getDonHang().getid());
		chiTietDonHangDTO.setMabao(chiTietDonHang.getSanPham().getId());
		chiTietDonHangDTO.setTenBao(chiTietDonHang.getSanPham().getTenSanPham());
		chiTietDonHangDTO.setDonGia(chiTietDonHang.getSanPham().getDonGia());
		chiTietDonHangDTO.setNgayDatBao(chiTietDonHang.getNgayDatHang());

		chiTietDonHangDTO.setSoLuong(chiTietDonHang.getSoLuong());
		chiTietDonHangDTO.setThanhTien(
				chiTietDonHang.getSanPham().getDonGia() * chiTietDonHang.getSoLuong());

		return chiTietDonHangDTO;
	}
}