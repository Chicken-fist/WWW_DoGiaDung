package com.iuh.se.BanDoGiaDung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iuh.se.BanDoGiaDung.entity.ChiTietDonHang;
import com.iuh.se.BanDoGiaDung.service.ChiTietDonHangService;
import com.iuh.se.BanDoGiaDung.service.DonHangService;
import com.iuh.se.BanDoGiaDung.service.SanPhamService;

@RestController
@RequestMapping("/api")
public class ChiTietDonHangController {

	@Autowired
	private ChiTietDonHangService chiTietDonHangService;
	
	@Autowired
	private DonHangService donHangService;
	
	@Autowired
	private SanPhamService sanPhamService;

	public ChiTietDonHangController(ChiTietDonHangService chiTietDonHangService, DonHangService donHangService,
			SanPhamService sanPhamService) {
		super();
		this.chiTietDonHangService = chiTietDonHangService;
		this.donHangService = donHangService;
		this.sanPhamService = sanPhamService;
	}

	@GetMapping("/chitietdonhang")
	public List<ChiTietDonHang> layDSDonHang(){
		return chiTietDonHangService.layDSChiTietDonHang();
	}

	@PutMapping(value = "/chitietdonhang", consumes = MediaType.ALL_VALUE)
	public ChiTietDonHang luuChiTietDonHan1(@RequestBody ChiTietDonHang chiTietDonHang) {
		return chiTietDonHangService.luuChitietDonHang(chiTietDonHang);
	}
}
