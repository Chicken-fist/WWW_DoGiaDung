package com.iuh.se.BanDoGiaDung.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iuh.se.BanDoGiaDung.entity.ChiTietDonHang;
import com.iuh.se.BanDoGiaDung.entity.ChiTietDonHangPk;
import com.iuh.se.BanDoGiaDung.repository.ChiTietDonHangRepository;
import com.iuh.se.BanDoGiaDung.service.ChiTietDonHangService;

@Service
public class ChiTietDonHangImpl implements ChiTietDonHangService{

	private ChiTietDonHangRepository chiTietDonHangRepository;
	
	public ChiTietDonHangImpl(ChiTietDonHangRepository chiTietDonHangRepository) {
		super();
		this.chiTietDonHangRepository = chiTietDonHangRepository;
	}

	@Override
	public List<ChiTietDonHang> layDSChiTietDonHang() {
		return chiTietDonHangRepository.findAll();
	}

	@Override
	public ChiTietDonHang layChiTietDonHangTheoid(ChiTietDonHangPk id) {
		return chiTietDonHangRepository.getById(id);
	}

	@Override
	public String XoaChiTietDonHang(ChiTietDonHang id) {
//		 chiTietDonHangRepository.deleteById(id);
		 chiTietDonHangRepository.delete(id);
		 return "Xóa thành công ";
	}

	@Override
	public ChiTietDonHang luuChitietDonHang(ChiTietDonHang chiTietDonHang) {
		return chiTietDonHangRepository.save(chiTietDonHang);
	}

}
