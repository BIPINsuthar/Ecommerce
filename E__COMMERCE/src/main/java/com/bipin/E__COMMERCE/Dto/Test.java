package com.bipin.E__COMMERCE.Dto;

import javax.servlet.http.HttpServletRequest;

public class Test 
{
	
	
	/* @SuppressWarnings({ "unchecked", "rawtypes" })
	public User getuser()
     {
        
		User o1=null;
		try {
			String n = "sutharnikul146@gmail.com";
			String p = "nikul@123";
			Configuration c = new Configuration().configure().addAnnotatedClass(User.class);
			SessionFactory sf = c.buildSessionFactory();
			Session session = sf.openSession();
			Transaction t=session.beginTransaction();
			Query q = session.createQuery(" from User_Detail where email=:n and pass=:p ");
			q.setParameter("n",n);
			q.setParameter("p",p);
		   // l=(List<Object>)q.list();
			 o1=(User)q.uniqueResult();
			System.out.println("value::"+o1);
			//System.out.println(l);
			t.commit();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return o1;
		
     }
	public static void main(String args[])
	{
		
		Test t=new Test();
		User o=t.getuser();
		System.out.println("value is::"+o);
       

	}*/
	
	
	@SuppressWarnings({ })
	public static void main(String args[],HttpServletRequest req)
	{
		

		/*CategoryDao d=new CategoryDao();
		List<Category> list=d.getCategory();
		for(Category l:list)
		{
			System.out.println(l.getcTitle());
		}
		*/
		
		
		
		/*String title="hay";
		String description="dfk";
		Category c=new Category(title,description);
		CategoryDao d=new CategoryDao();
		int id=d.setCategory(c);
		*/
		/*
		Category c=new Category("mobile","this is mobile description");
		Product p=new Product("leptop dell i5","leptop","m.png","1","2","3",c);
		
		Configuration con=new Configuration().configure().addAnnotatedClass(Product.class).addAnnotatedClass(Category.class);
		SessionFactory sf=con.buildSessionFactory();
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		session.save(p);
		session.save(c);
		t.commit();
		session.close();
		System.out.println("succesfully done!");
		*/
		//System.out.println("done"+id);*/
		
		/*int id=2;
		
		Configuration con=new Configuration().configure().addAnnotatedClass(Category.class).addAnnotatedClass(Product.class);
		SessionFactory sf=con.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Category c=s.get(Category.class, id);
		t.commit();
		System.out.println(c);
		s.close();
		*/
		/*
		Configuration con=new Configuration().configure().addAnnotatedClass(Category.class).addAnnotatedClass(Product.class);
		SessionFactory sf=con.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		int id=(Integer)s.save(p);
		t.commit();
		s.close();	
		*/
		/*
		try
		{
		Configuration con=new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory sf=con.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Query q=s.createQuery("from Product");
		List<Product> p=q.list();
		System.out.println("product is here:"+p);
		t.commit();
		s.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}*/
		
	}
}
