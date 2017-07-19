package com.newlife.meetup.service;

import org.springframework.stereotype.Service;

import com.newlife.meetup.domain.User;

@Service
public interface IUserService {

	String checkUser(String phoneNumber);

	String addUser(User user);

	String checkUser(User user);

}
