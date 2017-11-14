package com.springsample.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.springsample.pojo.User;

@Repository
public class UserDao {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	/*@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession()
			.createQuery("from user where username=?")
			.setParameter(0, username)
			.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}*/
	
	public User findByUserName(String username) {
         User user =  mongoTemplate.findOne(new Query(Criteria.where("username").is(username)), User.class);
	     return user;
	}
	
	
}
