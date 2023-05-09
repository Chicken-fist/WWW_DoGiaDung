package com.iuh.se.BanDoGiaDung.security;

import java.util.Optional;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.iuh.se.BanDoGiaDung.entity.Users;
import com.iuh.se.BanDoGiaDung.repository.KhachHangRepository;
import com.iuh.se.BanDoGiaDung.repository.NhanVienRepository;
import com.iuh.se.BanDoGiaDung.repository.UsersRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UsersRepository usersRepository;
	private NhanVienRepository nhanvienRepository;
	private KhachHangRepository khachHangRepository;

	public UserDetailsServiceImpl(UsersRepository usersRepository, NhanVienRepository nhanvienRepository,
			KhachHangRepository khachHangRepository) {

		this.usersRepository = usersRepository;
		this.nhanvienRepository = nhanvienRepository;
		this.khachHangRepository = khachHangRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> usersOpt = usersRepository.findByUsername(username);

		if (usersOpt.isPresent()) {
			Users users = usersOpt.get();

			String role = null;
			if (users.getNhanVien() != null) {
				role = "EMPLOYEE";
			} else if (users.getKhachHang() != null) {
				role = "CUSTOMER";
			}

			return new User(users.getUsername(), users.getPassword(), true, true, true, true,
					StringUtils.hasText(role) ? AuthorityUtils.createAuthorityList(role)
							: AuthorityUtils.NO_AUTHORITIES);
		}
		return null;
	}
}
