package com.bipin.E__COMMERCE.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bipin.E__COMMERCE.Dao.LoginDao;
import com.bipin.E__COMMERCE.Dto.User;

@Controller
public class Login 
{
	@RequestMapping("/loginpage")
	public String login(HttpServletRequest req,HttpServletResponse res)
	{
		String user=req.getParameter("user");
		String pass=req.getParameter("pass");
		
		LoginDao ld=new LoginDao();
		User u=ld.getuser(user, pass);
		
		System.out.println("User::"+u);
		HttpSession h=req.getSession();
		
		if(u==null)
		{
			h.setAttribute("message","Invalid Details!!");
			return "login";
		}
		else
		{
			h.setAttribute("current-user",u);
			System.out.println("login thai ju se"+u);
			if(u.getType().equals("normal"))
			{
				h.setAttribute("message","Login Successfully done!");
				return "master";
 			}
			
	        else if(u.getType().equals("admin"))
			{
	        	h.setAttribute("message","Admin Login successfully done!");
			    return "admin";	
			}
	        else
	        {
	        	h.setAttribute("message","we have not identified user type");
	        }
			
			return "master";
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req,HttpServletResponse res)
	{
		//User u=(User)req.getAttribute("");
		//for prevent back button
		HttpSession h=req.getSession();
		h.removeAttribute("current-user");
		h.setAttribute("message","your are logout!");
		return "login";
	}



}
