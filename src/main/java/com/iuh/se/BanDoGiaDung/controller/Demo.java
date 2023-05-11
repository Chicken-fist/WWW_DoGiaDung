package com.iuh.se.BanDoGiaDung.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.iuh.se.BanDoGiaDung.dto.GioHangDto;
import com.iuh.se.BanDoGiaDung.dto.KhachHangDto;
import com.iuh.se.BanDoGiaDung.dto.SanPhamDto;
import com.iuh.se.BanDoGiaDung.entity.GioHang;
import com.iuh.se.BanDoGiaDung.entity.KhachHang;
import com.iuh.se.BanDoGiaDung.entity.Users;
import com.iuh.se.BanDoGiaDung.service.GioHangService;
import com.iuh.se.BanDoGiaDung.service.KhachHangService;
import com.iuh.se.BanDoGiaDung.service.SanPhamService;

@Controller
public class Demo {

	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private KhachHangService khachHangService;
	
	
	@GetMapping(value = "/home", consumes = MediaType.ALL_VALUE)
	public String demo(Model theModel) {
		List<SanPhamDto> sanPhams = sanPhamService.layDSSanPham();
		System.out.println(sanPhams);
		theModel.addAttribute("dsSanPham", sanPhams);
		return "PageChinh";
	}

	@GetMapping(value = "/showLoginPage", consumes = MediaType.ALL_VALUE)
	public String DemoQuanLyHoaDon() {
		return "PageLogin";
	}

	@GetMapping(value = "/register", consumes = MediaType.ALL_VALUE)
	public String DemoQuanLyChiTiet(Model model) {
		KhachHangDto khachHang = new KhachHangDto();
		model.addAttribute("khach_hang",khachHang);
		return "PageDangKy";
	}

	@PostMapping(value = "/dang-ky")
	public String register(@ModelAttribute("khach_hang") KhachHangDto khachHangDto) throws Exception {
		System.out.println(khachHangDto);
		KhachHangDto khachHang = khachHangService.themKhachHang(khachHangDto);
		
		return "PageLogin";
	}
	
}
