package com.iuh.se.BanDoGiaDung.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.se.BanDoGiaDung.convert.KhachHangConvert;
import com.iuh.se.BanDoGiaDung.dto.KhachHangDto;
import com.iuh.se.BanDoGiaDung.entity.KhachHang;
import com.iuh.se.BanDoGiaDung.repository.KhachHangRepository;
import com.iuh.se.BanDoGiaDung.service.KhachHangService;

@Service
public class KhachHangServiceImpl implements KhachHangService {

	@Autowired
	private KhachHangRepository khachHangRepository;
	
	@Autowired
	private KhachHangConvert khachHangConvert;

	@Autowired
	public KhachHangServiceImpl(KhachHangRepository khachHangRepository) {
		super();
		this.khachHangRepository = khachHangRepository;
	}

	@Override
	public List<KhachHangDto> layDSKhachHang() {
		List<KhachHang> khachHangs = (List<KhachHang>) khachHangRepository.findAll();
		List<KhachHangDto> khachHangDtos = new ArrayList<KhachHangDto>();
		
		for (KhachHang khachHang : khachHangs) {
			 if (Objects.isNull(khachHang)) {
		            return null;
		        }
			 KhachHangDto khachHangdto = khachHangConvert.chuyenKhachHangDto(khachHang);
			khachHangDtos.add(khachHangdto);
		}
		return khachHangDtos;
		
	}
	
	@Override
	public KhachHangDto themKhachHang(KhachHangDto khachHangDto) {
		KhachHang khachHang = khachHangConvert.chuyenKhachHangEntity(khachHangDto);
		khachHang = khachHangRepository.save(khachHang);
		return khachHangConvert.chuyenKhachHangDto(khachHang);
	}
	
	@Override
	public KhachHangDto layKhachHangTheoId(int id) {
		KhachHang khachHang = khachHangRepository.findById(id).orElse(null);
		if(Objects.isNull(khachHang)) {
			return null;
		}
		return khachHangConvert.chuyenKhachHangDto(khachHang);
	}
	
	@Override
	public String xoaKhachHangTheoId(int id) {
		KhachHang khachHang = khachHangRepository.findById(id).orElse(null);
		if(Objects.isNull(khachHang)) {
			return null;
			
		}
		khachHangRepository.delete(khachHang);
		return "Xóa khách hàng thành công";
	}
	
	
	@Override
	public void suaKhachHang(int id, KhachHangDto khachHangDto) {
		KhachHang khachHang = khachHangConvert.chuyenKhachHangEntity(khachHangDto);
		khachHangRepository.save(khachHang);
	
	}
	

}
