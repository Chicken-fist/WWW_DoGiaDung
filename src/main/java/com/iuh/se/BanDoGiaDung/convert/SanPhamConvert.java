package com.iuh.se.BanDoGiaDung.convert;

import org.springframework.stereotype.Component;

import com.iuh.se.BanDoGiaDung.dto.SanPhamDto;
import com.iuh.se.BanDoGiaDung.entity.SanPham;

@Component
public class SanPhamConvert {
	
	public SanPham chuyenSanPhamEntity(SanPhamDto sanPhamDto) {
		SanPham sanPham = new SanPham();
		
		if(sanPhamDto.getId() != 0) {
			sanPham.setId(sanPhamDto.getId());
		}
		
		sanPham.setTenSanPham(sanPhamDto.getTenSanPham());
		sanPham.setHinhAnh(sanPhamDto.getHinhAnh());
		sanPham.setDonGia(sanPhamDto.getDonGia());
		sanPham.setMoTa(sanPhamDto.getMoTa());		
		return sanPham;
	}
	
	public  SanPhamDto chuyenSanPhamDto(SanPham sanPham) {
		SanPhamDto sanPhamDto = new SanPhamDto();
		
		if(sanPham.getId() != 0) {
			sanPhamDto.setId(sanPham.getId());
		}
		sanPhamDto.setTenSanPham(sanPham.getTenSanPham());
		sanPhamDto.setHinhAnh(sanPham.getHinhAnh());
		sanPhamDto.setDonGia(sanPham.getDonGia());
		sanPhamDto.setMoTa(sanPham.getMoTa());		
		return sanPhamDto;
	}
}
