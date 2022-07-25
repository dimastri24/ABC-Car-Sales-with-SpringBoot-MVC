package com.lithan.csp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lithan.csp.entity.Users;
import com.lithan.csp.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
    @RequestMapping(value="register",  method= RequestMethod.GET)
    public ModelAndView regisPage(@ModelAttribute("user") Users user, ModelAndView mav) {
    	mav.setViewName("form_regis_user");
    	return mav;
    }
    
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView	newUser(@ModelAttribute("user") Users user, ModelAndView mav) {
    	
    	Users checkdupe = userService.getByUserName(user.getUserName());
    	
    	if (checkdupe != null) {
    		mav.addObject("msg_dupe", "Username already used. Please create another one");
    		mav.setViewName("form_regis_user");
    		return mav;
    	} else {
    		userService.addUser(user);
    		String name = user.getName();
    		mav.addObject("name", name);
    		mav.setViewName("thankyou");
    		return mav;    		
    	}    	
    }

}
