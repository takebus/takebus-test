package com.takebus.dao;

import java.util.*;

import com.takebus.model.User;


public enum UserDao {

	instance;
	private Map<String, User> userPool = new HashMap<String, User>();
	
	private UserDao() {
		User u1 = new User(1, "dean@gmail.com", "123456", "Dean", "Brian", "4051237890", "123 Ame Ave", "Milpita", "CA", "95123", "US", "2015-04-12", "2015-04-12");
		User u2 = new User(2, "richard@gmail.com", "123456", "Richard", "Claderman", "5041237890", "N 1st St", "SF", "CA", "95012", "US", "2015-04-12", "2015-04-12");
		User u3 = new User(3, "allian@gmail.com", "123456", "Allian", "Abthtoms", "4051237890", "E 12th St", "San Jose", "CA", "95112", "US", "2015-04-12", "2015-04-12");
	
		userPool.put("dean@gmail.com", u1);
		userPool.put("richard@gmail.com", u2);
		userPool.put("allian@gmail.com", u3);
	}
	
	public Map<String, User> getModel() {
		return userPool;
	}
}
