package com.iuh.se.BanDoGiaDung.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "chi_tiet_gio_hang")
public class ChiTietGioHang implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "gioHangId", column = @Column(name = "gio_hang_id", nullable = false)), 
	@AttributeOverride(name = "sanPhamId", column = @Column(name = "san_pham_id", nullable = false))})
	private ChiTietGioHangPk id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "san_pham_id", insertable = false, updatable = false)
	private SanPham san_pham;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gio_hang_id", insertable = false, updatable = false)
	private GioHang gioHang;
	
	@Column(name = "ngay_dat_san_pham")
	private Date ngayDatSanPham;
	
	@Column(name = "so_luong")
	private int soLuong;

	public void setId(ChiTietGioHangPk id) {
		this.id = id;
	}

	public ChiTietGioHangPk getId() {
		return id;
	}

	public ChiTietGioHang(ChiTietGioHangPk id, SanPham sanPham, GioHang gioHang, Date ngayDatSanPham,
			Date ngayKetThucDatSanPham, int soKy, int soLuong) {
		super();
		this.id = id;
		this.san_pham = sanPham;
		this.gioHang = gioHang;
		this.ngayDatSanPham = ngayDatSanPham;
		this.soLuong = soLuong;
	}

	public ChiTietGioHang() {
		super();
	}

	public SanPham getSanPham() {
		return san_pham;
	}

	public void setSanPham(SanPham sanPham) {
		this.san_pham = sanPham;
	}

	public GioHang getGioHang() {
		return gioHang;
	}

	public void setGioHang(GioHang gioHang) {
		this.gioHang = gioHang;
	}

	public Date getNgayDatSanPham() {
		return ngayDatSanPham;
	}

	public void setNgayDatSanPham(Date date) {
		this.ngayDatSanPham = date;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietGioHang [id=" + id + ", SanPham=" + san_pham + ", gioHang=" + gioHang + ", ngayDatSanPham="
				+ ngayDatSanPham  +  " , soLuong=" + soLuong + "]";
	}

}