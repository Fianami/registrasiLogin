package com.regis.sandbox.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.regis.sandbox.dao.AdminDao;
import com.regis.sandbox.model.Admin;

@Repository
public class AdminDaoHibernate extends GenericDaoHibernate<Admin, Integer> implements AdminDao {

	public AdminDaoHibernate() {
		super(Admin.class);
	}
	
	
	@Override
	public String getPassword(Integer id) {
		return (String) getEntityManager()
				.createQuery(
						"select obj.password from Admin obj where obj.id = :id")
				.setParameter("id", id).getSingleResult();
	}

	@Override
	public Admin getByName(String name) {
		try {
			return (Admin) getEntityManager()
					.createQuery("from Admin obj where obj.firstName = :name")
					.setParameter("name", name).getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}
	
	@Override
	public Admin getByEmail(String email) {
		try {
			return (Admin) getEntityManager()
					.createQuery("from Admin obj where obj.email = :email")
					.setParameter("email", email).getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Admin getByPhoneNumber(String phoneNumber) {
		try {
			return (Admin) getEntityManager()
					.createQuery("from Admin obj where obj.phoneNumber = :phoneNumber")
					.setParameter("phoneNumber", phoneNumber).getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<Admin> getByRole(String userRole) {
		List<Admin> adList = getEntityManager()
				.createQuery(
						"from Admin obj where obj.adminRole = :userRole").setParameter("userRole", userRole).getResultList();
		
		return adList;
	}

}
