package com.iuh.se.BanDoGiaDung.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iuh.se.BanDoGiaDung.dto.GioHangDto;
import com.iuh.se.BanDoGiaDung.entity.Users;
import com.iuh.se.BanDoGiaDung.service.DonHangService;
import com.iuh.se.BanDoGiaDung.service.GioHangService;
import com.iuh.se.BanDoGiaDung.service.UsersService;

@Controller
public class GioHangController {
	@Autowired
	private GioHangService gioHangService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private DonHangService donHangService;
//	public GioHangController(GioHangService gioHangService) {
//		super();
//		this.gioHangService = gioHangService;
//	}

	@GetMapping( value = "/giohang", consumes = MediaType.ALL_VALUE)
	public List<GioHangDto> layDSGioHang(){
		return gioHangService.layDSGioHang();
	}
	
	@PostMapping(value = "/giohang", consumes = MediaType.ALL_VALUE)
	public void luuGioHang(@RequestBody GioHangDto gioHangDto) {
		 gioHangService.luuGioHang(gioHangDto);
	}
	
	@DeleteMapping("/giohang/{gioHangId}")
	public String xoaGioHang(@PathVariable int  gioHangId) {
		return gioHangService.xoaGioHang(gioHangId);
	}
	
	@GetMapping("/giohang/{gioHangId}")
	public String layGioHangTheoID(@PathVariable int gioHangId , Model theModel, Principal principal) {
		Users users = usersService.getByUsername(principal.getName());
		GioHangDto gioHangDtos=  gioHangService.layGioHangTheoId(gioHangId);
//		DonHangDTO donHangDTO= donHangService.layDonHangTheoId(gioHangId);
		theModel.addAttribute("usersId", users.getId());
		theModel.addAttribute("giohangId",gioHangDtos );
		return "PageGioHang";
	}
	
	
	
}
