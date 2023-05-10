package com.iuh.se.BanDoGiaDung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.iuh.se.BanDoGiaDung.dto.SanPhamDto;
import com.iuh.se.BanDoGiaDung.service.SanPhamService;


@RestController
public class SanPham1TestController {
	
	@Autowired
	private SanPhamService sanPhamService;
	
	@GetMapping(value = "/SanPham/{tenSanPham}",consumes = MediaType.ALL_VALUE)
	public List<SanPhamDto> laySanPhamTheoTen(@PathVariable String tenSanPham) {
		return  sanPhamService.timSanPhamTheoTen(tenSanPham);

	}
}
