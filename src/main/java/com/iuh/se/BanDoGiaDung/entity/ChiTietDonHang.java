package com.iuh.se.BanDoGiaDung.entity;

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
@Table(name = "chi_tiet_don_hang")
public class ChiTietDonHang {
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "donHangId", column = @Column(name = "don_hang_id", nullable = false)),
			@AttributeOverride(name = "sanPhamId", column = @Column(name = "san_pham_id", nullable = false)) })
	private ChiTietDonHangPk id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "don_hang_id",insertable = false,updatable = false)
	private DonHang donHang;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "san_pham_id",insertable = false,updatable = false)
	private SanPham san_pham;
	
	@Column(name = "ngay_dat_san_pham")
	private Date ngayDatHang;
	
	@Column(name = "so_luong")
	private int soLuong;

	public ChiTietDonHang(ChiTietDonHangPk id, DonHang donHang, SanPham sanPham, Date ngayDatHang, int soLuong) {
		super();
		this.id = id;
		this.donHang = donHang;
		this.san_pham = sanPham;
		this.ngayDatHang = ngayDatHang;
		this.soLuong = soLuong;
	}

	public ChiTietDonHang() {
		super();
	}
	
	public ChiTietDonHangPk getId() {
		return id;
	}

	

	public void setId(ChiTietDonHangPk id) {
		this.id = id;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	public SanPham getSanPham() {
		return san_pham;
	}

	public void setSanPham(SanPham sanPham) {
		this.san_pham = sanPham;
	}

	public Date getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}


	@Override
	public String toString() {
		return "ChiTietDonHang [id=" + id + ", donHang=" + donHang + ", sanPham=" + san_pham + ", ngayDatHang=" + ngayDatHang
				 + ", soLuong=" + soLuong  + " ]";
	}

}