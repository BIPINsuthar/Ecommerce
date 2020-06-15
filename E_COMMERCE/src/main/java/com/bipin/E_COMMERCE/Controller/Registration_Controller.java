package com.bipin.E_COMMERCE.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bipin.E_COMMERCE.Entity.User;

@Controller
public class Registration_Controller {
	@RequestMapping("registration")
	public String registration(@ModelAttribute("regi") User u) {
		return "Registration";
	}

	@RequestMapping("registration-from")
	public String registrationform(@ModelAttribute("regi") User u, BindingResult result) {
		Date d = new Date();
		u = new User(u.getName(), u.getPass(), u.getEmail(), u.getPhone(), u.getGender(), u.getAddress(), u.getPhoto(),
				"normal", d);

		// fetching hibernate validation error
		if (result.hasErrors()) {
			List<ObjectError> res = result.getAllErrors();
			for (ObjectError e : res) {
				System.out.println("Error::" + e);
			}

			return "registration";
		} else {
			return "result";
		}

	}

}
