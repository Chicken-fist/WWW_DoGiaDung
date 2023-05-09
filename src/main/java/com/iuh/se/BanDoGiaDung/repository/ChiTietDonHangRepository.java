package com.iuh.se.BanDoGiaDung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iuh.se.BanDoGiaDung.entity.ChiTietDonHangPk;


public interface  ChiTietDonHangRepository extends JpaRepository<com.iuh.se.BanDoGiaDung.entity.ChiTietDonHang, ChiTietDonHangPk> {
}
