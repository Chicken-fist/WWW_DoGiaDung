package com.iuh.se.BanDoGiaDung.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.se.BanDoGiaDung.convert.NhanVienConvert;
import com.iuh.se.BanDoGiaDung.dto.NhanVienDto;
import com.iuh.se.BanDoGiaDung.entity.NhanVien;
import com.iuh.se.BanDoGiaDung.repository.NhanVienRepository;
import com.iuh.se.BanDoGiaDung.service.NhanVienService;

@Service
public class NhanVienServiceImpl implements NhanVienService {

	@Autowired
	private NhanVienRepository nhanVienRepository;

	@Autowired
	private NhanVienConvert nhanVienConvert;

	@Autowired
	public NhanVienServiceImpl(NhanVienRepository nhanVienRepository) {
		super();
		this.nhanVienRepository = nhanVienRepository;
	}

	@Override
	public NhanVienDto layNhanVienTheoid(int id) {
		NhanVien nhanVien = nhanVienRepository.findById(id).orElse(null);
		if (Objects.isNull(nhanVien)) {
			return null;
		}
		return nhanVienConvert.tonhanVienDto(nhanVien);
	}

}
