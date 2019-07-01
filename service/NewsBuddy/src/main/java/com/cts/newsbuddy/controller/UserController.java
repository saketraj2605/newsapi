package com.cts.newsbuddy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.newsbuddy.entity.LoginStatus;
import com.cts.newsbuddy.entity.SignupStatus;
import com.cts.newsbuddy.entity.User;
import com.cts.newsbuddy.service.UserService;
import com.cts.newsbuddy.service.UserServiceImpl;


@CrossOrigin(origins = "http://localhost:4040")

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;

//@CrossOrigin(origins = {"http://localhost:4040"})
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@GetMapping("/test")
public String test() {
    	System.out.println("inside test");	
		return "inside test";
	}
	
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@PostMapping("/login")
	public LoginStatus Login(@RequestBody User user) {
		System.out.println("login");
		LoginStatus status = userService.authenticate(user);
		return status;
	}
	
@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/signup")
	public SignupStatus signup(@RequestBody User user) {
		System.out.println("inside signup");
		SignupStatus signupStatus = userService.save(user);
		return signupStatus;
	}
	
@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/search")
	public List<User> searchUsers(@RequestBody String searchString) {
		List<User> users = userService.getUsersByName(searchString);
		return users;
	}

@RequestMapping(value = "/list", method = RequestMethod.GET)
public ResponseEntity<List<User>> listUser(){
	System.out.println("listUsers");
	List<User> userList=this.userService.getUsers();
	if(userList==null)
	{
		return new ResponseEntity<List<User>>(userList, HttpStatus.UNAUTHORIZED);
	}
	else
	{
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
}

@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@PostMapping("/blacklist")
	public void blacklist(@RequestBody User user) {
		System.out.println("blacklist");
		userService.blacklist(user);
		
	}



}

