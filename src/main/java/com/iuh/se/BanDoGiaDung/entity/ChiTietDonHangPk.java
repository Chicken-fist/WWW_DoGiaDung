package com.iuh.se.BanDoGiaDung.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChiTietDonHangPk implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "don_hang_id", nullable = false)
	private int donHangId;
	
	@Column(name = "san_pham_id", nullable = false)
	private int sanPhamId;
	
	public ChiTietDonHangPk(int donHangId, int sanPhamId) {
		super();
		this.donHangId = donHangId;
		this.sanPhamId = sanPhamId;
	}
	public ChiTietDonHangPk() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(sanPhamId, donHangId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDonHangPk other = (ChiTietDonHangPk) obj;
		return sanPhamId == other.sanPhamId && donHangId == other.donHangId;
	}



}
