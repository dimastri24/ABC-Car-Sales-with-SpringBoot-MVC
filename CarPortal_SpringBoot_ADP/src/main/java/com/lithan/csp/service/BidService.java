package com.lithan.csp.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lithan.csp.entity.CarBidding;
import com.lithan.csp.entity.Cars;
import com.lithan.csp.entity.Users;
import com.lithan.csp.repository.CarBidRepo;
import com.lithan.csp.repository.CarRepo;
import com.lithan.csp.repository.UserRepo;

@Service
@Transactional
public class BidService {
	
	@Autowired
	private CarBidRepo bidRepo;
	
	@Autowired
	private CarRepo carRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	public CarBidding save(BigDecimal bitprice, long id) {
		String uname = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			uname = ((UserDetails) principal).getUsername();
		} else {
			uname = principal.toString();
		}

		Cars car = carRepo.findById(id).get();
		Users user = userRepo.findByUserName(uname);
		
		Date curdate = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		//dateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
		String curdateStr = dateformat.format(curdate);
		Date savedate = null;
		try {
			savedate = dateformat.parse(curdateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		CarBidding carBitInfo = new CarBidding();
		/* carBitInfo.setBidderName(uname); */
		carBitInfo.setBidderPrice(bitprice);
		carBitInfo.setCar(car);
		carBitInfo.setUser(user);
		carBitInfo.setBidDate(savedate);

		return bidRepo.save(carBitInfo);
	}
	
	public List<CarBidding> listAllBidInfo(Cars car){
		return bidRepo.findByCarId(car);
	}

}
