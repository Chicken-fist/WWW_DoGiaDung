package com.iuh.se.BanDoGiaDung.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Embeddable
public class ChiTietGioHangPk  implements Serializable{
	@Column(name = "san_pham_id", nullable = false)
	private int  sanPhamId;
	@Column(name = "gio_hang_id", nullable = false)
	private int gioHangId;
	
	
	public ChiTietGioHangPk(int sanPhamId, int gioHangId) {
		super();
		this.sanPhamId = sanPhamId;
		this.gioHangId = gioHangId;
	}
	public ChiTietGioHangPk() {
		super();
	}
	
	public int getSanPhamId() {
		return sanPhamId;
	}
	public void setSanPhamId(int sanPhamId) {
		this.sanPhamId = sanPhamId;
	}
	
	public int getGioHangId() {
		return gioHangId;
	}
	public void setGioHangId(int gioHangId) {
		this.gioHangId = gioHangId;
	}
	@Override
	public String toString() {
		return "ChiTietGioHangPk [sanPhamId=" + sanPhamId + ", gioHangId=" + gioHangId + "]";
	}

	
}
