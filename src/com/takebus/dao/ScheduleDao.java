package com.takebus.dao;

import java.util.*;

import com.takebus.model.Schedule;

public enum ScheduleDao {

	instance;
	
	private Map<String, Schedule> schedulePool = new HashMap<String, Schedule>();
	
	private ScheduleDao() {
		Schedule s1 = new Schedule(1, "CBT423", 1, "7:20am", 2, "11:30am", 1, 15);
		Schedule s2 = new Schedule(2, "CBT523", 1, "12:50am", 2, "5:00pm", 1, 15);
		Schedule s3 = new Schedule(3, "CBT623", 1, "5:50pm", 2, "10:00pm", 1, 15);
		Schedule s4 = new Schedule(4, "CBT723", 1, "10:30pm", 2, "2:00am", 1, 15);
		
		schedulePool.put("1", s1);
		schedulePool.put("2", s2);
		schedulePool.put("3", s3);
		schedulePool.put("4", s4);
	}
	
	public Map<String, Schedule> getModel() {
		return schedulePool;
	}
}
