package com.iuh.se.BanDoGiaDung.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iuh.se.BanDoGiaDung.convert.ChiTietDonHangConvert;
import com.iuh.se.BanDoGiaDung.convert.DonHangConvert;
import com.iuh.se.BanDoGiaDung.convert.KhachHangConvert;
import com.iuh.se.BanDoGiaDung.convert.KhuyenMaiConvert;
import com.iuh.se.BanDoGiaDung.dto.ChiTietDonHangDTO;
import com.iuh.se.BanDoGiaDung.dto.DonHangDTO;
import com.iuh.se.BanDoGiaDung.entity.ChiTietDonHang;
import com.iuh.se.BanDoGiaDung.entity.ChiTietDonHangPk;
import com.iuh.se.BanDoGiaDung.entity.ChiTietGioHangPk;
import com.iuh.se.BanDoGiaDung.entity.DonHang;
import com.iuh.se.BanDoGiaDung.entity.GioHang;
import com.iuh.se.BanDoGiaDung.entity.KhachHang;
import com.iuh.se.BanDoGiaDung.entity.KhuyenMai;
import com.iuh.se.BanDoGiaDung.entity.Users;
import com.iuh.se.BanDoGiaDung.repository.ChiTietDonHangRepository;
import com.iuh.se.BanDoGiaDung.repository.ChiTietGioHangRepository;
import com.iuh.se.BanDoGiaDung.repository.DonHangRepository;
import com.iuh.se.BanDoGiaDung.repository.GioHangRepository;
import com.iuh.se.BanDoGiaDung.repository.KhachHangRepository;
import com.iuh.se.BanDoGiaDung.repository.KhuyenMaiRepository;
import com.iuh.se.BanDoGiaDung.repository.SanPhamRepository;
import com.iuh.se.BanDoGiaDung.service.DonHangService;
import com.iuh.se.BanDoGiaDung.service.KhachHangService;
import com.iuh.se.BanDoGiaDung.service.KhuyenMaiService;
import com.iuh.se.BanDoGiaDung.service.UsersService;

@Service
public class DonHangServiceImpl implements DonHangService {
	
	@Autowired
	private DonHangRepository donHangRepository;
	
	@Autowired
	private DonHangConvert donHangConvert;
	@Autowired
	private ChiTietDonHangConvert chiTietDonHangConvert;
	
	@Autowired
	private ChiTietDonHangRepository chiTietDonHangRepository;
	
	@Autowired
	private SanPhamRepository sanPhamRepository;
	
	@Autowired
	private KhuyenMaiRepository khuyenMaiRepository;
	
	@Autowired
	private KhachHangRepository khachHangRepository;
	
	@Autowired
	private ChiTietGioHangRepository chiTietGioHangRepository;
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private GioHangRepository gioHangRepository;
	
	@Autowired
	private KhachHangService khachHangService;
	
	@Autowired
	private KhuyenMaiService khuyenMaiService;
	
	@Autowired
	private KhachHangConvert khachHangConvert;
	
	@Autowired
	private KhuyenMaiConvert khuyenMaiConvert;

	public DonHangServiceImpl(DonHangRepository donHangRepository) {
		super();
		this.donHangRepository = donHangRepository;
	}

	@Override
	public List<DonHangDTO> layDSDonHang() {
		List<DonHang> donHangs = donHangRepository.findAll();
		List<DonHangDTO> donHangDTOs = new ArrayList<DonHangDTO>();
		for (DonHang donHang : donHangs) {
			if (Objects.isNull(donHang)) {
				return null;
			}
			DonHangDTO donHangDTO = donHangConvert.chuyendonHangDTO(donHang);
			donHangDTOs.add(donHangDTO);
		}
		return donHangDTOs;
	}

	@Override
	public DonHangDTO layDonHangTheoId(int id) {
		DonHang donHang = donHangRepository.findById(id).orElse(null);
		if (Objects.isNull(donHang)) {
			return null;
		}
		return donHangConvert.chuyendonHangDTO(donHang);
	}

	@Override
	public String xoaDonHang(int id) {
		DonHang donHang = donHangRepository.findById(id).orElse(null);
		if (Objects.isNull(donHang)) {
			return null;
		}
		donHangRepository.delete(donHang);
		return "xóa thành công";
	}

