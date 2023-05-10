package com.iuh.se.BanDoGiaDung.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iuh.se.BanDoGiaDung.dto.DonHangDTO;
import com.iuh.se.BanDoGiaDung.service.DonHangService;
import com.iuh.se.BanDoGiaDung.service.UsersService;

@RestController
public class DonHangControllerTest {

	@Autowired
	private DonHangService donHangService;
	@Autowired
	private UsersService usersService;
	
	@GetMapping(value = "/donhang1", consumes = MediaType.ALL_VALUE)
	public List<DonHangDTO> layDonHang() {
		return donHangService.layDSDonHang();

	}
	@PostMapping(value = "/donhang2", consumes = MediaType.ALL_VALUE)
	public Integer luuDonHang(@RequestBody DonHangDTO donHangDTO, Principal principal) {
		System.out.println(donHangDTO);
		return donHangService.luuDonHang(donHangDTO,principal);
	}

	@GetMapping("/donhang/{donHangId}")
	public DonHangDTO layDonHangTheoId(@PathVariable int donHangId) {
		DonHangDTO donHangDTO = donHangService.layDonHangTheoId(donHangId);
		return donHangDTO;
	}
}
