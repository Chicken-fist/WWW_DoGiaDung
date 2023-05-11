package com.iuh.se.BanDoGiaDung.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.iuh.se.BanDoGiaDung.convert.KhachHangConvert;
import com.iuh.se.BanDoGiaDung.dto.GioHangDto;
import com.iuh.se.BanDoGiaDung.dto.KhachHangDto;
import com.iuh.se.BanDoGiaDung.entity.KhachHang;
import com.iuh.se.BanDoGiaDung.entity.Users;
import com.iuh.se.BanDoGiaDung.repository.KhachHangRepository;
import com.iuh.se.BanDoGiaDung.repository.UsersRepository;
import com.iuh.se.BanDoGiaDung.service.GioHangService;
import com.iuh.se.BanDoGiaDung.service.KhachHangService;
import com.iuh.se.BanDoGiaDung.service.UsersService;

@Service
public class KhachHangServiceImpl implements KhachHangService {

	@Autowired
	private KhachHangRepository khachHangRepository;
	
	@Autowired
	private KhachHangConvert khachHangConvert;
	
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private GioHangService gioHangService;
	
	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	public KhachHangServiceImpl(KhachHangRepository khachHangRepository) {
		super();
		this.khachHangRepository = khachHangRepository;
	}

	@Override
	public List<KhachHangDto> layDSKhachHang() {
		List<KhachHang> khachHangs = (List<KhachHang>) khachHangRepository.findAll();
		List<KhachHangDto> khachHangDtos = new ArrayList<KhachHangDto>();
		
		for (KhachHang khachHang : khachHangs) {
			 if (Objects.isNull(khachHang)) {
		            return null;
		        }
			 KhachHangDto khachHangdto = khachHangConvert.chuyenKhachHangDto(khachHang);
			khachHangDtos.add(khachHangdto);
		}
		return khachHangDtos;
		
	}
	
	@Override
	public KhachHangDto themKhachHang(KhachHangDto khachHangDto) throws Exception {
		
		KhachHang khachHang = khachHangConvert.chuyenKhachHangEntity(khachHangDto);
		khachHang = khachHangRepository.save(khachHang);
		if (usersRepository.findByUsername(khachHang.getHoTen()).orElse(null) != null) {
			throw new Exception("User này đã tồn tại");
		}
		Users user = usersRepository.save(new Users(khachHang.getHoTen(),encoder.encode(khachHangDto.getMatKhau()) , khachHang));
		gioHangService.luuGioHang(new GioHangDto(new Date(), khachHang.getid(), null));
		khachHang.setUsers(user);
		khachHangRepository.save(khachHang);
		return khachHangConvert.chuyenKhachHangDto(khachHang);
	}
	
	@Override
	public KhachHangDto layKhachHangTheoId(int id) {
		KhachHang khachHang = khachHangRepository.findById(id).orElse(null);
		if(Objects.isNull(khachHang)) {
			return null;
		}
		return khachHangConvert.chuyenKhachHangDto(khachHang);
	}
	
	@Override
	public String xoaKhachHangTheoId(int id) {
		KhachHang khachHang = khachHangRepository.findById(id).orElse(null);
		if(Objects.isNull(khachHang)) {
			return null;
			
		}
		khachHangRepository.delete(khachHang);
		return "Xóa khách hàng thành công";
	}
	
	
	@Override
	public void suaKhachHang(int id, KhachHangDto khachHangDto) {
		KhachHang khachHang = khachHangConvert.chuyenKhachHangEntity(khachHangDto);
		khachHangRepository.save(khachHang);
	
	}
	

}
