package com.iuh.se.BanDoGiaDung.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
public class DonHangDTO extends AbstractDTO{
	private int  maKhachHang;
	private String tenKhachHang;
	private String SDT;
	private int  maKhuyenMai;
	private String tenKhuyenMai;
	private double giaTriGiam;
	private Date ngayTaoDonHang;
	private String trangThaiDonHang;
	private String diaChiNhanHang;
	private double tongTienDonHang;
	private double tongThanhTien;
	private String hinhThucThanhToan;
	private Set<ChiTietDonHangDTO> chiTietDonHang;

	
}
