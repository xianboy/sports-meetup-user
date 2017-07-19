package com.newlife.meetup.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlife.meetup.domain.User;
import com.newlife.meetup.repository.UserRepository;
import com.newlife.meetup.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	//valid phoneNumber
	@Override
	public String checkUser(String phoneNumber) {
		String result = "N";
		try {
			 List<User> users = this.userRepository.findUserByPhoneNumber(phoneNumber);
			 if(users.size()>0) {
				 result = "Y";
			 }
		}catch (Exception e) {
			LOGGER.debug("Some issue occurred while running method checkUser()");
			e.getCause();
		}
		return result;
	}
	
	//addUser 
	@Override
	public String addUser(User user) {
		String usable = checkUser(user.getPhoneNumber());
		try {
			if(!usable.equals("Y")) {
				this.userRepository.save(user);
			}
		}catch (Exception e) {
			return "faild";
		}
		
		return "success";
	}
	

	@Override
	public String checkUser(User user) {
		User user2 = findUserByPhoneNumber(user.getPhoneNumber());
		if(user.equals(user2)) {
			return "Y";
		}else {
			return "N";
		}
	}
	
	public User findUserByPhoneNumber(String phoneNumber){
		List<User> users = this.userRepository.findUserByPhoneNumber(phoneNumber);
		if(users.size()!=0) {
			return users.get(0);
		}else {
			return null;
		}
	}
	
}
