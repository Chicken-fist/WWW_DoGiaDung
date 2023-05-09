package com.iuh.se.BanDoGiaDung.dto;

import java.util.Date;
import java.util.Set;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
public class GioHangDto extends AbstractDTO {

	private Date ngayTaoGioHang;
	private int khachHangId;
	private Set<ChiTietGioHangDto> chiTietGioHang;
}
