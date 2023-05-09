package com.iuh.se.BanDoGiaDung.convert;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iuh.se.BanDoGiaDung.dto.ChiTietGioHangDto;
import com.iuh.se.BanDoGiaDung.dto.GioHangDto;
import com.iuh.se.BanDoGiaDung.entity.ChiTietGioHang;
import com.iuh.se.BanDoGiaDung.entity.GioHang;
import com.iuh.se.BanDoGiaDung.entity.SanPham;
import com.iuh.se.BanDoGiaDung.service.KhachHangService;

@Component
public class GioHangConvert {
	@Autowired
	private KhachHangService khachHangService;
	
	@Autowired
	private KhachHangConvert khachHangConvert;
	
	@Autowired
	private ChiTietGioHangConvert chiTietGioHangConvert;

	public GioHang chuyenGioHangEntity(GioHangDto gioHangDto) {
		GioHang gioHang = new GioHang();
		if (gioHangDto.getId() != 0) {
			gioHang.setid(gioHangDto.getId());
		}
		gioHang.setKhachHang(khachHangConvert
				.chuyenKhachHangEntity(khachHangService.layKhachHangTheoId(gioHangDto.getKhachHangId())));
		gioHang.setNgayTaoGioHang(gioHangDto.getNgayTaoGioHang());
		Set<ChiTietGioHang> chiTietGioHangs = new HashSet<ChiTietGioHang>();
		gioHang.setDsChiTietGioHang(chiTietGioHangs);
		return gioHang;
	}

	
	
	public GioHangDto chuyenGioHangDto(GioHang gioHang ,List<SanPham> baos2) {
		GioHangDto gioHangDto = GioHangDto.builder()
				.khachHangId(gioHang.getKhachHang().getid())
				.ngayTaoGioHang(gioHang.getNgayTaoGioHang())
				.build();
		
		if (gioHang.getid() != 0) {
			gioHangDto.setId(gioHang.getid());
		}
		
		Set<ChiTietGioHangDto> chiTietGioHangDtos = new HashSet<ChiTietGioHangDto>();
		gioHang.getDsChiTietGioHang().forEach(a -> {
			chiTietGioHangDtos.add(chiTietGioHangConvert.chuyenChiTietGioHangDto(a,baos2));
		});
		gioHangDto.setChiTietGioHang(chiTietGioHangDtos);
		return gioHangDto;
	}
}
