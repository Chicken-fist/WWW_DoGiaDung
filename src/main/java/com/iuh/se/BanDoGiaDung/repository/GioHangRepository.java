package com.iuh.se.BanDoGiaDung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iuh.se.BanDoGiaDung.entity.GioHang;
import com.iuh.se.BanDoGiaDung.entity.KhachHang;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, Integer>{

	@Query(value = "SELECT * FROM gio_hang g join khach_hang k on k.id = g.khach_hang_id WHERE users_id = :usersId", nativeQuery = true)
	public GioHang TimByUsersId(@Param("usersId") Integer usersId);

	public GioHang findByKhachHang(KhachHang khachHang);
}
