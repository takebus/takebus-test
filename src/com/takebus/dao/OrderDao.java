package com.takebus.dao;

import java.util.*;

import com.takebus.model.Order;

public enum OrderDao {

	instance;
	
	private Map<String, Order> orderPool = new HashMap<String, Order>();
	
	private OrderDao() {
		Order o1 = new Order(1, 1, "2015/04/20 15:59:48", "yes");
		Order o2 = new Order(2, 1, "2015/04/27 20:59:48", "yes");
		
		orderPool.put("1", o1);
		orderPool.put("2", o2);
	}
	
	public Map<String, Order> getModel() {
		return orderPool;
	}
}
