package com.iuh.se.BanDoGiaDung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iuh.se.BanDoGiaDung.entity.ChiTietGioHang;
import com.iuh.se.BanDoGiaDung.entity.ChiTietGioHangPk;
import com.iuh.se.BanDoGiaDung.entity.GioHang;
import com.iuh.se.BanDoGiaDung.entity.SanPham;

public interface ChiTietGioHangRepository extends JpaRepository<com.iuh.se.BanDoGiaDung.entity.ChiTietGioHang,ChiTietGioHangPk> {

	void deleteByGioHang(GioHang gioHang);
	
	@Query( value = "delete chi_tiet_gio_hang where gio_hang_id = :gio_hang_id and san_pham_id = :san_pham_id", nativeQuery = true)
	void deleteByGioHangAndSanPham(@Param("gio_hang_id") Integer gioHangId, @Param("san_pham_id") Integer sanPhamId);
}
