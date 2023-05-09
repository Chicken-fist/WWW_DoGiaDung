package com.iuh.se.BanDoGiaDung.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iuh.se.BanDoGiaDung.entity.DonHang;


public interface DonHangRepository extends JpaRepository<DonHang, Integer> {
	@Query(value = "select * from don_hang where YEAR(ngay_tao_don_hang) = ?1 and MONTH(ngay_tao_don_hang) = ?2 and DAY(ngay_tao_don_hang) = ?3", nativeQuery = true)
	List<DonHang> findAllByNgayTaoDonHang_YearAndNgayTaoDonHang_MonthAndNgayTaoDonHang_DayOfMonth(int year, int month,
			int day);

}