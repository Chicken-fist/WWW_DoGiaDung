package com.iuh.se.BanDoGiaDung.convert;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iuh.se.BanDoGiaDung.dto.ChiTietDonHangDTO;
import com.iuh.se.BanDoGiaDung.dto.DonHangDTO;
import com.iuh.se.BanDoGiaDung.entity.ChiTietDonHang;
import com.iuh.se.BanDoGiaDung.entity.DonHang;
import com.iuh.se.BanDoGiaDung.entity.KhachHang;
import com.iuh.se.BanDoGiaDung.service.KhachHangService;
import com.iuh.se.BanDoGiaDung.service.KhuyenMaiService;

@Component
public class DonHangConvert {
	@Autowired
	private KhachHangService khachHangService;
	
	@Autowired
	private KhachHangConvert khachHangConvert;
	
	@Autowired
	private KhuyenMaiConvert khuyenMaiConvert;
	
	@Autowired
	private KhuyenMaiService khuyenMaiService;
	
	@Autowired
	private ChiTietDonHangConvert chiTietDonHangConvert;
	
	private double tongThanhTien;

	public DonHang chuyendonHangEntity(DonHangDTO donHangDTO) {

		DonHang donHang = new DonHang();
		if (donHangDTO.getId() != 0) {
			donHang.setid(donHangDTO.getId());
		}
		KhachHang khachHang = khachHangConvert
				.chuyenKhachHangEntity(khachHangService.layKhachHangTheoId(donHangDTO.getMaKhachHang()));
		donHang.setKhachHang(khachHang);
		donHang.setKhuyenMai(khuyenMaiConvert
				.chuyenKhuyenMaiEntity(khuyenMaiService.layKhuyenMaiTheoid(donHangDTO.getMaKhuyenMai())));
		donHang.setNgayTaoDonHang(donHangDTO.getNgayTaoDonHang());
		donHang.setTrangThaiDonHang(donHangDTO.getTrangThaiDonHang());
		donHang.setDiaChiNhanHang(donHangDTO.getDiaChiNhanHang());
		donHang.setTongTienDonHang(donHangDTO.getTongTienDonHang());
		donHang.setHinhThucThanhToan(donHangDTO.getHinhThucThanhToan());
//		donHang.setChiTietDonHang(chiTietDonHangConvert.chuyenChiTietDonHangEntity(donHangDTO.getChiTietDonHang()));
//		donHang.setChiTietDonHang(null);
		Set<ChiTietDonHang> chiTietDonHangs = new HashSet<ChiTietDonHang>();
//		donHangDTO.getChiTietDonHang().forEach(a->{
//			chiTietDonHangs.add( chiTietDonHangConvert.chuyenChiTietDonHangEntity(a));
//			
//		});
		donHang.setChiTietDonHang(chiTietDonHangs);

		return donHang;
	}

	public DonHangDTO chuyendonHangDTO(DonHang donHang) {
		tongThanhTien = 0;
		donHang.getChiTietDonHang().forEach(a -> {
			ChiTietDonHangDTO chiTietDonHangDTO = chiTietDonHangConvert.chuyenChiTietDonHangDto(a);
			tongThanhTien += chiTietDonHangDTO.getThanhTien();
		}

		);

		DonHangDTO donHangDTO = DonHangDTO.builder().maKhachHang(donHang.getKhachHang().getid())
				.tenKhachHang(donHang.getKhachHang().getHoTen()).SDT(donHang.getKhachHang().getSDT())
				.maKhuyenMai(donHang.getKhuyenMai().getid()).tenKhuyenMai(donHang.getKhuyenMai().getTenKhuyenMai())
				.ngayTaoDonHang(donHang.getNgayTaoDonHang()).trangThaiDonHang(donHang.getTrangThaiDonHang())
				.diaChiNhanHang(donHang.getDiaChiNhanHang()).tongThanhTien(tongThanhTien)
				.tongTienDonHang(tongThanhTien - donHang.getKhuyenMai().getGiaTriGiam())
				.hinhThucThanhToan(donHang.getHinhThucThanhToan()).giaTriGiam(donHang.getKhuyenMai().getGiaTriGiam())
				.build();

		if (donHang.getid() != 0) {
			donHangDTO.setId(donHang.getid());
		}

		Set<ChiTietDonHangDTO> chiTietDonHangDTOs = new HashSet<ChiTietDonHangDTO>();
		donHang.getChiTietDonHang().forEach(a -> {
			chiTietDonHangDTOs.add(chiTietDonHangConvert.chuyenChiTietDonHangDto(a));

		});
		donHangDTO.setChiTietDonHang(chiTietDonHangDTOs);
		return donHangDTO;
	}
}