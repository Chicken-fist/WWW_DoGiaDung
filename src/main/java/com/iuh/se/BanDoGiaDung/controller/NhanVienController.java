package com.iuh.se.BanDoGiaDung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.iuh.se.BanDoGiaDung.dto.NhanVienDto;
import com.iuh.se.BanDoGiaDung.service.NhanVienService;

@RestController
public class NhanVienController {
	@Autowired
	private NhanVienService nhanVienService;

	@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
	@GetMapping("/nhanVien/{nhanVienId}")
	public NhanVienDto getCustomer(@PathVariable int nhanVienId) {
		NhanVienDto nhanVienDto = nhanVienService.layNhanVienTheoid(nhanVienId);
		return nhanVienDto;
	}

}
