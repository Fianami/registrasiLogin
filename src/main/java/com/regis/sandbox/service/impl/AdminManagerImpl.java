package com.regis.sandbox.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regis.sandbox.dao.AdminDao;
import com.regis.sandbox.model.Admin;
import com.regis.sandbox.service.AdminManager;


@Service
public class AdminManagerImpl implements AdminManager{
	private AdminDao adminDao;

	@Autowired
	public void setAdminDao( AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public Admin getById(Integer id) {
		// TODO Auto-  method stub
		return adminDao.get(id);
	}

	@Override
	public List<Admin> getAll() {
	
		return adminDao.getAll();
	}

	@Override
	public Admin save(Admin admin) {
		return this.adminDao.save(admin);
		
	}
	@Override
	public void remove(Integer id) {
		this.adminDao.remove(id);
		
	}
	
	@Override
	public String getPassword(Integer id) {
		return adminDao.getPassword(id);
	}

	@Override
	public Admin getByName(String name) {
		return adminDao.getByName(name);
	}

	@Override
	public Admin getByEmail(String email) {
		return adminDao.getByEmail(email);
	}
	
	@Override
	public Admin getByPhoneNumber(String phoneNumber) {
		return adminDao.getByPhoneNumber(phoneNumber);
	}
	@Override
	public List<Admin> getByRole(String userRole) {
		return adminDao.getByRole(userRole);
	}

}
