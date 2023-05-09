package com.iuh.se.BanDoGiaDung.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iuh.se.BanDoGiaDung.entity.KhachHang;


public interface KhachHangRepository extends JpaRepository<KhachHang, Integer>{

	public Optional<KhachHang> findByUsersId(int id);
}
