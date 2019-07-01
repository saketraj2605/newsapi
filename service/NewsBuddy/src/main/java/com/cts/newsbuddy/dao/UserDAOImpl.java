package com.cts.newsbuddy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.newsbuddy.entity.User;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * method to search user by id.
	 * @param email
	 * @return
	 */
	public User findByEmail(String email) {
		User result=null;
		List<User> user = null;
		System.out.println("finding user");
		try{
			Session session = sessionFactory.getCurrentSession();
			user = session.createQuery("FROM User").list();
			System.out.println(user);
			for(User users : user)
			{
			if(users.getEmail().equals(email)){
			result=users;
			}
			}
			if(result==null)
			{
				System.out.println("Email Id does not exist");
			}
			
			
			
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * method to save new user in database.
	 * @param user
	 */
	public void save(User user) {
		Session session = sessionFactory.openSession();
		session.save(user);
		session.close();
	}
	
	
	/**
	 * method to find user in database by name.
	 * @param searchString.
	 */
	public List<User> findByName(String searchString) {
		Session session = sessionFactory.openSession();		
		List<User> users = session.createQuery("FROM User").list();
		List<User> result = null ;
		for (User user : users) {
			if(user.getName().equals(searchString)) {
				result.add(user);
			}
		}
		session.close();
		return result;
	}
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession().createQuery("from User where role='user'").list();

		if (users.size() > 0) {
			return users;
		} else {
			return null;
		}
	}
	
	public void updateUser(User user)
	{
		User userData= user;
		sessionFactory.getCurrentSession().update(userData);
	}
	
}
