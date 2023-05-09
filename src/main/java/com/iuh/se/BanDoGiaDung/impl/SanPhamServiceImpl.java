package com.iuh.se.BanDoGiaDung.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.se.BanDoGiaDung.convert.SanPhamConvert;
import com.iuh.se.BanDoGiaDung.dto.SanPhamDto;
import com.iuh.se.BanDoGiaDung.entity.SanPham;
import com.iuh.se.BanDoGiaDung.repository.SanPhamRepository;
import com.iuh.se.BanDoGiaDung.service.SanPhamService;

@Service
public class SanPhamServiceImpl implements SanPhamService {

	@Autowired
	private SanPhamRepository sanPhamRepository;
	
	@Autowired
	private SanPhamConvert sanPhamConvert;
//	@Autowired
//	public SanPhamServiceImpl(SanPhamRepository SanPhamRepository) {
//		super();
//		this.SanPhamRepository = SanPhamRepository;
//	}

	@Override
	public List<SanPhamDto> layDSSanPham() {

		List<SanPham> sanPhams = sanPhamRepository.findAll();
		System.out.println(sanPhams);
		List<SanPhamDto> sanPhamDtos = new ArrayList<SanPhamDto>();

		for (SanPham sanPham : sanPhams) {
			if (Objects.isNull(sanPham)) {
				return null;
			}
			SanPhamDto sanPhamdto = sanPhamConvert.chuyenSanPhamDto(sanPham);
			sanPhamDtos.add(sanPhamdto);
		}
		return sanPhamDtos;
	}

	@Override
	public SanPhamDto laySanPhamTheoID(int id) {
		SanPham SanPham = sanPhamRepository.findById(id).orElse(null);
		if (Objects.isNull(SanPham)) {
			return null;
		}
		return sanPhamConvert.chuyenSanPhamDto(SanPham);

	}

	@Override
	public String xoaSanPham(int id) {
		sanPhamRepository.deleteById(id);
		return "xóa thành công ";
	}

	@Override
	public SanPhamDto luuSanPham(SanPhamDto SanPhamDto) {

		SanPham SanPham = sanPhamConvert.chuyenSanPhamEntity(SanPhamDto);
		SanPham = sanPhamRepository.save(SanPham);
		return sanPhamConvert.chuyenSanPhamDto(SanPham);

	}

	@Override
	public List<SanPhamDto> timSanPhamTheoTen(String keyword) {
		List<SanPhamDto> SanPhamDtos = new ArrayList<SanPhamDto>();
		List<SanPham> SanPhams = sanPhamRepository.findAllByTenSanPham(keyword);
		for (SanPham SanPham : SanPhams) {
			SanPhamDto sanPhamDto = sanPhamConvert.chuyenSanPhamDto(SanPham);
			SanPhamDtos.add(sanPhamDto);
		}
		return SanPhamDtos;
	}

}
