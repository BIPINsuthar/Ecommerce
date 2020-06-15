package com.bipin.E__COMMERCE.Dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cId;
	private String cTitle;
	private String cDescription;
	
	@OneToMany(mappedBy="category",fetch=FetchType.EAGER)
	private List<Product> product=new ArrayList<Product>();
	
	
 
	public Category() 
	{
		
	}

	public Category(String cTitle, String cDescription) {
		super();
		this.cTitle = cTitle;
		this.cDescription = cDescription;
	}

	public Category(int cId, String cTitle, String cDescription, List<Product> product) {
		super();
		this.cId = cId;
		this.cTitle = cTitle;
		this.cDescription = cDescription;
		this.product = product;
	}
	
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcTitle() {
		return cTitle;
	}
	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}
	public String getcDescription() {
		return cDescription;
	}
	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Category [cId=" + cId + ", cTitle=" + cTitle + ", cDescription=" + cDescription + ", product=" + product
				+ "]";
	}
	
	
	

}
