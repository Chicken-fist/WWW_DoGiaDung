package com.iuh.se.BanDoGiaDung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iuh.se.BanDoGiaDung.entity.GioHang;
import com.iuh.se.BanDoGiaDung.entity.KhachHang;


public interface GioHangRepository extends JpaRepository<GioHang, Integer>{

	@Query("SELECT gh FROM GioHang gh JOIN gh.khachHang kh JOIN kh.users u WHERE u.id = :usersId")
	public GioHang findByUsersId(Integer usersId);

	public GioHang findByKhachHang(KhachHang khachHang);
}
