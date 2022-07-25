package com.lithan.csp.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lithan.csp.entity.CarBidding;
import com.lithan.csp.entity.Cars;
import com.lithan.csp.entity.Users;
import com.lithan.csp.service.BidService;
import com.lithan.csp.service.CarService;

@Controller
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private BidService bidService;
	
	@RequestMapping(value = "cars", method = RequestMethod.GET)
	public ModelAndView listAllCar(ModelAndView mav) {
		List<Cars> listcars = carService.listAllCars();
		if(!CollectionUtils.isEmpty(listcars)) {
			mav.addObject("listcars", listcars);
		} else {
			mav.addObject("list_empty", "Sorry. The Car List is empty");
		}
		
		mav.setViewName("view_cars");
		return mav;
	}
	
	@RequestMapping(value = "all_cars", method = RequestMethod.GET)
	public ModelAndView listAllCars(ModelAndView mav) {
		List<Cars> listcars = carService.listAllCars();
		if(!CollectionUtils.isEmpty(listcars)) {
			mav.addObject("listcars", listcars);
		} else {
			mav.addObject("list-empty", "Sorry. The Car List is empty");
		}
		
		mav.setViewName("all_cars");
		return mav;
	}
	
    @RequestMapping(value="new_car",  method= RequestMethod.GET)
    public ModelAndView newCarForm(@ModelAttribute("car") Cars car, ModelAndView mav) {
    	mav.setViewName("form_new_car");
    	return mav;
    }
    
    @RequestMapping(value="edit_car",  method= RequestMethod.GET)
    public ModelAndView editCarForm(@RequestParam long id, ModelAndView mav) {
    	Cars car = carService.getCarById(id);
    	mav.addObject("car", car);
    	mav.setViewName("form_edit_car");
    	return mav;
    }
    
    @RequestMapping(value = "save_car", method = RequestMethod.POST)
    public ModelAndView saveCar(@ModelAttribute("car") Cars car, ModelAndView mav) {
    	
    	if(car.getId() == null) {
    		carService.addCar(car);
    	} else {
    		carService.editCar(car);
    	}
    	
    	mav.setViewName("redirect:cars");
    	return mav;
    }
    
    @RequestMapping(value = "car_detail", method = RequestMethod.GET)
    public ModelAndView viewCar(@RequestParam long id, ModelAndView mav) {
    	Cars car = carService.getCarById(id);
    	List<CarBidding> bidinfo = bidService.listAllBidInfo(car);
    	Users user = car.getUser();
    	mav.addObject("car", car);
    	mav.addObject("bidinfo", bidinfo);
    	mav.addObject("user", user);
    	mav.setViewName("car_detail");
    	
    	return mav;
    }
    
    @RequestMapping(value = "delete_car")
    public ModelAndView deleteCar(@RequestParam long id, ModelAndView mav) {
    	carService.deleteCar(id);
    	mav.setViewName("redirect:cars");
    	return mav;
    }
    
    @RequestMapping(value = "deactivate_car")
    public ModelAndView deactivateCar(@RequestParam long id, ModelAndView mav) {
    	carService.inactiveCar(id);
    	mav.setViewName("redirect:cars");
    	return mav;
    }
    
    @RequestMapping(value = "activate_car")
    public ModelAndView activateCar(@RequestParam long id, ModelAndView mav) {
    	carService.activeCar(id);
    	mav.setViewName("redirect:cars");
    	return mav;
    }
    
    @RequestMapping(value = "car_detail", method = RequestMethod.POST)
    public ModelAndView saveBit(@RequestParam(value="id") long id,
    							@RequestParam("bitprice") BigDecimal bitprice,
    							ModelAndView mav) {
    	bidService.save(bitprice, id);
    	
    	Cars car = carService.getCarById(id);
    	List<CarBidding> bidinfo = bidService.listAllBidInfo(car);
    	Users user = car.getUser();
    	mav.addObject("car", car);
    	mav.addObject("bidinfo", bidinfo);
    	mav.addObject("user", user);
    	
    	mav.setViewName("car_detail");
    	return mav;
    }
    
    @RequestMapping(value = "search_param")
    public ModelAndView searchWithKey(@RequestParam(value = "keyword", required = false) String keyword,
    								  ModelAndView mav) {
    	List<Cars> result = carService.searchByParam(keyword);
    	
    	if(result == null || result.isEmpty()) {
    		mav.addObject("msg_result", "Sorry we couldn't find any result for '"+keyword+"'");
    	} else {
    		mav.addObject("msg_result", "Result of your search for '"+keyword+"'");
    		mav.addObject("listcars", result);
    	}
    	mav.setViewName("search_result");
    	return mav;
    }
    
    @RequestMapping(value = "search_price")
    public ModelAndView searchWithPrice(@RequestParam(value = "min", required = false) BigDecimal min,
    									@RequestParam(value = "max", required = false) BigDecimal max,
    									ModelAndView mav) {
    	List<Cars> result = carService.searchByPrice(min, max);
    	
    	if(result == null || result.isEmpty()) {
    		mav.addObject("msg_result", "Sorry we couldn't find any result");
    	} else {
    		mav.addObject("msg_result", "Result of your search");
    		mav.addObject("listcars", result);
    	}
    	mav.setViewName("search_result");
    	return mav;
    }

}
