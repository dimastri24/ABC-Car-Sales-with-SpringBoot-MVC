package com.lithan.csp.auth;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lithan.csp.entity.Roles;
import com.lithan.csp.entity.Users;
import com.lithan.csp.repository.UserRepo;

@Transactional
public class UserDetailServiceImpl implements UserDetailsService{
	
	//private static Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);
	
	@Autowired
	private UserRepo usersRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserDetailServiceImpl() {
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//logger.info("****** Login UserName: "+username+" ******");
		Users users = usersRepo.findByUserName(username);
		
		System.out.println("************ Hello Is this working?? *************");
		System.out.println(username);
		
		if(users == null) {
			throw new UsernameNotFoundException("user " + username + " is not valid. Please re-enter.");
		}
		
		org.springframework.security.core.userdetails.User.UserBuilder userBuilder = org.springframework.security.core.userdetails.User.builder();
		
		String[] roleNames = users.getRoles().stream().map(Roles::getName).toArray(String[]::new);
		
		//logger.info("Role name: " + roleNames);
		
		return userBuilder.username(users.getUserName())
						  .password(users.getPassword())
						  .roles(roleNames)
						  .passwordEncoder(passwordEncoder::encode)
						  .build();
	}

}
