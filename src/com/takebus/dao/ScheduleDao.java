package com.takebus.dao;

import java.util.*;

import com.takebus.model.Schedule;

public enum ScheduleDao {

	instance;
	
	private Map<String, Schedule> schedulePool = new HashMap<String, Schedule>();
	
	private ScheduleDao() {
		
	}
}
