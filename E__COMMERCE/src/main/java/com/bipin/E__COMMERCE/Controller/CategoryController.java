package com.bipin.E__COMMERCE.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bipin.E__COMMERCE.Dao.CategoryDao;
import com.bipin.E__COMMERCE.Dto.Category;


@Controller
public class CategoryController 
{

	@RequestMapping("category")
	public String add(HttpServletRequest req,HttpServletResponse res)
	{
		String title=req.getParameter("title");
		String description=req.getParameter("description");
		Category c=new Category(title,description);
		CategoryDao d=new CategoryDao();
		int id=d.setCategory(c);
		HttpSession h=req.getSession();
	    h.setAttribute("message","category added succesfully! ID="+id);
        return "admin";
		
	}

}
