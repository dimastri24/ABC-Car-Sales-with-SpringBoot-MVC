package com.lithan.csp.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lithan.csp.entity.Users;
import com.lithan.csp.repository.RoleRepo;
import com.lithan.csp.repository.UserRepo;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired 
	private RoleRepo roleRepo;
	
	public void addUser(Users user) {
		user.setRoles(new HashSet<>(roleRepo.findBySpecificRoles("Users")));
		userRepo.save(user);
	}
	
	public List<Users> listAllUsers() {
		return userRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
	public Users getUserById(Long id) {
		return userRepo.findById(id).get();
	}
	
	public Users getByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}
	
	public void updateUser(Users user) {
		Users newuser = userRepo.findById(user.getId()).get();
		newuser.setName(user.getName());
		newuser.setAddress(user.getAddress());
		newuser.setPhoneNumber(user.getPhoneNumber());
		userRepo.save(newuser);
	}
	
	public void editUser(Users user) {
		Users newuser = userRepo.findById(user.getId()).get();
		newuser.setName(user.getName());
		newuser.setAddress(user.getAddress());
		newuser.setPhoneNumber(user.getPhoneNumber());
		newuser.setUserName(user.getUserName());
		newuser.setEmail(user.getEmail());
		newuser.setPassword(user.getPassword());
		userRepo.save(newuser);
	}
	
	public void becomeAdmin(Long id) {
		Users newuser = userRepo.findById(id).get();
		newuser.setRoles(new HashSet<>(roleRepo.findBySpecificRoles("Admin")));
		userRepo.save(newuser);
	}
	
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}

}
