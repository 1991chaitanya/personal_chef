package com.springsample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springsample.pojo.User;

@Controller
public class LoginController {
	
	@RequestMapping(value = "show-login.htm", method=RequestMethod.GET)
	public ModelAndView showLogin(@RequestParam(value = "error", required=false) String isError, @RequestParam(value = "logout", required=false) String isLogout) {
		ModelAndView modelAndView = new ModelAndView("login2");
		if (isError != null) {
			modelAndView.addObject("error", "Invalid Credentials");
		}
		
		if (isLogout != null) {
			modelAndView.addObject("logout", "Logged Out");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "show-home.htm", method=RequestMethod.GET)
	public ModelAndView showHome() {
		return new ModelAndView("home");
	}
	
	/*@RequestMapping(value = "login.htm", method=RequestMethod.POST)
	public @ResponseBody ModelAndView login(@ModelAttribute("user") User user) {
		System.out.println("Username: "+ user.getUsername());
		System.out.println("Password: "+ user.getPassword());
		ModelAndView view = new ModelAndView("home");
		view.addObject("result", "Sucessful login..");
		return view;
	}*/

}