	@Transactional
	@Override
	public Integer luuDonHang(DonHangDTO donHangDTO, Principal principal) {
		DonHang donHang = new DonHang();
		double total = 0.0;
		for (ChiTietDonHangDTO chiTietDonHangDTO : donHangDTO.getChiTietDonHang()) {
			total += chiTietDonHangDTO.getSoKy() * chiTietDonHangDTO.getDonGia() * chiTietDonHangDTO.getSoLuong();
		}
		Optional<KhuyenMai> khuyenMai = khuyenMaiRepository.findById(donHangDTO.getMaKhuyenMai());
		if (khuyenMai.isPresent()) {
			total -= khuyenMai.get().getGiaTriGiam();
		}
		donHang.setKhachHang(new KhachHang(donHangDTO.getMaKhachHang()));
		donHang.setKhuyenMai(new KhuyenMai(donHangDTO.getMaKhuyenMai()));
		donHang.setNgayTaoDonHang(donHangDTO.getNgayTaoDonHang());
		donHang.setTrangThaiDonHang(donHangDTO.getTrangThaiDonHang());
		donHang.setDiaChiNhanHang(donHangDTO.getDiaChiNhanHang());
		donHang.setTongTienDonHang(total);
		donHang.setHinhThucThanhToan(donHangDTO.getHinhThucThanhToan());
		donHangRepository.save(donHang);
		Set<ChiTietDonHang> chiTietDonHangs = new HashSet<ChiTietDonHang>();
		for (ChiTietDonHangDTO chiTietDonHangDTO : donHangDTO.getChiTietDonHang()) {
			ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
			chiTietDonHang.setId(new ChiTietDonHangPk(donHang.getid(), chiTietDonHangDTO.getMaSanPham()));
			chiTietDonHang.setNgayDatHang(chiTietDonHangDTO.getNgayDatSanPham());
			chiTietDonHang.setSoLuong(chiTietDonHangDTO.getSoLuong());
			chiTietDonHangs.add(chiTietDonHang);
		}
		chiTietDonHangRepository.saveAll(chiTietDonHangs);
		Users users = usersService.getByUsername(principal.getName());
		users.getId();
		GioHang gioHang = gioHangRepository.findByKhachHang(users.getKhachHang());
		for (ChiTietDonHangDTO chiTietDonHangDTO : donHangDTO.getChiTietDonHang()) {

			chiTietGioHangRepository.deleteById(new ChiTietGioHangPk(chiTietDonHangDTO.getMaSanPham(), gioHang.getid()));
		}
		return donHang.getid();
	}

	@Override
	public List<DonHangDTO> finddonhang(int year, int month, int day) {
		List<DonHangDTO> donHangDTOs = new ArrayList<DonHangDTO>();
		List<DonHang> donHangs = donHangRepository
				.findAllByNgayTaoDonHang_YearAndNgayTaoDonHang_MonthAndNgayTaoDonHang_DayOfMonth(year, month, day);
		for (DonHang donHang : donHangs) {
			DonHangDTO donHangDto = donHangConvert.chuyendonHangDTO(donHang);
			donHangDTOs.add(donHangDto);
		}
		return donHangDTOs;
	}

	@Transactional
	@Override
	public void suaDonHang(DonHangDTO donHangDTO, int madonhang) {

		DonHang donHang = new DonHang();
		donHang.setid(madonhang);
		donHang.setKhachHang(khachHangConvert
				.chuyenKhachHangEntity(khachHangService.layKhachHangTheoId(donHangDTO.getMaKhachHang())));
		donHang.setKhuyenMai(khuyenMaiConvert
				.chuyenKhuyenMaiEntity(khuyenMaiService.layKhuyenMaiTheoid(donHangDTO.getMaKhuyenMai())));
		donHang.setNgayTaoDonHang(donHangDTO.getNgayTaoDonHang());
		donHang.setTrangThaiDonHang(donHangDTO.getTrangThaiDonHang());
		donHang.setDiaChiNhanHang(donHangDTO.getDiaChiNhanHang());
		donHang.setTongTienDonHang(donHangDTO.getTongTienDonHang());
		donHang.setHinhThucThanhToan(donHangDTO.getHinhThucThanhToan());
		donHangRepository.save(donHang);

		Set<ChiTietDonHang> chiTietDonHangs = new HashSet<ChiTietDonHang>();
		for (ChiTietDonHangDTO chiTietDonHangDTO : donHangDTO.getChiTietDonHang()) {
			ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
			chiTietDonHang.setId(new ChiTietDonHangPk(donHang.getid(), chiTietDonHangDTO.getMaSanPham()));
			chiTietDonHang.setNgayDatHang(chiTietDonHangDTO.getNgayDatSanPham());
			chiTietDonHang.setSoLuong(chiTietDonHangDTO.getSoLuong());
			chiTietDonHangs.add(chiTietDonHang);
		}
		chiTietDonHangRepository.saveAll(chiTietDonHangs);
	}
}