package com.iuh.se.BanDoGiaDung.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iuh.se.BanDoGiaDung.entity.NhanVien;


public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {

	public Optional<NhanVien> findByUsersId(int id);

}
