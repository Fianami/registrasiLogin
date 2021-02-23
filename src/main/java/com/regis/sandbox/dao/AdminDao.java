package com.regis.sandbox.dao;

import java.util.List;

import com.regis.sandbox.model.Admin;

public interface AdminDao extends GenericDao<Admin, Integer>{

	public String getPassword(Integer id);

	public Admin getByName(String name);
	
	public Admin getByEmail(String email);

	public List<Admin> getByRole(String userRole);

	public Admin getByPhoneNumber(String phoneNumber);

}
