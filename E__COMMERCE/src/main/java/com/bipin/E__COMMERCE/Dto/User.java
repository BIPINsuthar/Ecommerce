package com.bipin.E__COMMERCE.Dto;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "User_Detail")

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fname;
	private String lname;
	private String pass;
	private String phone;
	private String email;
	private String date;
	private String gender;
	private String address;
	private String type;
	@Temporal(TemporalType.TIMESTAMP)
	private Date published;

	public User() {

	}

	public User(String fname, String lname, String pass, String phone, String email,String date, String gender,
			String address, String type,Date published) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.pass = pass;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.date=date;
		this.address = address;
		this.type = type;
		this.published=published;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", lname=" + lname + ", pass=" + pass + ", phone=" + phone
				+ ", email=" + email + ", date=" + date + ", gender=" + gender + ", address=" + address + ", type="
				+ type + ", published=" + published + "]";
	}

	

}