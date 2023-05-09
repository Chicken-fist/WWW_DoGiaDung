package com.iuh.se.BanDoGiaDung.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.se.BanDoGiaDung.convert.ChiTietGioHangConvert;
import com.iuh.se.BanDoGiaDung.dto.ChiTietGioHangDto;
import com.iuh.se.BanDoGiaDung.entity.ChiTietGioHang;
import com.iuh.se.BanDoGiaDung.entity.ChiTietGioHangPk;
import com.iuh.se.BanDoGiaDung.repository.ChiTietGioHangRepository;
import com.iuh.se.BanDoGiaDung.service.ChiTietDonHangService;
import com.iuh.se.BanDoGiaDung.service.ChiTietGioHangService;
import com.iuh.se.BanDoGiaDung.service.SanPhamService;

@Service
public class ChiTietGioHangServiceImpl implements ChiTietGioHangService{
	
	@Autowired
	private ChiTietGioHangRepository chiTietGioHangRepository;
	
	@Autowired
	private SanPhamService sanPhamService;
	@Autowired
	private ChiTietGioHangConvert chiTietGioHangConvert;
	

	@Override
	public List<ChiTietGioHangDto> layDSChiTietGioHang() {
		
		List<ChiTietGioHang> chiTietGioHangs =  chiTietGioHangRepository.findAll();
		List<ChiTietGioHangDto> chiTietGioHangDtos = new ArrayList<ChiTietGioHangDto>();
		
		for (ChiTietGioHang chiTietGioHang : chiTietGioHangs) {
			 if (Objects.isNull(chiTietGioHang)) {
		            return null;
		        }
//			 ChiTietGioHangDto chiTietGioHangDto = chiTietGioHangConvert.chuyenChiTietGioHangDto(chiTietGioHang);
//		chiTietGioHangDtos.add(chiTietGioHangDto);
		}
		return chiTietGioHangDtos;
	}

	@Override
	public ChiTietGioHangDto layChiTietGioHangTheoId(int id) {
		return null;
	}

//	@Override
//	public String xoaChiTietGioHang(int productId) {
//		BaoDto layId= baoService.layBaoTheoID(productId);
//		
//		chiTietGioHangRepository.deleteById(productId);
//		return "xoá sản phẩm có mã :" +productId;
//	}

	@Override
	public ChiTietGioHangDto luuChiTietGioHang(ChiTietGioHangDto chiTietGioHangDto) {
		ChiTietGioHang chiTietGioHang = chiTietGioHangConvert.chuyenChiTietGioHangEntity(chiTietGioHangDto);
		chiTietGioHang= chiTietGioHangRepository.save(chiTietGioHang);
		return null;
//		return chiTietGioHangConvert.chuyenChiTietGioHangDto(chiTietGioHang);
	}

	
	@Override
	public String xoaChiTietGioHang(ChiTietGioHangPk chiTietGioHangId) {
		
		return "xoá thành công";
	}

	


}
