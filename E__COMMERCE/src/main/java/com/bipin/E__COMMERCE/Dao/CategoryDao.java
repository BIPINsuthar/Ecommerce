package com.bipin.E__COMMERCE.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.bipin.E__COMMERCE.Dto.Category;
import com.bipin.E__COMMERCE.Dto.Product;


public class CategoryDao 
{
	public int setCategory(Category c)
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
			id=(Integer)s.save(c);
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Category> getAllCategory()
	{
		
		Transaction t=null;
		List<Category> c=null;
		try
		{
			Configuration con=new Configuration().configure().addAnnotatedClass(Category.class).addAnnotatedClass(Product.class);
			SessionFactory sf=con.buildSessionFactory();
			Session s=sf.openSession();
			t=s.beginTransaction();
			String sql="from  Category";
			Query q=s.createQuery(sql);
		    c=q.list();
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
		
		return c;
	}
	

	public Category getCategory(int id)
	{
		Transaction t=null;
		Category c=null;
		try
		{
			Configuration con=new Configuration().configure().addAnnotatedClass(Category.class).addAnnotatedClass(Product.class);
			SessionFactory sf=con.buildSessionFactory();
			Session s=sf.openSession();
			t=s.beginTransaction();
		    c=s.get(Category.class, id);
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
		
		return c;
	}
	
	

}
