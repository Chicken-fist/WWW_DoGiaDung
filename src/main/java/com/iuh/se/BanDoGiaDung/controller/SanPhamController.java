package com.iuh.se.BanDoGiaDung.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iuh.se.BanDoGiaDung.dto.KhuyenMaiDto;
import com.iuh.se.BanDoGiaDung.dto.SanPhamDto;
import com.iuh.se.BanDoGiaDung.entity.GioHang;
import com.iuh.se.BanDoGiaDung.entity.Users;
import com.iuh.se.BanDoGiaDung.repository.GioHangRepository;
import com.iuh.se.BanDoGiaDung.service.SanPhamService;
import com.iuh.se.BanDoGiaDung.service.UsersService;


@Controller
public class SanPhamController {
	
	@Autowired
	private SanPhamService sanPhamService;
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private GioHangRepository gioHangRepository;
	private String tenSanPham;

	@GetMapping(value = "/SanPham", consumes = MediaType.ALL_VALUE)
	public String danhSachSanPham(Model theModel, Principal principal) {
		List<SanPhamDto> sanPhams = sanPhamService.layDSSanPham();
		Users users = usersService.getByUsername(principal.getName());
		GioHang gioHang = gioHangRepository.TimByUsersId(users.getId());
		theModel.addAttribute("usersId", users.getId());
		if (users.getKhachHang() != null) {
			theModel.addAttribute("gioHangId", gioHang.getid());
		}
		theModel.addAttribute("ten", tenSanPham);
		theModel.addAttribute("dsSanPham", sanPhams);
		return "PageChinh";
	}

	@GetMapping(value = "/admin/SanPham/show", consumes = MediaType.ALL_VALUE)
	public String danhSachSanPham1(Model theModel) {
		List<SanPhamDto> SanPhams = sanPhamService.layDSSanPham();
		theModel.addAttribute("dsSanPham", SanPhams);
		return "PageQuanLySanPham";
	}

	@RequestMapping(value = "/chitietdatSanPham/{maSanPham}", method = RequestMethod.GET)
	public String laySanPhamTheoID(@PathVariable int maSanPham, Principal principal, Model theModel) {
		Users users = usersService.getByUsername(principal.getName());
		GioHang gioHang = gioHangRepository.TimByUsersId(users.getId());
		SanPhamDto SanPhamDto = sanPhamService.laySanPhamTheoID(maSanPham);
		List<SanPhamDto> SanPhamDtos = sanPhamService.layDSSanPham();
		theModel.addAttribute("SanPham1", SanPhamDto);
		theModel.addAttribute("SanPhams", SanPhamDtos);
		theModel.addAttribute("usersId", users.getId());
		if (users.getKhachHang() != null) {
			theModel.addAttribute("gioHangId", gioHang.getid());
		}
		return "PageChiTietSanPham";

	}

	@GetMapping("/admin/SanPham/put/{maSanPham}")
//	@RequestMapping(value = "/put/{maSanPham}")
	public String laySanPhamTheoid(@PathVariable int maSanPham, Model model) {
		SanPhamDto SanPhamDto = sanPhamService.laySanPhamTheoID(maSanPham);
		model.addAttribute("SanPham", SanPhamDto);
		return "PageThemSanPham";

	}

	@GetMapping("/admin/SanPham/put")
	public String laySanPhamTheoid(Model model) {
		KhuyenMaiDto khuyenMaiDto = new KhuyenMaiDto();
		SanPhamDto SanPhamDto = new SanPhamDto();
		model.addAttribute("SanPham", SanPhamDto);
		return "PageThemSanPham";
	}

	@PostMapping(value = "/admin/SanPham/addSanPham", consumes = MediaType.ALL_VALUE)
	public String luuSanPham(@ModelAttribute("SanPham") SanPhamDto SanPhamDto) {
		sanPhamService.luuSanPham(SanPhamDto);
		return "redirect:/admin/SanPham/show";
	}

	@PutMapping(value = "/SanPham", consumes = MediaType.ALL_VALUE)
	public SanPhamDto luuSanPham1(@RequestBody SanPhamDto SanPhamDto) {
		return sanPhamService.luuSanPham(SanPhamDto);
	}

	@RequestMapping(value = "/admin/SanPham/{maSanPham}")
	public String xoaSanPham(@PathVariable int maSanPham) {
		sanPhamService.xoaSanPham(maSanPham);
		return "redirect:/admin/SanPham/show";
	}

	@GetMapping(value = "/timkiem", consumes = MediaType.ALL_VALUE)
	public String search(Model model, @ModelAttribute("ten") String tenSanPham) {
		List<SanPhamDto> SanPhamDtos = new ArrayList<SanPhamDto>();

		SanPhamDtos = sanPhamService.timSanPhamTheoTen(tenSanPham);
		model.addAttribute("ten", tenSanPham);
		model.addAttribute("dsSanPham", SanPhamDtos);
		return "PageChinh";
	}
}
