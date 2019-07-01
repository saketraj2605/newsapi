package com.cts.newsbuddy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.newsbuddy.dao.UserDAO;
import com.cts.newsbuddy.dao.UserDAOImpl;
import com.cts.newsbuddy.entity.User;

import java.util.List;

import javax.transaction.Transactional;

import com.cts.newsbuddy.entity.LoginStatus;
import com.cts.newsbuddy.entity.Role;
import com.cts.newsbuddy.entity.SignupStatus;
import com.cts.newsbuddy.entity.User;

@Service
public class UserServiceImpl {
	@Autowired
	private UserDAOImpl userDao;
	
	@Transactional
	public LoginStatus authenticate(User user) {
		System.out.println("authentication");
		String actualPassword = "";
		LoginStatus loginStatus = new LoginStatus();
		User actualUser = userDao.findByEmail(user.getEmail());
		System.out.println("hiii"+actualUser);
		if (actualUser != null) {
			System.out.println(actualPassword);
			actualPassword = actualUser.getPassword();
			if (actualPassword.equals(user.getPassword())) {
				loginStatus.setStatus(true);
				loginStatus.setError("");
				loginStatus.setUser(actualUser);
				loginStatus.setRole(actualUser.getRole());
				System.out.println("role"+actualUser.getRole());
			} else {
				
				loginStatus.setStatus(false);
				loginStatus.setError("Invalid Username or Password!");
			}
		} else {
			
			loginStatus.setStatus(false);
			loginStatus.setError("Invalid Credentials!");
		}
		return loginStatus;
	}
	
	
	@Transactional
	public SignupStatus save(User user) {
		SignupStatus signupStatus = new SignupStatus();
System.out.println("inside save service");
		User foundUser =userDao.findByEmail(user.getEmail());
		if (foundUser != null) {
			signupStatus.setStatus(false);
			signupStatus.setError("Email already exists!");
		} else {
			/*Role role = new Role();
			role.setId(2);*/
			user.setRole("user");
			user.setBlacklist(false);
			userDao.save(user);
			signupStatus.setStatus(true);
			signupStatus.setError("");
		}
		return signupStatus;
	}
           
	
	@Transactional
	public List<User> getUsersByName(String searchString) {
		List<User> userList = userDao.findByName(searchString);
		return userList;
	}
	
	@Transactional
	public List<User> getUsers() {
		List<User> userList = userDao.getAllUsers();
		System.out.println("getUsers");
		for (User user : userList) {
			
			System.out.println(user.getEmail());
			System.out.println(user.getName());
			System.out.println(user.getPassword());
			System.out.println(user.getLanguage());
				
		}
		

		
		return userList;
	}
	
	@Transactional
	public void blacklist(User user) {
		if (user.isBlacklist()) {
			System.out.println("inside if");
			user.setBlacklist(false);
			userDao.updateUser(user);
			
		} else {
			System.out.println("inside else");
			user.setBlacklist(true);
			userDao.updateUser(user);
		}
		System.out.println("executed");
	}
}
