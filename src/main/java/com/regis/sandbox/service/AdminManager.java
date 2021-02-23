package com.regis.sandbox.service;

import java.util.List;

import com.regis.sandbox.model.Admin;

public interface AdminManager {
	public Admin getById(Integer id);
	public List<Admin> getAll();
	public Admin save(Admin admin);
	public void remove (Integer id);
	public String getPassword(Integer id);
	public Admin getByName(String name);
	public Admin getByEmail(String email);
	public Admin getByPhoneNumber(String phoneNumber);
	public List<Admin> getByRole(String userRole);
}
