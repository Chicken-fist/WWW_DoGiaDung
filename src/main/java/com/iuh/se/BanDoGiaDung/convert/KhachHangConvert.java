package com.iuh.se.BanDoGiaDung.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iuh.se.BanDoGiaDung.dto.KhachHangDto;
import com.iuh.se.BanDoGiaDung.entity.KhachHang;
import com.iuh.se.BanDoGiaDung.service.UsersService;

@Component
public class KhachHangConvert {
	@Autowired
	private UsersService usersService;
	 public KhachHang chuyenKhachHangEntity(KhachHangDto khachHangDto) {
		 KhachHang khachHang = new KhachHang();
		 if(khachHangDto.getId() != 0) {
			 khachHang.setid(khachHangDto.getId());
		 }
		 
		 khachHang.setHoTen(khachHangDto.getTenKhachHang());
		 khachHang.setEmail(khachHangDto.getEmail());
		 khachHang.setSDT(khachHangDto.getSDT());
		 khachHang.setUsers(usersService.findById(khachHangDto.getMaUser()));
//		 khachHang.setMatKhau(khachHangDto.getMatKhau());

		 return khachHang;
		 
	 }
	 
	 public KhachHangDto chuyenKhachHangDto(KhachHang khachHang) {
		 KhachHangDto khachHangDto = new KhachHangDto();
		 
		 if(khachHang.getid() != 0) {
			 khachHangDto.setId(khachHang.getid());
		 }
		 
		 khachHangDto.setTenKhachHang(khachHang.getHoTen());
		 khachHangDto.setEmail(khachHang.getEmail());
		 khachHangDto.setSDT(khachHang.getSDT());
		 khachHangDto.setMaUser(khachHang.getUsers().getId());
//		 khachHangDto.setMatKhau(khachHang.getMatKhau());
		 
		 return khachHangDto;
	 }
}