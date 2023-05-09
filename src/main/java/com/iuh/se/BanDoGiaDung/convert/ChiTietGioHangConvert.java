package com.iuh.se.BanDoGiaDung.convert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iuh.se.BanDoGiaDung.dto.ChiTietGioHangDto;
import com.iuh.se.BanDoGiaDung.dto.GioHangDto;
import com.iuh.se.BanDoGiaDung.dto.SanPhamDto;
import com.iuh.se.BanDoGiaDung.entity.ChiTietGioHang;
import com.iuh.se.BanDoGiaDung.entity.ChiTietGioHangPk;
import com.iuh.se.BanDoGiaDung.entity.SanPham;
import com.iuh.se.BanDoGiaDung.service.GioHangService;
import com.iuh.se.BanDoGiaDung.service.SanPhamService;

@Component
public class ChiTietGioHangConvert {

	@Autowired
	private SanPhamConvert sanPhamConvert;
	
	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private GioHangConvert gioHangConvert;

	@Autowired
	private GioHangService gioHangService;

	public ChiTietGioHang chuyenChiTietGioHangEntity(ChiTietGioHangDto chiTietGioHangDto) {
		ChiTietGioHang chiTietGioHang = new ChiTietGioHang();
		
		
		
		SanPhamDto baoDto = sanPhamService.laySanPhamTheoID(chiTietGioHangDto.getBaoId());
		chiTietGioHang.setSanPham(sanPhamConvert.chuyenSanPhamEntity(baoDto));
		
		GioHangDto gioHangDto = gioHangService.layGioHangTheoId(chiTietGioHangDto.getGioHangId());
		chiTietGioHang.setGioHang(gioHangConvert.chuyenGioHangEntity(gioHangDto));
		
	
		ChiTietGioHangPk chiTietGioHangPk = new ChiTietGioHangPk(chiTietGioHangDto.getBaoId(), chiTietGioHangDto.getGioHangId());
		
				chiTietGioHang.setId(chiTietGioHangPk);
		
		chiTietGioHang.setNgayDatSanPham(chiTietGioHangDto.getNgayDatBao());
		chiTietGioHang.setSoLuong(chiTietGioHangDto.getSoLuong());
		
		
		return chiTietGioHang;
	}

	public ChiTietGioHangDto chuyenChiTietGioHangDto(ChiTietGioHang chiTietGioHang, List<SanPham>  baos2) {
		ChiTietGioHangDto chiTietGioHangDto = new ChiTietGioHangDto();
		
		ChiTietGioHangPk chiTietGioHangPk = new ChiTietGioHangPk(chiTietGioHang.getSanPham().getId(), chiTietGioHang.getGioHang().getid());
		chiTietGioHangDto.setId(chiTietGioHangPk);
		
		chiTietGioHangDto.setBaoId(chiTietGioHang.getSanPham().getId());
		chiTietGioHangDto.setGioHangId(chiTietGioHang.getGioHang().getid());
		chiTietGioHangDto.setNgayDatBao(chiTietGioHang.getNgayDatSanPham());
		chiTietGioHangDto.setSoLuong(chiTietGioHang.getSoLuong());
		
		chiTietGioHangDto.setDonGia(chiTietGioHang.getSanPham().getDonGia());
		chiTietGioHangDto.setTenBao(chiTietGioHang.getSanPham().getTenSanPham());
		chiTietGioHangDto.setThanhTien(chiTietGioHang.getSanPham().getDonGia()*chiTietGioHang.getSoLuong());
		
		return chiTietGioHangDto;

	}
}
