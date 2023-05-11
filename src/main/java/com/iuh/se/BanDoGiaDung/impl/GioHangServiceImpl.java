package com.iuh.se.BanDoGiaDung.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iuh.se.BanDoGiaDung.convert.GioHangConvert;
import com.iuh.se.BanDoGiaDung.dto.ChiTietGioHangDto;
import com.iuh.se.BanDoGiaDung.dto.GioHangDto;
import com.iuh.se.BanDoGiaDung.dto.XoaChiTietGioHangDto;
import com.iuh.se.BanDoGiaDung.entity.ChiTietGioHang;
import com.iuh.se.BanDoGiaDung.entity.ChiTietGioHangPk;
import com.iuh.se.BanDoGiaDung.entity.GioHang;
import com.iuh.se.BanDoGiaDung.entity.SanPham;
import com.iuh.se.BanDoGiaDung.repository.ChiTietGioHangRepository;
import com.iuh.se.BanDoGiaDung.repository.GioHangRepository;
import com.iuh.se.BanDoGiaDung.repository.KhachHangRepository;
import com.iuh.se.BanDoGiaDung.repository.SanPhamRepository;
import com.iuh.se.BanDoGiaDung.service.ChiTietGioHangService;
import com.iuh.se.BanDoGiaDung.service.GioHangService;

@Service
public class GioHangServiceImpl implements GioHangService {
	
	@Autowired
	private GioHangRepository gioHangRepository;
	
	@Autowired
	private GioHangConvert gioHangConvert;
	
	// chi tiet gio hang
	@Autowired
	private ChiTietGioHangService chiTietGioHangService;
	
	@Autowired
	private SanPhamRepository SanPhamRepository;
	
	@Autowired
	private KhachHangRepository khachHangRepository;
	
	@Autowired
	private ChiTietGioHangRepository chiTietGioHangRepository;

	@Override
	public GioHangDto layGioHangTheoId(int id) {
		GioHang gioHang = gioHangRepository.findById(id).orElse(null);
		List<SanPham> sanPhams = SanPhamRepository.findAll();

		if (Objects.isNull(gioHang)) {
			return null;
		}
		return gioHangConvert.chuyenGioHangDto(gioHang, sanPhams);
	}

	@Override
	public String xoaGioHang(int id) {
		gioHangRepository.deleteById(id);
		return " xoá thành công";
	}

	@Transactional
	@Override
	public void luuGioHang(GioHangDto gioHangDto) {
		Optional<GioHang> gioHangOpt = gioHangRepository.findById(gioHangDto.getId());
		if (gioHangOpt.isPresent()) {

			GioHang gioHang = gioHangOpt.get();
			gioHang.getDsChiTietGioHang().clear();

			chiTietGioHangRepository.deleteByGioHang(gioHang);

			List<ChiTietGioHang> chiTietGioHangs = new ArrayList<ChiTietGioHang>();
			for (ChiTietGioHangDto chiTietGioHangDto : gioHangDto.getChiTietGioHang()) {
				ChiTietGioHang chiTietGioHang = new ChiTietGioHang();
				chiTietGioHang
						.setId(new ChiTietGioHangPk(chiTietGioHangDto.getSanPhamId(), chiTietGioHangDto.getGioHangId()));
				chiTietGioHang.setSanPham(new SanPham(chiTietGioHangDto.getSanPhamId()));
				chiTietGioHang.setGioHang(new GioHang(chiTietGioHangDto.getGioHangId()));
				chiTietGioHang.setNgayDatSanPham(chiTietGioHangDto.getNgayDatSanPham());
				chiTietGioHang.setSoLuong(chiTietGioHangDto.getSoLuong());
				chiTietGioHangs.add(chiTietGioHang);
			}
			chiTietGioHangRepository.saveAll(chiTietGioHangs);
			gioHangRepository.save(gioHang);
		} else {
			gioHangRepository.save(new GioHang(gioHangDto.getNgayTaoGioHang(), null, khachHangRepository.findById(gioHangDto.getKhachHangId()).get()));
		}

	}

	@Override
	public List<GioHangDto> layDSGioHang() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void themSanPhamVaoGioHang(GioHangDto gioHangDto) {

		Optional<GioHang> gioHangOpt = gioHangRepository.findById(gioHangDto.getId());
		if (gioHangOpt.isPresent()) {

			ChiTietGioHangDto chiTietGioHangDto = gioHangDto.getChiTietGioHang().iterator().next();
			Optional<SanPham> SanPhamOpt = SanPhamRepository.findById(chiTietGioHangDto.getSanPhamId());
			if (SanPhamOpt.isPresent()) {
				SanPham sanPham = SanPhamOpt.get();
				GioHang gioHang = gioHangOpt.get();
				gioHang.getDsChiTietGioHang().removeIf(item -> item.getSanPham().getId()==sanPham.getId());
//				chiTietGioHangRepository.deleteByGioHangAndSanPham(gioHang.getid(), sanPham.getId());

				ChiTietGioHang chiTietGioHang = new ChiTietGioHang();
				chiTietGioHang
						.setId(new ChiTietGioHangPk(chiTietGioHangDto.getSanPhamId(), chiTietGioHangDto.getGioHangId()));
				chiTietGioHang.setSanPham(new SanPham(chiTietGioHangDto.getSanPhamId()));
				chiTietGioHang.setGioHang(new GioHang(chiTietGioHangDto.getGioHangId()));
				chiTietGioHang.setNgayDatSanPham(chiTietGioHangDto.getNgayDatSanPham());
				chiTietGioHang.setSoLuong(chiTietGioHangDto.getSoLuong());
				chiTietGioHangRepository.save(chiTietGioHang);
				gioHangRepository.save(gioHang);
			}
		}

	}

	@Override
	public void xoaChiTietGioHang(XoaChiTietGioHangDto xoaChiTietGioHangDto) {
		chiTietGioHangRepository.deleteById(new ChiTietGioHangPk(xoaChiTietGioHangDto.getSanPhamId(),xoaChiTietGioHangDto.getGioHangId()));
		
	}

}
