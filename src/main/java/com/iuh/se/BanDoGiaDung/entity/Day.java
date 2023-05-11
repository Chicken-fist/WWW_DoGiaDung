package com.iuh.se.BanDoGiaDung.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Day {
	private int ngay;
	private int thang;
	private int nam;
	public int getNgay() {
		return ngay;
	}
	public void setNgay(int ngay) {
		this.ngay = ngay;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}

	public Day(int nam) {
		super();
		this.nam = nam;
	}
	public Day(int thang, int nam) {
		super();
		this.thang = thang;
		this.nam = nam;
	}
	public Day(int ngay, int thang, int nam) {
		super();
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}
	public Day() {
		super();
	}
	@Override
	public String toString() {
		return "Day [ngay=" + ngay + ", thang=" + thang + ", nam=" + nam + "]";
	}
	
}
