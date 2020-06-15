package com.bipin.E__COMMERCE.Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pId;
	private String pTitle;
	private String pDesc;
	private String pPhoto;
	private String pPrice;
	private String pDiscount;
	private String pQuanity;
	
	@ManyToOne
	private Category category;
	
    
	public Product() 
	{
		
	}

	//constructor
	public Product(String pTitle, String pDesc, String pPhoto, String pPrice, String pDiscount,
			String pQuanity, Category category) {
		super();
		this.pTitle = pTitle;
		this.pDesc = pDesc;
		this.pPhoto = pPhoto;
		this.pPrice = pPrice;
		this.pDiscount = pDiscount;
		this.pQuanity = pQuanity;
		this.category = category;
	}
    
	public Product(String pTitle, String pDesc, String pPhoto, String pPrice, String pDiscount,
			String pQuanity) {
		super();
		this.pTitle = pTitle;
		this.pDesc = pDesc;
		this.pPhoto = pPhoto;
		this.pPrice = pPrice;
		this.pDiscount = pDiscount;
		this.pQuanity = pQuanity;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpTitle() {
		return pTitle;
	}
	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}
	public String getpDesc() {
		return pDesc;
	}
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}
	public String getpPhoto() {
		return pPhoto;
	}
	public void setpPhoto(String pPhoto) {
		this.pPhoto = pPhoto;
	}
	public String getpPrice() {
		return pPrice;
	}
	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}
	public String getpDiscount() {
		return pDiscount;
	}
	public void setpDiscount(String pDiscount) {
		this.pDiscount = pDiscount;
	}
	public String getpQuanity() {
		return pQuanity;
	}
	public void setpQuanity(String pQuanity) {
		this.pQuanity = pQuanity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pTitle=" + pTitle + ", pDesc=" + pDesc + ", pPhoto=" + pPhoto + ", pPrice="
				+ pPrice + ", pDiscount=" + pDiscount + ", pQuanity=" + pQuanity + ", category=" + category + "]";
	}

    

}
