package com.bipin.E__COMMERCE.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.bipin.E__COMMERCE.Dto.Category;
import com.bipin.E__COMMERCE.Dto.Product;




public class ProductDao
{
	public int setProduct(Product p)
	{
		Transaction t=null;
		int id=0;
		try
		{ 
			//org.hibernate.AnnotationException: Use of @OneToMany or @ManyToMany targeting an unmapped class: com.bipin.Web_Frontend.dto.Category.product[com.bipin.Web_Frontend.dto.Product]
            //when addAnnotatedClass(Product.class) not use
			Configuration con=new Configuration().configure().addAnnotatedClass(Category.class).addAnnotatedClass(Product.class);
			SessionFactory sf=con.buildSessionFactory();
			Session s=sf.openSession();
			t=s.beginTransaction();
			id=(Integer)s.save(p);
			t.commit();
			s.close();	
		}
		catch(Exception e)
		{
			if(t!=null)
			{
				t.rollback();
			}
			System.out.println(e);
		}
		return id;
		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Product> getAllproduct()
	{
		Transaction t=null;
		List<Product> p=null;
		try
		{ 
			//org.hibernate.AnnotationException: Use of @OneToMany or @ManyToMany targeting an unmapped class: com.bipin.Web_Frontend.dto.Category.product[com.bipin.Web_Frontend.dto.Product]
            //when addAnnotatedClass(Product.class) not use
			Configuration con=new Configuration().configure().addAnnotatedClass(Category.class).addAnnotatedClass(Product.class);
			SessionFactory sf=con.buildSessionFactory();
			Session s=sf.openSession();
			t=s.beginTransaction();
			Query q=s.createQuery("from Product");
		    p=q.list();
			t.commit();
			s.close();	
		}
		catch(Exception e)
		{
			if(t!=null)
			{
				t.rollback();
			}
			System.out.println(e);
		}
		
		return p;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Product> getAllproductbyId(int cId)
	{
		Transaction t=null;
		List<Product> p=null;
		try
		{ 
			//org.hibernate.AnnotationException: Use of @OneToMany or @ManyToMany targeting an unmapped class: com.bipin.Web_Frontend.dto.Category.product[com.bipin.Web_Frontend.dto.Product]
            //when addAnnotatedClass(Product.class) not use
			Configuration con=new Configuration().configure().addAnnotatedClass(Category.class).addAnnotatedClass(Product.class);
			SessionFactory sf=con.buildSessionFactory();
			Session s=sf.openSession();
			t=s.beginTransaction();
			Query q=s.createQuery("from Product as p where p.category.cId=:id");
			q.setParameter("id",cId);
		    p=q.list();
			t.commit();
			s.close();	
		}
		catch(Exception e)
		{
			if(t!=null)
			{
				t.rollback();
			}
			System.out.println(e);
		}
		
		return p;
	}


}
