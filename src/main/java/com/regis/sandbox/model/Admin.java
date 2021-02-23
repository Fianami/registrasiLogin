package com.regis.sandbox.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "table_admin")
public class Admin {
	
	
	
	private Integer id;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	private String firstName;

	@NotEmpty
	@Column(name = "first_name")
	
	public String getfirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	private String lastName;

	@NotEmpty
	@Column(name = "last_name")
	
	public String getlastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	private String gender;
	@NotEmpty
	@Column(name = "gender", length = 50)
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	private Date dateOfBirth;
	
	@Column(name = "date_of_birth")	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	private String phoneNumber;

	@NotNull
	@Column(name = "phone_number")
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	private String password;

	@NotEmpty
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	private String email;
	
	@NotEmpty
	@Column
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	private String adminRole;
	
	@Column(name = "admin_role")
	public String getAdminrole() {
		return adminRole;
	}

	public void setAdminrole(String adminrole) {
		this.adminRole = adminrole;
	}

	@Override
	public String toString() {
		return "Customer [id =" + id + ", first_name =" + firstName + ", last_name =" + lastName + ", gender =" + gender + ", date_Of_Birth =" + dateOfBirth 
				+ ", phone_number =" + phoneNumber + ",password =" + password + ", email =" + email + ", admin_role =" + adminRole + "]";
	}

}
