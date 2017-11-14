package com.springsample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springsample.dao.UserDao;
import com.springsample.pojo.User;

public class CustomUserService implements UserDetailsService{

	//get user from the database, via Hibernate
		@Autowired
		private UserDao userDao;

	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  User user = userDao.findByUserName(username);
			return buildUserForAuthentication(user, getAuthorities(null));
	}
		
		

		// Converts com.mkyong.users.model.User user to
		// org.springframework.security.core.userdetails.User
		private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user,
			List<SimpleGrantedAuthority> authorities) {
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					true, true, true, true, authorities);
		}

	  
	  private List<SimpleGrantedAuthority> getAuthorities(String role) {
	        List<SimpleGrantedAuthority> authList = new ArrayList<SimpleGrantedAuthority>();
	        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
	 
	        //you can also add different roles here
	        //for example, the user is also an admin of the site, then you can add ROLE_ADMIN
	        //so that he can view pages that are ROLE_ADMIN specific
	        if (role != null && role.trim().length() > 0) {
	            if (role.equals("admin")) {
	                authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	            }
	        }
	 
	        return authList;
	    }
}
