package com.iuh.se.BanDoGiaDung.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iuh.se.BanDoGiaDung.dto.KhachHangDto;
import com.iuh.se.BanDoGiaDung.service.KhachHangService;


@Controller
@RequestMapping("/admin/khachHang")
public class KhachHangController {

	private KhachHangService khachHangService;
 
	public KhachHangController(KhachHangService khachHangService) {
		this.khachHangService = khachHangService;
	}

	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@GetMapping("/show")
	public String listKhachHang(Model theModel) {
		List<KhachHangDto> khachHangDtos = khachHangService.layDSKhachHang();
		theModel.addAttribute("khachHang",khachHangDtos);
		return "PageQuanLyKhachHang";
	}
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@PostMapping(value = "/addKhachHang", consumes = MediaType.ALL_VALUE)
	public String themKhachHang(@ModelAttribute("khachHang") KhachHangDto khachHangDto) throws Exception {
		 khachHangService.themKhachHang(khachHangDto);
		 return "redirect:/admin/khachHang/show";
	}
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@GetMapping("/put/{maKhachHang}")
	public String layKhachHangTheoId(@PathVariable int maKhachHang,Model model) {
		KhachHangDto khachHangDto = khachHangService.layKhachHangTheoId(maKhachHang);
		model.addAttribute("khachHang", khachHangDto);
		return "PageThemKhachHang";
	}

	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@RequestMapping(value = "/{maKhachHang}")
	public String xoaKhachHangTheoId(@PathVariable int maKhachHang) {
		 khachHangService.xoaKhachHangTheoId(maKhachHang);
		 return "redirect:/admin/khachHang/show";
	}
	


}
