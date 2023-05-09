package com.iuh.se.BanDoGiaDung.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gio_hang")
public class GioHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@Column(nullable = false)
	private Date ngayTaoGioHang;
	// mapping

	@OneToMany(mappedBy = "gioHang",cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
	private Set<ChiTietGioHang> dsChiTietGioHang;

	@OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "khachHangId")
	private KhachHang khachHang;

	public GioHang(int id, Date ngayTaoGioHang, Set<ChiTietGioHang> dsChiTietGioHang,
			KhachHang khachHang) {
		super();
		this.id = id;
		this.ngayTaoGioHang = ngayTaoGioHang;
		this.dsChiTietGioHang = dsChiTietGioHang;
		this.khachHang = khachHang;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public Date getNgayTaoGioHang() {
		return ngayTaoGioHang;
	}

	public void setNgayTaoGioHang(Date ngayTaoGioHang) {
		this.ngayTaoGioHang = ngayTaoGioHang;
	}

	public Set<ChiTietGioHang> getDsChiTietGioHang() {
		return dsChiTietGioHang;
	}

	public void setDsChiTietGioHang(Set<ChiTietGioHang> dsChiTietGioHang) {
		this.dsChiTietGioHang = dsChiTietGioHang;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public GioHang() {
		super();
	}

	public GioHang(int id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "GioHang [id=" + id + ", ngayTaoGioHang=" + ngayTaoGioHang + ", dsChiTietGioHang="
				+ dsChiTietGioHang + ", khachHang=" + khachHang + "]";
	}
	
	
	
	
}