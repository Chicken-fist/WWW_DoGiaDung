package com.iuh.se.BanDoGiaDung.service;

import org.springframework.stereotype.Service;

import com.iuh.se.BanDoGiaDung.entity.Users;

@Service
public interface UsersService {
	public Users getByUsername(String userName);

	Users findById(int id);

	Users them(Users user);
}
