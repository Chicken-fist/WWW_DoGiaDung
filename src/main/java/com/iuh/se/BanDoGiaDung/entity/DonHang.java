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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "don_hang")
public class DonHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@ManyToOne
	@JoinColumn(name = "khach_hang_id")
	private KhachHang khachHang;

	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "khuyenMaiId")
	private KhuyenMai khuyenMai;

	@Column(name = "ngay_tao_don_hang")
	private Date ngayTaoDonHang;
	
	@Column(name = "trang_thai_don_hang",columnDefinition = "nvarchar(100)")
	private String trangThaiDonHang;
	
	@Column(name = "dia_chi_nhan_hang",columnDefinition = "nvarchar(100)")
	private String diaChiNhanHang;
	
	@Column(name = "tong_tien_don_hang")
	private double tongTienDonHang;
	
	@Column(name = "hinh_thuc_thanh_toan" ,columnDefinition = "nvarchar(100)")
	private String hinhThucThanhToan;
	// mapping
	@OneToMany(mappedBy = "donHang",cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
	private Set<ChiTietDonHang> chiTietDonHang;
	
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}
	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}
	public Date getNgayTaoDonHang() {
		return ngayTaoDonHang;
	}
	public void setNgayTaoDonHang(Date date) {
		this.ngayTaoDonHang = date;
	}
	public String getTrangThaiDonHang() {
		return trangThaiDonHang;
	}
	public void setTrangThaiDonHang(String trangThaiDonHang) {
		this.trangThaiDonHang = trangThaiDonHang;
	}
	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}
	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}
	public double getTongTienDonHang() {
		return tongTienDonHang;
	}
	public void setTongTienDonHang(double tongTienDonHang) {
		this.tongTienDonHang = tongTienDonHang;
	}
	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}
	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}
	public Set<ChiTietDonHang> getChiTietDonHang() {
		return chiTietDonHang;
	}
	public void setChiTietDonHang(Set<ChiTietDonHang> chiTietDonHang) {
		this.chiTietDonHang = chiTietDonHang;
	}
	public DonHang(KhachHang khachHang, KhuyenMai khuyenMai, Date ngayTaoDonHang, String trangThaiDonHang,
			String diaChiNhanHang, double tongTienDonHang, String hinhThucThanhToan,
			Set<ChiTietDonHang> chiTietDonHang) {
		super();
		this.khachHang = khachHang;
		this.khuyenMai = khuyenMai;
		this.ngayTaoDonHang = ngayTaoDonHang;
		this.trangThaiDonHang = trangThaiDonHang;
		this.diaChiNhanHang = diaChiNhanHang;
		this.tongTienDonHang = tongTienDonHang;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.chiTietDonHang = chiTietDonHang;
	}
	public DonHang() {
		super();
	}
	@Override
	public String toString() {
		return "DonHang [id=" + id + ", khachHang=" + khachHang + ", khuyenMai=" + khuyenMai
				+ ", ngayTaoDonHang=" + ngayTaoDonHang + ", trangThaiDonHang=" + trangThaiDonHang + ", diaChiNhanHang="
				+ diaChiNhanHang + ", tongTienDonHang=" + tongTienDonHang + ", hinhThucThanhToan=" + hinhThucThanhToan
				+ ", chiTietDonHang=" + chiTietDonHang + "]";
	}
	
	
}