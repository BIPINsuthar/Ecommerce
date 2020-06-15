package com.bipin.E__COMMERCE.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Example 
{
	
	@RequestMapping("/")
	public String start()
	{
		return "master";
	}
	@RequestMapping("/demo")
	public String demo()
	{
		return "master";
		
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("/admin")
    public String admin()
    {
		return "admin";
    }
	
	
	@RequestMapping("/home")
	public String home()
	{
		return "master";
	}
	
	
}
