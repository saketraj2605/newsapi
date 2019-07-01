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

//
//@CrossOrigin(origins = "http://localhost:4040")
//
//@RestController
//@RequestMapping("/language")

//public class LanguageController {
//	@CrossOrigin(origins = "http://localhost:4200")
//	//@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
//		@PostMapping("/list")
//		public LoginStatus Login(@RequestBody User user) {
//			System.out.println("list");
//			LoginStatus status = userService.authenticate(user);
//			return status;
//		}
//}
