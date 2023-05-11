package com.iuh.se.BanDoGiaDung.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "khuyen_mai")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class KhuyenMai {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@Column(name = "ten_khuyen_mai", columnDefinition = "nvarchar(100)")
	private String tenKhuyenMai;
	
	@Column(name = "ngay_bat_dau")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayBatDau;
	
	@Column(name = "ngay_het_han")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayHetHan;
	
	@Column(name = "gia_tri_giam")
	private double giaTriGiam;
	// mapping
	@ManyToOne()
	@JoinColumn(name = "nhanVienId")
	private NhanVien nhanVien;

	@OneToMany(mappedBy = "khuyenMai", cascade = { CascadeType.MERGE })
	private Set<DonHang> dsHoaDon;

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}

	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public double getGiaTriGiam() {
		return giaTriGiam;
	}

	public void setGiaTriGiam(double giaTriGiam) {
		this.giaTriGiam = giaTriGiam;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhuyenMai(int id, String tenKhuyenMai, Date ngayBatDau, Date ngayHetHan, double giaTriGiam,
			NhanVien nhanVien) {
		super();
		this.id = id;
		this.tenKhuyenMai = tenKhuyenMai;
		this.ngayBatDau = ngayBatDau;
		this.ngayHetHan = ngayHetHan;
		this.giaTriGiam = giaTriGiam;
		this.nhanVien = nhanVien;
	}

	public KhuyenMai(int id) {
		super();
		this.id = id;
	}

	public KhuyenMai() {
		super();
	}

	@Override
	public String toString() {
		return "KhuyenMai [id=" + id + ", tenKhuyenMai=" + tenKhuyenMai + ", ngayBatDau=" + ngayBatDau + ", ngayHetHan="
				+ ngayHetHan + ", giaTriGiam=" + giaTriGiam + ", nhanVien=" + nhanVien.getTenNhanVien() + "]";
	}

}