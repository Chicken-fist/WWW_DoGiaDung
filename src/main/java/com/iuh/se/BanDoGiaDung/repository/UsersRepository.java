package com.iuh.se.BanDoGiaDung.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iuh.se.BanDoGiaDung.entity.Users;


public interface UsersRepository extends JpaRepository<Users, Integer> {

  public Optional<Users> findByUsername(String username);
  public Users findById(int id);
}
