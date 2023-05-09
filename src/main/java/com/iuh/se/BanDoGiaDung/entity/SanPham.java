package com.iuh.se.BanDoGiaDung.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "san_pham")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@Column(name = "ten_san_pham", columnDefinition = "nvarchar(100)")
	private String tenSanPham;
	
	@Column(name = "hinh_anh")
	private String hinhAnh;
	
	@Column(name = "don_gia")
	private double donGia;
	
	@Column(name = "mo_ta", columnDefinition = "nvarchar(100)")
	private String moTa;
	
	
	@OneToMany(mappedBy = "san_pham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ChiTietDonHang> dsChiTietHoaDon;
	
	@OneToMany(mappedBy = "san_pham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ChiTietGioHang> dsChiTietGioHang;

	public SanPham(String tenSanPham, String hinhAnh, double donGia, String moTa, Set<ChiTietGioHang> dsChiTietGioHang,
			Set<ChiTietDonHang> dsChiTietHoaDon) {
		super();
		this.tenSanPham = tenSanPham;
		this.hinhAnh = hinhAnh;
		this.donGia = donGia;
		this.moTa = moTa;
		this.dsChiTietGioHang = dsChiTietGioHang;
		this.dsChiTietHoaDon = dsChiTietHoaDon;
	}

	public SanPham(int id) {
		super();
		this.id = id;
	}
	
	

}