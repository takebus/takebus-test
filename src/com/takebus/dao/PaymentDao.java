package com.takebus.dao;

import java.util.*;

import com.takebus.model.Payment;


public enum PaymentDao {

	instance;
	private Map<String, Payment> paymentPool = new HashMap<String, Payment>();
	
	private PaymentDao() {
		
		Payment p1 = new Payment(1, 60, "Dean", "Brian", "masterCard", "4123091230123540", "781", "07/18", "123 Ame Ave", "123 Ame Ave", "Milpita", "CA", "95123", "US");
		Payment p2 = new Payment(2, 15, "Richard", "Claderman", "visa", "1234567890121000", "018", "10/20", "N 1st St", "N 1st St", "SF", "CA", "95012", "US");
		Payment p3 = new Payment(3, 15, "Allian", "Abthtoms", "discover", "2000000010001999", "888", "01/18", "E 12th St", "E 12th St", "San Jose", "CA", "95112", "US");
		
		
		paymentPool.put("1", p1);
		paymentPool.put("2", p2);
		paymentPool.put("3", p3);
	}
	
	public Map<String, Payment> getModel() {
		return paymentPool;
	}
}
