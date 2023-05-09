package com.iuh.se.BanDoGiaDung.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iuh.se.BanDoGiaDung.dto.SanPhamDto;


@Service
public interface SanPhamService {
	public List<SanPhamDto> layDSSanPham();

	public SanPhamDto laySanPhamTheoID(int id);

	public String xoaSanPham(int id);

	public SanPhamDto luuSanPham(SanPhamDto sanPhamDto);

	List<SanPhamDto> timSanPhamTheoTen(String keyword);

	
	
}
