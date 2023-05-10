package com.iuh.se.BanDoGiaDung.controller;

import org.springframework.context.annotation.Conditional;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Demo {

	@GetMapping(value = "/home", consumes = MediaType.ALL_VALUE)
	public String demo() {
		return "PageChinh";
	}

	@GetMapping(value = "/quanlyhoadon", consumes = MediaType.ALL_VALUE)
	public String DemoQuanLyHoaDon() {
		return "PageQuanLyHoaDon";
	}

	@GetMapping(value = "/chitietSanPham", consumes = MediaType.ALL_VALUE)
	public String DemoQuanLyChiTiet() {
		return "PageChiTietSanPham";
	}
}
