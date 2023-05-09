package com.iuh.se.BanDoGiaDung.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iuh.se.BanDoGiaDung.entity.SanPham;


@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
	
	@Query(value = "select * from bao s where s.ten_bao like %:ten% ", nativeQuery = true)
	List<SanPham> findAllByTenSanPham(@Param("ten") String tenSanPham);
	

}