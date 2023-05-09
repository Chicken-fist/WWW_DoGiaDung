package com.iuh.se.BanDoGiaDung.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.se.BanDoGiaDung.entity.Users;
import com.iuh.se.BanDoGiaDung.repository.UsersRepository;
import com.iuh.se.BanDoGiaDung.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public Users getByUsername(String userName) {
		return usersRepository.findByUsername(userName).orElse(null);
	}
	@Override
	public Users findById(int id ) {
		return usersRepository.findById(id);
	}

}
