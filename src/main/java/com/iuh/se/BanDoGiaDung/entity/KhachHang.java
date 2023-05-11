package com.iuh.se.BanDoGiaDung.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "khach_hang")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class KhachHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@Column(name = "ho_ten", columnDefinition = "nvarchar(100)")
	private String hoTen;

	@Column(name = "email", columnDefinition = "nvarchar(100)")
	private String email;

	@Column(name = "sdt")
	private String SDT;
	// mapping

	// @OneToMany(mappedBy = "khachHang",cascade = {CascadeType.MERGE})
	// private Set<DonHang> dsHoaDon;

	@OneToOne(cascade = { CascadeType.MERGE })
	@PrimaryKeyJoinColumn
	private GioHang gioHang;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "users_id", referencedColumnName = "id")
	private Users users;

	public KhachHang() {
	}

	public KhachHang(int id) {
		this.id = id;
	}

	public KhachHang(int id, String hoTen, String sDT, GioHang gioHang, Users users) {
		this.id = id;
		this.hoTen = hoTen;
		this.SDT = sDT;
		this.gioHang = gioHang;
		this.users = users;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public KhachHang(String hoTen, String email, String sDT, Users users) {
		super();
		this.hoTen = hoTen;
		this.email = email;
		SDT = sDT;
		this.users = users;
	}

	@Override
	public String toString() {
		return "KhachHang [id=" + id + ", hoTen=" + hoTen + ", email=" + email + ", SDT=" + SDT + ", gioHang=" + gioHang
				+ ", users=" + users + "]";
	}
	
	

}
