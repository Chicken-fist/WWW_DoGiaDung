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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name = "chi_tiet_gio_hang")
public class ChiTietGioHang implements Serializable {
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "sanPhamId", column = @Column(name = "san_pham_id", nullable = false)),
			@AttributeOverride(name = "gioHangId", column = @Column(name = "gio_hang_id", nullable = false)) })
	private ChiTietGioHangPk id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "san_pham_id",insertable = false,updatable = false)
	private SanPham san_pham;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gio_hang_id",insertable = false,updatable = false)
	private GioHang gioHang;
	@Column(name = "ngay_dat_san_pham")
	private Date ngayDatSanPham;
	@Column(name = "ngay_ket_thuc_dat_san_pham")
	private Date ngayKetThucDatSanPham;
	@Column(name = "so_ky")
	private int soKy;
	@Column(name = "so_luong")
	private int soLuong;

	
	

	public void setId(ChiTietGioHangPk id) {
		this.id = id;
	}
	
	public ChiTietGioHangPk getId() {
		return id;
	}

	public ChiTietGioHang(ChiTietGioHangPk id, SanPham SanPham, GioHang gioHang, Date ngayDatSanPham,
			Date ngayKetThucDatSanPham, int soKy, int soLuong) {
		super();
		this.id = id;
		this.san_pham = SanPham;
		this.gioHang = gioHang;
		this.ngayDatSanPham = ngayDatSanPham;
		this.ngayKetThucDatSanPham = ngayKetThucDatSanPham;
		this.soKy = soKy;
		this.soLuong = soLuong;
	}

	public ChiTietGioHang() {
		super();
	}

	public SanPham getSanPham() {
		return san_pham;
	}

	public void setSanPham(SanPham SanPham) {
		this.san_pham = SanPham;
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

	public Date getNgayKetThucDatSanPham() {
		return ngayKetThucDatSanPham;
	}

	public void setNgayKetThucDatSanPham(Date ngayKetThucDatSanPham) {
		this.ngayKetThucDatSanPham = ngayKetThucDatSanPham;
	}

	public int getSoKy() {
		return soKy;
	}

	public void setSoKy(int soKy) {
		this.soKy = soKy;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietGioHang [id=" + id + ", SanPham=" + san_pham + ", gioHang=" + gioHang + ", ngayDatSanPham=" + ngayDatSanPham
				+ ", ngayKetThucDatSanPham=" + ngayKetThucDatSanPham + ", soKy=" + soKy + ", soLuong=" + soLuong + "]";
	}

}