package com.newlife.meetup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newlife.meetup.domain.User;
import com.newlife.meetup.service.IUserService;

@RestController
@RequestMapping({"/sports-meetup/user", "/sports-meetup/user/v1.0"})
public class UserController {
	
	@Autowired
	private IUserService userService;

	/**
	 * verify the phoneNumber when a user is trying to register with the phoneNumber
	 * @param phoneNumber
	 * @return
	 */
	@GetMapping("/checkUser/{phoneNumber}")
	public String checkUser(@PathVariable String phoneNumber){
		
		return this.userService.checkUser(phoneNumber);
	}
	
	/**
	 * add the user into db when the user use a variable phoneNumber to register
	 * @param user
	 * @return
	 */
	//add User
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
	/**
	 * check the user when a user tries to login
	 * @param user
	 * @return
	 */
	@RequestMapping("/checkUser")
	public String checkUser(@RequestBody User user) {
		return this.userService.checkUser(user);
	}
	
}
