package com.lithan.csp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lithan.csp.entity.Cars;
import com.lithan.csp.entity.Users;
import com.lithan.csp.service.CarService;
import com.lithan.csp.service.UserService;

@Controller
public class ProfileController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CarService carService;
	
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public ModelAndView viewProfile(ModelAndView mav) {
		String uname = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			uname = ((UserDetails) principal).getUsername();
		} else {
			uname = principal.toString();
		}
		
		Users user = userService.getByUserName(uname);
		List<Cars> cars = carService.listCarsUser(user);
		mav.addObject("userinfo", user);
		mav.addObject("cars", cars);
		mav.setViewName("view_profile");
		
		return mav;
	}
	
	@RequestMapping(value = "update_profile", method = RequestMethod.GET)
	public ModelAndView loadUpdateProfile(@RequestParam long id, ModelAndView mav) {
		Users user = userService.getUserById(id);
		mav.addObject("user", user);
		mav.setViewName("form_update_profile");
		
		return mav;
	}
	
    @RequestMapping(value = "update_profile", method = RequestMethod.POST)
    public ModelAndView	saveUpdateUser(@ModelAttribute("user") Users user, ModelAndView mav) {
    	userService.updateUser(user);
    	mav.setViewName("redirect:profile");
    	return mav;
    }

}
