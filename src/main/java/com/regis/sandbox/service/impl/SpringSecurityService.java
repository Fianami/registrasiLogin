package com.regis.sandbox.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.regis.sandbox.dao.AdminDao;

public class SpringSecurityService implements UserDetailsService {
	
	private AdminDao adminDao;
	
	@Autowired
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		com.regis.sandbox.model.Admin admin = adminDao.getByName(username);
		
		if (admin == null) {
			throw new UsernameNotFoundException("Error in retrieving user");
		}
		
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		return new User(admin.getfirstName(), admin.getPassword(), enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked,
				getAuthorities(admin.getAdminrole()));
		}
		
		public Collection<? extends GrantedAuthority> getAuthorities(String role) {
			List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
			return authList;
		}

		public List<String> getRoles(String role) {

			List<String> roles = new ArrayList<String>();

			if (role.equals("admindaftar")) {
				roles.add("ROLE_ADMIN_DAFTAR");
			} else if (role.equals("adminperiksa")) {
				roles.add("ROLE_ADMIN_PERIKSA");
			}else if (role.equals("apoteker")) {
				roles.add("ROLE_APOTEKER");
			}else if (role.equals("kasir")) {
				roles.add("ROLE_KASIR");
			}else if (role.equals("superadmin")) {
				roles.add("ROLE_SUPER_ADMIN");
			}
			return roles;
		}

		public static List<GrantedAuthority> getGrantedAuthorities(
				List<String> roles) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

			for (String role : roles) {
				authorities.add(new SimpleGrantedAuthority(role));
			}
			return authorities;
		//return null;
	}

}
