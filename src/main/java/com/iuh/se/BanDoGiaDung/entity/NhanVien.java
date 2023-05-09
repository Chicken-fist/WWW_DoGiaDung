package com.iuh.se.BanDoGiaDung.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nhan_vien")
public class NhanVien {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private int id;

  @Column(name = "ten_nhan_vien", columnDefinition = "nvarchar(100)")
  private String tenNhanVien;

  @Column(name = "sdt")
  private String SDT;

  @Column(name = "dia_chi", columnDefinition = "nvarchar(100)")
  private String diaChi;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "users_id", referencedColumnName = "id")
  private Users users;
  // mapping
//  @OneToMany(mappedBy = "nhanVien")
//  private Set<KhuyenMai> dsKhuyenMai;

  public int getid() {
    return id;
  }

  public void setid(int id) {
    this.id = id;
  }

  public String getTenNhanVien() {
    return tenNhanVien;
  }

  public void setTenNhanVien(String tenNhanVien) {
    this.tenNhanVien = tenNhanVien;
  }

  public String getSDT() {
    return SDT;
  }

  public void setSDT(String sDT) {
    SDT = sDT;
  }

  public String getDiaChi() {
    return diaChi;
  }

  public void setDiaChi(String diaChi) {
    this.diaChi = diaChi;
  }

  public Users getUsers() {
    return users;
  }

  public void setUsers(Users users) {
    this.users = users;
  }
}
