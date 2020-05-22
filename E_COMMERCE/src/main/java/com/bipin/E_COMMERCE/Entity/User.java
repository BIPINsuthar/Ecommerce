package com.bipin.E_COMMERCE.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="User_Detail")
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String pass;
	private String email;
	private String phone;
	private String gender;
	private String address;
	@Lob
	private String photo;
	private String type;
	@Temporal(TemporalType.TIMESTAMP)
	private String date;
	
	

}
