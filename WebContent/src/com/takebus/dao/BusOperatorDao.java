package com.takebus.dao;

import java.util.*;

import com.takebus.model.BusOperator;

public enum BusOperatorDao {

	instance;
	private Map<String, BusOperator> busOperatorPool = new HashMap<String, BusOperator>();
	
	private BusOperatorDao() {
		BusOperator b1 = new BusOperator(1, "Capital Bus Tours");
		BusOperator b2 = new BusOperator(2, "HG Bus");
		
		busOperatorPool.put("1", b1);
		busOperatorPool.put("2", b2);
	}
	
	public Map<String, BusOperator> getModel() {
		return busOperatorPool;
	}
}
