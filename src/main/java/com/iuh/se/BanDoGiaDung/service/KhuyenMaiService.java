package com.iuh.se.BanDoGiaDung.service;

import java.util.List;

import com.iuh.se.BanDoGiaDung.dto.KhuyenMaiDto;


public interface KhuyenMaiService {

	public List<KhuyenMaiDto> layDSKhuyenMai();
	public String xoaKhuyenMai(int id) ;
	public KhuyenMaiDto layKhuyenMaiTheoid(int id);
	public KhuyenMaiDto themKhuyenMai(KhuyenMaiDto khuyenMaiDto);
}
